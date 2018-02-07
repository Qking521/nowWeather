package com.king.weather;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.king.weather.data.CityInfo;
import com.king.weather.data.DownloadCity;
import com.king.weather.data.DownloadWeather;
import com.king.weather.data.LocationByBD;
import com.king.weather.data.WeatherInfo;
import com.king.weather.data.WeatherManager;
import com.king.weather.data.WeatherUtil;
import com.king.weather.utils.PermissionCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCityActivity extends AppCompatActivity {

    public static final String TAG = "wq";

    private SearchView mSearchView;
    private ListView mSearchResultListView;
    private TextView mCurrentLocationCity;

    private String mSelectedCityName;
    private String cityName;
    private List<CityInfo> mCityInfoList = new ArrayList<>();
    private WeatherManager mWeatherManager;
    private InputMethodManager mInputMethodManager;
    private ResultCityAdapter mResultCityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        mWeatherManager = new WeatherManager();
        mInputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        initViews();
        initViewsListener();
        checkLocationPermission();
    }

    private void checkLocationPermission() {
        if (!PermissionCheck.isPermissionGranted(AddCityActivity.this, PermissionCheck.PERMISSION_ACCESS_FINE_LOCATION)) {
            PermissionCheck.requsetPermission(AddCityActivity.this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PermissionCheck.PERMISSION_REQUSTCODE_LOCATION);
        } else {
            location();
        }
    }

    private void initViewsListener() {
        mCurrentLocationCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWeatherManager.downloadCityInfo(mCurrentLocationCity.getText().toString(), mDownLoadCityListener);
            }
        });
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("wq", "onQueryTextSubmit:query="+ query);
                mInputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                if (!WeatherUtil.isNetworkValid(AddCityActivity.this)) {
                    WeatherUtil.showToast(AddCityActivity.this, "network error, please check");
                    return true;
                }
                mWeatherManager.downloadCityInfo(query.trim(), mDownLoadCityListener);
                return true;
            };

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        mSearchResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectedCityName = mCityInfoList.get(position).getCityName();
                mWeatherManager.downloadWeatherInfo(Arrays.asList(mCityInfoList.get(position)),  mDownLoadWeatherListener);
            }
        });
    }

    private void initViews() {
        mCurrentLocationCity = (TextView) findViewById(R.id.add_city_current_location);
        mSearchView = (SearchView) findViewById(R.id.add_city_searchview);
        mSearchResultListView = (ListView) findViewById(R.id.add_listview);
        mResultCityAdapter = new ResultCityAdapter(this, mCityInfoList);
        mSearchResultListView.setAdapter(mResultCityAdapter);
    }


    private void location() {
        Log.d(TAG, "location: ");
        final LocationByBD locationByBD = new LocationByBD(this);
        locationByBD.startBaiDuLocationService(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                String locationCity = bdLocation.getCity();
                Log.d(TAG, "onReceiveLocation: " + locationCity == null ? "locationCity null" : locationCity);
                if (!TextUtils.isEmpty(locationCity)) {
                    mCurrentLocationCity.setVisibility(View.VISIBLE);
                    mCurrentLocationCity.setText("current location city is : "+ bdLocation.getCity());
                } else {
                    mCurrentLocationCity.setVisibility(View.GONE);
                }
                locationByBD.stopBaiDuLocationService();
            }

            @Override
            public void onConnectHotSpotMessage(String s, int i) {
                Log.d(TAG, "onConnectHotSpotMessage: ");
                mCurrentLocationCity.setText(s.trim());
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionCheck.onRequestPermissionResultCallback(requestCode, permissions, grantResults);
        if (requestCode == PermissionCheck.PERMISSION_REQUSTCODE_LOCATION) {
            if (PermissionCheck.RESULT_REQUSTCODE_LOCATION) {
                location();
            } else {
                PermissionCheck.shouldShowRequestPermissionRationale(this, permissions[0], getString(R.string.permission_rational_message));
            }
        }
    }

    private DownloadCity.DownLoadCityListener mDownLoadCityListener = new DownloadCity.DownLoadCityListener() {
        @Override
        public void onCityDownLoadResult(ArrayList<CityInfo> cityInfoList) {

            if (mCityInfoList != null) mCityInfoList.clear();
            mCityInfoList.addAll(cityInfoList);
            mSearchResultListView.setVisibility(View.VISIBLE);
            mResultCityAdapter.notifyDataSetChanged();

        }
    };

    private DownloadWeather.DownLoadWeatherListener mDownLoadWeatherListener = new DownloadWeather.DownLoadWeatherListener() {
        @Override
        public void onWeatherUpdateFailed(int paramInt) {
            Toast.makeText(AddCityActivity.this, "weather update failed " + paramInt, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onWeatherUpdatedSuccess(List<WeatherInfo> reqWeatherDataList) {
            mWeatherManager.addWeatherInfos(reqWeatherDataList.get(0));
            setResult(Activity.RESULT_OK);
            finish();
        }
    };

    class ResultCityAdapter extends BaseAdapter {

        private List<CityInfo> cityInfoList;
        private Context context;
        private LayoutInflater layoutInflater;

        public ResultCityAdapter(Context context, List<CityInfo> cityInfoList) {
            this.context = context;
            this.cityInfoList = cityInfoList;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return cityInfoList.size();
        }

        @Override
        public Object getItem(int position) {
            return cityInfoList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CityInfo cityInfo = (CityInfo) getItem(position);
            if (convertView == null) {
                convertView = layoutInflater.inflate(android.R.layout.simple_list_item_1, null);
            }
            TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
            textView.setText(cityInfo.getCityName() + " " + cityInfo.getProvince() + "," + cityInfo.getCountry());
            return convertView;
        }
    }
}
