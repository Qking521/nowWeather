package com.king.nowweather.data;

/**
 * Created by wangqiang on 2017/4/20.
 */

public class WeatherForecastInfo extends Details {

    private long id = -1;//primary key
    private WeatherInfo weatherInfo;
    private String chill = "";
    private String humidity = "";
    private String visibility = "";
    private String pressure = "";
    private String rising = "";
    private String sunrise = "";
    private String sunset = "";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(WeatherInfo weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public String getChill() {
        return chill;
    }

    public void setChill(String chill) {
        this.chill = chill;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getRising() {
        return rising;
    }

    public void setRising(String rising) {
        this.rising = rising;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public void setWeatherForecastInfo(WeatherForecastInfo weatherForecastInfo){
        setLowTemp(weatherForecastInfo.getLowTemp());
        setHighTemp(weatherForecastInfo.getHighTemp());
        setCondition(weatherForecastInfo.getCondition());
        setIcon(weatherForecastInfo.getIcon());
        setRealfeel(weatherForecastInfo.getRealfeel());
        setTempUnit(weatherForecastInfo.getTempUnit());
        setWindDirection(weatherForecastInfo.getWindDirection());
        setWindPower(weatherForecastInfo.getWindPower());
        setWindVelocity(weatherForecastInfo.getWindVelocity());
        setWindVelocityUnit(weatherForecastInfo.getWindVelocityUnit());
        setChill(weatherForecastInfo.getChill());
        setHumidity(weatherForecastInfo.getHumidity());
        setPressure(weatherForecastInfo.getPressure());
        setRising(weatherForecastInfo.getRising());
        setSunrise(weatherForecastInfo.getSunrise());
        setSunset(weatherForecastInfo.getSunset());
        setVisibility(weatherForecastInfo.getVisibility());
    }
}
