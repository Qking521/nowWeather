package com.king.weather;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.king.weather.data.CityInfo;
import com.king.weather.data.DownloadWeather;
import com.king.weather.data.WeatherForecastInfo;
import com.king.weather.data.WeatherInfo;
import com.king.weather.data.WeatherUtil;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wangqiang on 2017/4/11.
 */

public class MainFragment extends Fragment {

    public static final String TAG = "wq";
    private WeatherInfo mWeatherInfo = new WeatherInfo();

    private SwipeRefreshLayout mRefreshLayout;

    public static MainFragment newInstance(long id) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("id", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setData(WeatherInfo weatherData) {
        mWeatherInfo = weatherData;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        updateViews(mWeatherInfo);
    }

    private void initViewsEvents() {
        mRefreshLayout.setColorSchemeColors(Color.BLUE);
        mRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateWeatherData();
                Log.v("wq", "onRefresh: ");
            }
        });
    }

    //update view that maybe change.
    private void updateViews(WeatherInfo weatherInfo) {
        if (weatherInfo == null) {
            return;
        }
        View view = getView();
        TextView weatherCondition = (TextView) view.findViewById(R.id.condition);
        TextView curTemp = (TextView) view.findViewById(R.id.cur_temp);
        ImageView weatherIcon = (ImageView) view.findViewById(R.id.weather_icon);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);


        initViewsEvents();
        curTemp.setText(weatherInfo.getCurTemp() + "\n"+ weatherInfo.getLastUpdateFormatTime());
        weatherCondition.setText(weatherInfo.getCondition());
        weatherIcon.setImageResource(WeatherUtil.getDrawable(getContext(), weatherInfo.getIcon()));
        addForecastViews(view, weatherInfo);
    }

    private void addForecastViews(View view, WeatherInfo weatherInfo) {
        ViewGroup forecastContainer = (LinearLayout) view.findViewById(R.id.forecast_container);
        List<WeatherForecastInfo> forecastInfoList = weatherInfo.getForecastDetailList();
        for (WeatherForecastInfo weatherForecastInfo : forecastInfoList) {
            View forecastView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_main_forecast, null);
            TextView forecastDate = (TextView) forecastView.findViewById(R.id.forecast_date);
            TextView forecastCondition = (TextView) forecastView.findViewById(R.id.forecast_condition);
            TextView forecastLowTemp = (TextView) forecastView.findViewById(R.id.forecast_low_temp);
            TextView forecastHighTemp = (TextView) forecastView.findViewById(R.id.forecast_high_temp);
            ImageView forecastIcon = (ImageView) forecastView.findViewById(R.id.forecast_icon);


            forecastIcon.setImageResource(WeatherUtil.getDrawable(getContext(), weatherForecastInfo.getIcon()));
            forecastCondition.setText(weatherForecastInfo.getCondition());
            forecastDate.setText(WeatherUtil.toWeek(weatherForecastInfo.getDate()));
            forecastLowTemp.setText(weatherForecastInfo.getLowTemp());
            forecastHighTemp.setText(weatherForecastInfo.getHighTemp());
            forecastContainer.addView(forecastView);
        }

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
        mWeatherInfo = weatherInfo;
        updateViews(weatherInfo);
    }

    public long getDBId() {
        return getArguments().getLong("id");
    }

    public String getCityName(){
        return mWeatherInfo.getCityName();
    }

    public String getCityAdministrativeArea() {
        return mWeatherInfo.getProvince() + ","+ mWeatherInfo.getCountry();
    }


}
