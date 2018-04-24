package com.king.weather.data;


import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.text.TextUtils.isEmpty;
import static com.king.weather.data.WeatherUtil.DAYLIGHT_TIME_END;
import static com.king.weather.data.WeatherUtil.DAYLIGHT_TIME_START;
import static com.king.weather.data.WeatherUtil.TEMP_COMMON_UNIT;

public final class WeatherInfo extends Details{


    private long id;
    //city info
    private String cityName = ""; // city name
    private String cityKey = "";
    private String province = "";
    private String country = "";
    private String longitude = "";
    private String latitude = "";

    private String postalCode = "";
    private String timeZone = "";
    private String curDate = "";
    private String location = "";
    private String locationCity = "false";
    private boolean notifyAlarm = false;

    //weather info
    private String curTemp = "";
    private long lastUpdateTime = 0;
    public String lastUpdateFormatTime = "";

    //forecast
    private List<WeatherForecastInfo> weatherForecastInfoList = new ArrayList<WeatherForecastInfo>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public String getProvince() {
        return province;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }
    //
    String getPostalCode() {
        return postalCode;
    }

    void setPostalCode(String postalCode) {
        if (postalCode != null) {
            this.postalCode = postalCode;
        }
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurDate() {
        return curDate;
    }

    public void setCurDate(String curDate) {
        this.curDate = curDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        if (latitude != null) {
            this.latitude = latitude;
        }
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        if (longitude != null) {
            this.longitude = longitude;
        }
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public  String getLastUpdateFormatTime() {
        return getLastUpdateFormatTime(null);
    }

    public String getLastUpdateFormatTime(@Nullable String format) {
        if (TextUtils.isEmpty(format)) {
            format = "yyyy/MM/dd HH:mm";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        lastUpdateFormatTime = dateFormat.format(getLastUpdateTime());
        return lastUpdateFormatTime;
    }

    public CityInfo createCityInfo() {
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityKey(location);
        cityInfo.setCityName(cityName);
        cityInfo.setLatitude(latitude);
        cityInfo.setLongitude(longitude);
        return cityInfo;
    }

    String getTimeZone() {
        return this.timeZone;
    }


    public void setTimeZone(String timeZone) {
        if (timeZone != null) {
            this.timeZone = timeZone;
        }
    }


    public boolean isDaylight() {
        Calendar c = Calendar.getInstance();
        if (c != null) {
            c.setTimeInMillis(System.currentTimeMillis());
            int hour = c.get(Calendar.HOUR_OF_DAY);
            return (hour >= DAYLIGHT_TIME_START && hour <= DAYLIGHT_TIME_END);
        }
        return true;
    }


    public boolean isNotifyAlarm() {
        return notifyAlarm;
    }

    public void setNotifyAlarm(boolean notifyAlarm) {
        this.notifyAlarm = notifyAlarm;
    }


    public boolean isLocationCity() {
        return "true".equals(locationCity);
    }

    String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }


    public List<WeatherForecastInfo> getForecastDetailList() {
        return weatherForecastInfoList;
    }

    public void setForecastInfo(List<WeatherForecastInfo> weatherForecastInfoList) {
        if (weatherForecastInfoList != null) {
            this.weatherForecastInfoList = weatherForecastInfoList;
        }
    }

    public String getCurTemp() {
        return curTemp;
    }


    public String getCurTemp(String unit) {
        if (isEmpty(unit)) {
            unit = TEMP_COMMON_UNIT;
        }
        return curTemp + unit;
    }

    public void setCurTemp(String curTemp) {
        if (curTemp != null) {
            this.curTemp = curTemp;
        }
    }

    public CityInfo getCityInfo() {
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityKey(getCityKey());
        cityInfo.setCityName(getCityName());
        cityInfo.setProvince(getProvince());
        cityInfo.setCountry(getCountry());
        cityInfo.setLatitude(getLatitude());
        cityInfo.setLongitude(getLongitude());
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        setCityKey(cityInfo.getCityKey());
        setCityName(cityInfo.getCityName());
        setProvince(cityInfo.getProvince());
        setCountry(cityInfo.getCountry());
        setLatitude(cityInfo.getLatitude());
        setLongitude(cityInfo.getLongitude());
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        setCityName(weatherInfo.getCityName());
        setLowTemp(weatherInfo.getLowTemp());
        setHighTemp(weatherInfo.getHighTemp());
        setCurTemp(weatherInfo.getCurTemp());
        setLastUpdateTime(weatherInfo.getLastUpdateTime());
        setLatitude(weatherInfo.getLatitude());
        setLocation(weatherInfo.getLocation());
        setLocationCity(weatherInfo.getLocationCity());
        setLongitude(weatherInfo.getLongitude());
        setNotifyAlarm(weatherInfo.isNotifyAlarm());
        setPostalCode(weatherInfo.getPostalCode());
        setTimeZone(weatherInfo.getTimeZone());
        setCondition(weatherInfo.getCondition());
        setIcon(weatherInfo.getIcon());
        setRealfeel(weatherInfo.getRealfeel());
        setTempUnit(weatherInfo.getTempUnit());
        setWindDirection(weatherInfo.getWindDirection());
        setWindPower(weatherInfo.getWindPower());
        setWindVelocity(weatherInfo.getWindVelocity());
        setWindVelocityUnit(weatherInfo.getWindVelocityUnit());
    }
}
