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
    private TextView mWeatherCondition;
    private TextView mCurTemp;
    private ImageView mWeatherIcon;

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
        initViews(view);
        initViewsEvents();
        updateViews(mWeatherInfo);
        return view;
    }

    private void initViews(View view) {
        mWeatherCondition = (TextView) view.findViewById(R.id.condition);
        mCurTemp = (TextView) view.findViewById(R.id.cur_temp);
        mWeatherIcon = (ImageView) view.findViewById(R.id.weather_icon);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);


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
        mCurTemp.setText(weatherInfo.getCurTemp() + "\n"+ weatherInfo.getLastUpdateFormatTime());
        mWeatherCondition.setText(weatherInfo.getCondition());
        mWeatherIcon.setImageResource(WeatherUtil.getDrawable(getContext(), weatherInfo.getIcon()));
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
