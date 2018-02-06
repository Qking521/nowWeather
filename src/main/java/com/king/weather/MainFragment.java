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
        mWeatherManager = WeatherManager.getInstance();
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
        mWeatherInfo = weatherInfo;
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

        mWeatherManager.downloadWeatherInfo(mWeatherManager.getCityInfos(), new DownloadWeather.DownLoadWeatherListener() {
            @Override
            public void onWeatherUpdateFailed(int paramInt) {

            }

            @Override
            public void onWeatherUpdatedSuccess(List<WeatherInfo> reqWeatherInfoList) {
                Log.v("wq", "updateWeatherData onWeatherUpdatedSuccess: ");
                mWeatherManager.updateWeatherInfos(reqWeatherInfoList);
                mRefreshLayout.setRefreshing(false);
                ((MainActivity)getActivity()).getFragmentPagerAdapter().notifyDataSetChanged();
            }

        });
    }

    //when update the weather, this method will callback by pager adapter
    public void update() {
        WeatherInfo weatherInfo = mWeatherManager.getWeatherInfoById(getArguments().getLong("id"));
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
