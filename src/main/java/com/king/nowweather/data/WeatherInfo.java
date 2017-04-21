package com.king.nowweather.data;


import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.R.attr.format;
import static android.text.TextUtils.isEmpty;
import static com.king.nowweather.data.WeatherUtil.DAYLIGHT_TIME_END;
import static com.king.nowweather.data.WeatherUtil.DAYLIGHT_TIME_START;
import static com.king.nowweather.data.WeatherUtil.TEMP_COMMON_UNIT;

public final class WeatherInfo extends Details{


    private long id;
    //city info
    private String cityName = ""; // city name
    private String city = "";
    private String province = "";
    private String responseCityName = ""; // city name from server
    private String fullName = "";
    private String postalCode = "";
    private String longitude = "";
    private String latitude = "";
    private String timeZone = "";
    private String curDate = "";
    private String location = "";
    private String locationCity = "false";
    private boolean notifyAlarm = false;

    //weather info
    private String curTemp = "";
    private long lastUpdateTime = 0;
    private String lastUpdateFormatTime = "";

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


    public String getCity() {
        return city;
    }


    public String getProvince() {
        return province;
    }

    public void setCityName(String cityName) {
        if (cityName != null) {
            this.cityName = cityName;
            String[] name = cityName.split(",");
            if (name != null && name.length >= 2) {
                city = name[0];
                province = name[1];
            } else {
                city = cityName;
            }
        }
    }


    public String getResponseCityName() {
        return responseCityName;
    }

    public void setResponseCityName(String responseCityName) {
        if (responseCityName != null) {
            this.responseCityName = responseCityName;
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        setLastUpdateFormatTime(null);
        return lastUpdateFormatTime;
    }

    public void setLastUpdateFormatTime(@Nullable String format) {
        if (format == null || "".equals(format)) {
            format = "yyyy/MM/dd HH:mm";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        lastUpdateFormatTime = dateFormat.format(getLastUpdateTime());
    }

    public String getCurrentDate() {
        return curDate;
    }

    public void setCurrentDate(String curDate) {
        if (curDate != null) {
            this.curDate = curDate;
        }
    }

    public CityInfo createCityInfo() {
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityKey(location);
        cityInfo.setCityName(cityName);
        cityInfo.setLatitude(latitude);
        cityInfo.setLongitude(longitude);
        cityInfo.setFullName(fullName);
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

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        setCityName(weatherInfo.getCityName());
        setLowTemp(weatherInfo.getLowTemp());
        setHighTemp(weatherInfo.getHighTemp());
        setCurrentDate(weatherInfo.getCurrentDate());
        setCurTemp(weatherInfo.getCurTemp());
        setFullName(weatherInfo.getFullName());
        setLastUpdateTime(weatherInfo.getLastUpdateTime());
        setLatitude(weatherInfo.getLatitude());
        setLocation(weatherInfo.getLocation());
        setLocationCity(weatherInfo.getLocationCity());
        setLongitude(weatherInfo.getLongitude());
        setNotifyAlarm(weatherInfo.isNotifyAlarm());
        setPostalCode(weatherInfo.getPostalCode());
        setResponseCityName(weatherInfo.getResponseCityName());
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
