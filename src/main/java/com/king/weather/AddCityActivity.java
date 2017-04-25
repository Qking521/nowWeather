package com.king.weather;

import android.content.Context;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.king.weather.data.CityInfo;
import com.king.weather.data.DownloadCity;
import com.king.weather.data.DownloadWeather;
import com.king.weather.data.LocationByBD;
import com.king.weather.data.WeatherForecastInfo;
import com.king.weather.data.WeatherInfo;
import com.king.weather.utils.PermissionCheck;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCityActivity extends AppCompatActivity {

    private EditText mCityEditText;
    private Button mAddCityButton;
    private Button mLocationButton;
    private ListView mSearchResultListView;

    private String mSelectedCityName;
    private String cityName;
    private List<CityInfo> mCityInfoList = new ArrayList<>();

    private DownloadCity mDownloadCity;
    private DownloadWeather mDownloadWeather;
    private InputMethodManager mInputMethodManager;
    private ResultCityAdapter mResultCityAdapter;
    private LocationManager mLocationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        mDownloadCity = new DownloadCity();
        mDownloadWeather = new DownloadWeather();
        mInputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        initViews();
        initData();
    }

    private void initData() {
        mCityEditText.addTextChangedListener(mCityEditTextWatcher);
        mCityEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Log.v("wq", "onEditorAction: ");
                    mDownloadCity.startDownloadCity(cityName, mDownLoadCityListener);
                }
                return false;
            }
        });
        mAddCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInputMethodManager.hideSoftInputFromWindow(mCityEditText.getWindowToken(), 0);
                mDownloadCity.startDownloadCity(cityName, mDownLoadCityListener);
            }
        });
        mLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!PermissionCheck.isPermissionGranted(AddCityActivity.this, PermissionCheck.PERMISSION_ACCESS_FINE_LOCATION)) {
                    PermissionCheck.requsetPermission(AddCityActivity.this,
                            new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                            PermissionCheck.PERMISSION_REQUSTCODE_LOCATION);
                } else {
                    location();
                }
            }
        });
        mSearchResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectedCityName = mCityInfoList.get(position).getCityName();
                mDownloadWeather.startDownloadWeather(Arrays.asList(mCityInfoList.get(position)), mDownLoadWeatherListener);
            }
        });
        mResultCityAdapter = new ResultCityAdapter(this, mCityInfoList);
        mSearchResultListView.setAdapter(mResultCityAdapter);
    }

    private void initViews() {
        mCityEditText = (EditText) findViewById(R.id.add_city_edittext);
        mAddCityButton = (Button) findViewById(R.id.add_city_add);
        mSearchResultListView = (ListView) findViewById(R.id.add_listview);
        mLocationButton = (Button) findViewById(R.id.add_city_location);
    }


    private void location() {
        final LocationByBD locationByBD = new LocationByBD(this);
        locationByBD.startBaiDuLocationService(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                mDownloadCity.startDownloadCity(bdLocation.getCity(), mDownLoadCityListener);
                locationByBD.stopBaiDuLocationService();
            }

            @Override
            public void onConnectHotSpotMessage(String s, int i) {

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

    private TextWatcher mCityEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            cityName = s.toString().trim();
        }
    };

    private DownloadCity.DownLoadCityListener mDownLoadCityListener = new DownloadCity.DownLoadCityListener() {
        @Override
        public void onCityDownLoadResult(ArrayList<CityInfo> cityInfoList) {
            Log.v("wq", "onCityDownLoadResult: cityInfoList size="+ cityInfoList.size());
            if (mCityInfoList != null) mCityInfoList.clear();
            mCityInfoList.addAll(cityInfoList);
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
            saveToDatabase(reqWeatherDataList);
            finish();
        }
    };

    private void saveToDatabase(List<WeatherInfo> reqWeatherInfoList) {

        //query all weather include bounded table
        List<WeatherInfo> dbWeatherInfoList = DataSupport.findAll(WeatherInfo.class, true);
        //this is only one city, so get the first one.
        WeatherInfo reqWeatherInfo = reqWeatherInfoList.get(0);
        //if database is empty, save directly. if not, need to judge whether to update.
        boolean isNeedUpdate = false;
        if (dbWeatherInfoList.size() > 0) {
            for (WeatherInfo dbWeatherInfo : dbWeatherInfoList) {
                List<WeatherForecastInfo> reqWeatherForecastInfoList = reqWeatherInfo.getForecastDetailList();
                List<WeatherForecastInfo> dbWeatherForecastInfoList = dbWeatherInfo.getForecastDetailList();
                //if the city has been in database, update, if not , save.
                if (dbWeatherInfo.getCityName().equals(mSelectedCityName)) {
                    isNeedUpdate = true;
                    dbWeatherInfo.setWeatherInfo(reqWeatherInfo);
                    dbWeatherInfo.update(dbWeatherInfo.getId());
                    for (int i = 0; i < reqWeatherForecastInfoList.size(); i++) {
                        WeatherForecastInfo dbWeatherForecastInfo = dbWeatherForecastInfoList.get(i);
                        dbWeatherForecastInfo.setWeatherForecastInfo(reqWeatherForecastInfoList.get(i));
                        dbWeatherForecastInfo.update(dbWeatherForecastInfo.getId());
                    }
                }
            }
            if (!isNeedUpdate) {
                reqWeatherInfo.save();
                DataSupport.saveAll(reqWeatherInfo.getForecastDetailList());
            }
        } else {
            reqWeatherInfo.save();
            DataSupport.saveAll(reqWeatherInfo.getForecastDetailList());
        }
    }

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
            textView.setText(cityInfo.getCityName());
            return convertView;
        }
    }


}
