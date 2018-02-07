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

import com.king.weather.data.DownloadWeather;
import com.king.weather.data.WeatherForecastInfo;
import com.king.weather.data.WeatherInfo;
import com.king.weather.data.WeatherManager;
import com.king.weather.data.WeatherUtil;

import java.util.List;


/**
 * Created by wangqiang on 2017/4/11.
 */

public class MainFragment extends Fragment {

    public static final String TAG = "wq";
    private WeatherInfo mWeatherInfo;
    private WeatherManager mWeatherManager;



    public static MainFragment newInstance(long id) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("id",  id);
        fragment.setArguments(bundle);
        return fragment;
    }

    public MainFragment() {
        mWeatherManager = WeatherManager.getInstance();
    }

    public void setData(WeatherInfo weatherInfo) {
        Log.d(TAG, "setData: ");
        mWeatherInfo = weatherInfo;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViewsEvents() {

    }

    //update view that maybe change.
    private void initViews() {
        View view = getView();
        TextView weatherCondition = (TextView) view.findViewById(R.id.condition);
        TextView curTemp = (TextView) view.findViewById(R.id.cur_temp);
        ImageView weatherIcon = (ImageView) view.findViewById(R.id.weather_icon);


        initViewsEvents();
        curTemp.setText(mWeatherInfo.getCurTemp() + "\n"+ mWeatherInfo.getLastUpdateFormatTime());
        weatherCondition.setText(mWeatherInfo.getCondition());
        weatherIcon.setImageResource(WeatherUtil.getDrawable(getContext(), mWeatherInfo.getIcon()));

        addForecastViews(view, mWeatherInfo);
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
