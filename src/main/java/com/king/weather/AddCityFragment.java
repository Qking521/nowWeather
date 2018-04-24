package com.king.weather;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

/**
 * Created by wangqiang on 2018/2/8.
 */

public class AddCityFragment extends Fragment {

    public interface OnCityAddedListener {
        void onCityAdded();
    }

    public static final String TAG = "wq";

    private SearchView mSearchView;
    private ListView mSearchResultListView;
    private TextView mCurrentLocationCity;
    private List<CityInfo> mCityInfoList = new ArrayList<>();
    private WeatherManager mWeatherManager;
    private InputMethodManager mInputMethodManager;
    private ResultCityAdapter mResultCityAdapter;

    private OnCityAddedListener mCityAddedListener;
    private Activity mActivity;

    static AddCityFragment addCityFragment = null;

    public static AddCityFragment newInstance() {
        if (addCityFragment == null) {
            return addCityFragment = new AddCityFragment();
        } else {
           return addCityFragment;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCityAddedListener) {
            mCityAddedListener = (OnCityAddedListener) context;
        } else {
            throw new RuntimeException("must implement OnCityAddedListener in AddCityFragment ");
        }
        mActivity = (Activity)context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeatherManager = new WeatherManager();
        mInputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_add_city, container, false);
        initViews(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkLocationPermission();
        initViewsListener();
    }

    private void checkLocationPermission() {
        if (!PermissionCheck.isPermissionGranted(getContext(), PermissionCheck.PERMISSION_ACCESS_FINE_LOCATION)) {
            PermissionCheck.requsetPermission(getActivity(),
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
                if (!WeatherUtil.isNetworkValid(getContext())) {
                    WeatherUtil.showToast(getActivity(), "network error, please check");
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
                mWeatherManager.downloadWeatherInfo(Arrays.asList(mCityInfoList.get(position)),  mDownLoadWeatherListener);
            }
        });
    }

    private void initViews(View rootView) {
        mCurrentLocationCity = (TextView)rootView.findViewById(R.id.add_city_current_location);
        mSearchView = (SearchView) rootView.findViewById(R.id.add_city_searchview);
        mSearchResultListView = (ListView) rootView.findViewById(R.id.add_listview);
        mResultCityAdapter = new ResultCityAdapter(getContext(), mCityInfoList);
        mSearchResultListView.setAdapter(mResultCityAdapter);
    }


    private void location() {
        Log.d(TAG, "location: ");
        final LocationByBD locationByBD = new LocationByBD(getContext());
        locationByBD.startBaiDuLocationService(new BDLocationListener() {
            @Override
            public void onReceiveLocation(final BDLocation bdLocation) {
                final String locationCity = bdLocation.getCity();
                Log.d(TAG, "onReceiveLocation: " + locationCity == null ? "locationCity null" : locationCity);
                mActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (!TextUtils.isEmpty(locationCity)) {
                            mCurrentLocationCity.setVisibility(View.VISIBLE);
                            mCurrentLocationCity.setText(bdLocation.getCity());
                            mCurrentLocationCity.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mWeatherManager.downloadCityInfo(bdLocation.getCity(), mDownLoadCityListener);
                                }
                            });
                        } else {
                            mCurrentLocationCity.setVisibility(View.GONE);
                        }
                        locationByBD.stopBaiDuLocationService();
                    }
                });

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
                PermissionCheck.shouldShowRequestPermissionRationale(getActivity(), permissions[0], getString(R.string.permission_rational_message));
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
            Toast.makeText(getActivity(), "weather update failed " + paramInt, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onWeatherUpdatedSuccess(List<WeatherInfo> reqWeatherDataList) {
            mWeatherManager.addWeatherInfos(reqWeatherDataList.get(0));
            mCityAddedListener.onCityAdded();
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
