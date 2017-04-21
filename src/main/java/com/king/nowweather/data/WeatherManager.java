package com.king.nowweather.data;

import android.util.Log;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by wangqiang on 2017/4/20.
 */

public class WeatherManager {

    public List<WeatherInfo> findAll(){
        List<WeatherInfo> weatherInfoList = DataSupport.findAll(WeatherInfo.class, true);
        return weatherInfoList;
    }

    public  void updateWeather(long id){
        List<WeatherInfo> weatherInfoList = DataSupport.findAll(WeatherInfo.class);
        for (WeatherInfo weatherInfo : weatherInfoList) {
            if (weatherInfo.getId() == id) {
                weatherInfo.update(id);
            }
        }
    }
}
