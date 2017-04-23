package com.king.nowweather;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.king.nowweather.data.CityInfo;
import com.king.nowweather.data.DownloadWeather;
import com.king.nowweather.data.WeatherForecastInfo;
import com.king.nowweather.data.WeatherInfo;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqiang on 2017/4/11.
 */

public class MainFragment extends Fragment {

    private WeatherInfo mWeatherInfo;

    private SwipeRefreshLayout mRefreshLayout;
    private TextView mWeatherCondition;
    private TextView mCurTemp;

    public static MainFragment newInstance(long id) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    public MainFragment setData(WeatherInfo weatherData) {
        mWeatherInfo = weatherData;
        return this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Log.v("wq", "onCreateView: ");
        initViews(view);
        updateViews(mWeatherInfo);
        return view;
    }

    private void initViews(View view) {
        TextView cityName = (TextView) view.findViewById(R.id.city_name);
        TextView cityRegion = (TextView) view.findViewById(R.id.city_region);
        mWeatherCondition = (TextView) view.findViewById(R.id.condition);
        mCurTemp = (TextView) view.findViewById(R.id.cur_temp);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        mRefreshLayout.setColorSchemeColors(Color.BLUE);
        mRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateWeatherData();
                Log.v("wq", "onRefresh: ");
            }
        });
        List<WeatherForecastInfo> weatherForecastInfoList = mWeatherInfo.getForecastDetailList();
        cityName.setText(mWeatherInfo.getCityName());
        cityRegion.setText(mWeatherInfo.getProvince() + mWeatherInfo.getCountry());
        mWeatherCondition.setText(mWeatherInfo.getCondition());
        mCurTemp.setText(mWeatherInfo.getCurTemp() + "\n"+ mWeatherInfo.getLastUpdateFormatTime());
    }

    private void updateWeatherData() {
        final List<WeatherInfo> dbWeatherInfoList = DataSupport.findAll(WeatherInfo.class, true);
        List<CityInfo> cityInfoList = new ArrayList<>();
        for (WeatherInfo weatherInfo : dbWeatherInfoList) {
            cityInfoList.add(weatherInfo.getCityInfo());
        }
        DownloadWeather downloadWeather =  new DownloadWeather();
        downloadWeather.startDownloadWeather(cityInfoList, new DownloadWeather.DownLoadWeatherListener() {
            @Override
            public void onWeatherUpdateFailed(int paramInt) {

            }

            @Override
            public void onWeatherUpdatedSuccess(List<WeatherInfo> reqWeatherInfoList) {
                Log.v("wq", "updateWeatherData onWeatherUpdatedSuccess: ");
                for (WeatherInfo dbWeatherInfo : dbWeatherInfoList) {
                    for (WeatherInfo reqWeatherInfo : reqWeatherInfoList) {
                        if (reqWeatherInfo.getCityName().equals(dbWeatherInfo.getCityName())) {
                            dbWeatherInfo.setWeatherInfo(reqWeatherInfo);
                            dbWeatherInfo.update(dbWeatherInfo.getId());
                            List<WeatherForecastInfo> reqWeatherForecastInfoList = reqWeatherInfo.getForecastDetailList();
                            List<WeatherForecastInfo> dbWeatherForecastInfoList = dbWeatherInfo.getForecastDetailList();
                            for (int i = 0; i < reqWeatherForecastInfoList.size(); i++) {
                                WeatherForecastInfo dbWeatherForecastInfo = dbWeatherForecastInfoList.get(i);
                                dbWeatherForecastInfo.setWeatherForecastInfo(reqWeatherForecastInfoList.get(i));
                                dbWeatherForecastInfo.update(dbWeatherForecastInfo.getId());
                            }
                        }
                    }
                }

                mRefreshLayout.setRefreshing(false);
                ((MainActivity)getActivity()).getFragmentPagerAdapter().notifyDataSetChanged();
            }

        });
    }

    //when update the weather, this method will callback by pager adapter
    public void update() {
        WeatherInfo weatherInfo = DataSupport.find(WeatherInfo.class, getArguments().getLong("id"));
        updateViews(weatherInfo);
    }

    //update view that maybe change.
    private void updateViews(WeatherInfo weatherInfo) {
        mCurTemp.setText(weatherInfo.getCurTemp() + "\n"+ weatherInfo.getLastUpdateFormatTime());
        mWeatherCondition.setText(weatherInfo.getCondition());
    }
}
