package com.king.nowweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.king.nowweather.data.WeatherData;

/**
 * Created by wangqiang on 2017/4/11.
 */

public class MainFragment extends Fragment {

    private WeatherData mWeatherData;

    public static MainFragment newInstance(String id) {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    public MainFragment setData(WeatherData weatherData) {
        mWeatherData = weatherData;
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
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        TextView cityName = (TextView) view.findViewById(R.id.content);
        cityName.setText(mWeatherData.getCityName() + mWeatherData.getLastUpdateTime());

    }
}
