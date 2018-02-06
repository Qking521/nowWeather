package com.king.weather.data;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangqiang on 2017/4/20.
 */

public class WeatherManager {

    private DownloadCity mDownloadCity;
    private DownloadWeather mDownloadWeather;
    private  static WeatherManager weatherManager = null;

    public static WeatherManager getInstance() {
        if (weatherManager == null) {
            return new WeatherManager();
        } else {
            return weatherManager;
        }
    }

    public WeatherManager() {
        mDownloadCity = new DownloadCity();
        mDownloadWeather = new DownloadWeather();

    }

    public void downloadCityInfo(String cityName, DownloadCity.DownLoadCityListener listener) {
        mDownloadCity.startDownloadCity(cityName, listener);
    }

    public void downloadWeatherInfo(List<CityInfo> cityInfos, DownloadWeather.DownLoadWeatherListener listener) {
        mDownloadWeather.startDownloadWeather(cityInfos, listener);
    }

    public WeatherInfo getWeatherInfoById(long id) {
        return DataSupport.find(WeatherInfo.class, id);
    }

    /**
     *
     * @return all weather info in database
     */
    public List<WeatherInfo> getWeatherInfos(){
        List<WeatherInfo> weatherInfoList = DataSupport.findAll(WeatherInfo.class, true);
        return weatherInfoList;
    }

    //update database by id
    public  void updateWeatherInfo(long id){
        List<WeatherInfo> weatherInfoList = DataSupport.findAll(WeatherInfo.class);
        for (WeatherInfo weatherInfo : weatherInfoList) {
            if (weatherInfo.getId() == id) {
                weatherInfo.update(id);
            }
        }
    }

    public List<CityInfo> getCityInfos() {
        final List<WeatherInfo> dbWeatherInfoList = DataSupport.findAll(WeatherInfo.class, true);
        List<CityInfo> cityInfoList = new ArrayList<>();
        for (WeatherInfo weatherInfo : dbWeatherInfoList) {
            cityInfoList.add(weatherInfo.getCityInfo());
        }
        return cityInfoList;
    }



    /**
     * update database
     * @param reqWeatherInfoList
     */
    public void updateWeatherInfos(List<WeatherInfo> reqWeatherInfoList) {
        for (WeatherInfo dbWeatherInfo : getWeatherInfos()) {
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

    }

    //insert database
    public void addWeatherInfos(WeatherInfo reqWeatherInfo) {
        //check if the city has been added before. if has been added, update.
        boolean hasInDatabase = false;
        for (WeatherInfo dbWeatherInfo : getWeatherInfos()) {
            if (dbWeatherInfo.getCityName().equals(reqWeatherInfo.getCityName())) {
                hasInDatabase = true;
            }
        }
        if (hasInDatabase) {
            updateWeatherInfos(Arrays.asList(reqWeatherInfo));
        } else {
           saveWeatherInfo(reqWeatherInfo);
        }

    }

    private void saveWeatherInfo(WeatherInfo weatherInfo) {
        weatherInfo.save();
        DataSupport.saveAll(weatherInfo.getForecastDetailList());
    }

    //delete database by id
    public void deleteWeather(long dbId) {
        DataSupport.delete(WeatherInfo.class, dbId);
    }
}
