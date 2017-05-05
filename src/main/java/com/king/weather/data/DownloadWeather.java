package com.king.weather.data;

import android.os.Handler;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import static com.king.weather.data.WeatherUtil.convertIcon;

public class DownloadWeather {

    private static final String TAG = "wq";

    public interface DownLoadWeatherListener {
        void onWeatherUpdateFailed(int paramInt);

        void onWeatherUpdatedSuccess(List<WeatherInfo> reqWeatherInfoList);
    }

    private static final String METRIC = "Metric";
    private static final String VALUE = "Value";
    private static final String TEMPERATURE = "Temperature";
    private static final String HIGH_TEMPRATURE = "Maximum";
    private static final String LOW_TEMPRATURE = "Minimum";
    private static final String SUN = "Sun";
    private static final String SUNRISE = "Rise";
    private static final String SUNSET = "Set";

    private static final String CURRENT_CONDITION = "WeatherText";
    private static final String CURRENT_WEATHER_ICON = "WeatherIcon";
    private static final String CURRENT_REALFEEL = "RealFeelTemperature";
    private static final String CURRENT_HUMIDITY = "RelativeHumidity";
    private static final String CURRENT_WIND = "Wind";
    private static final String CURRENT_WIND_DIRECTION = "Direction";
    private static final String CURRENT_WIND_SPEED = "Speed";
    private static final String CURRENT_VISIBILITY = "Visibility";

    private static final String FORECAST_DAILY_FORECASTS = "DailyForecasts";
    private static final String FORECAST_WEATHER_ICON = "WeatherIcon";
    private static final String FORECAST_DAY = "Day";
    private static final String FORECAST_NIGHT = "Night";
    private static final String FORECAST_ICON = "Icon";

    private static final String BASE_METRIC = "metric=";
    private static final String BASE_APIKEY = "apikey=";
    private static final String BASE_LANGUAGE = "language=";
    private static final String BASE_DETAILS = "details=";
    private boolean metric = true;
    private String apikey = "srRLeAmTroxPinDG8Aus3Ikl6tLGJd94";
    private String language = "";
    private boolean details = true;
    private String countryCode = "";
    private int mResquestCityCount = 0;

    private static final String BASE_CUR_URI = "http://api.accuweather.com/currentconditions/v1/%s.json?";
    private static final String BASE_FORE_URI = "http://api.accuweather.com/forecasts/v1/daily/10day/%s?";

    private List<WeatherInfo> mReqWeatherDatas = new ArrayList<WeatherInfo>();
    ;
    private DownLoadWeatherListener mDownLoadWeatherListener;
    private Gson mGson;

    public DownloadWeather() {
        mGson = new Gson();
        this.countryCode = WeatherUtil.isChinese() ? "CN" : "US";
        this.language = WeatherUtil.isChinese() ? "zh" : "en";
    }

    public void startDownloadWeather(List<CityInfo> cityInfos, DownLoadWeatherListener downLoadWeatherListener) {
        mResquestCityCount = cityInfos.size();
        mDownLoadWeatherListener = downLoadWeatherListener;
        mReqWeatherDatas.clear();
        for (CityInfo cityInfo : cityInfos) {
            WeatherInfo weatherData = new WeatherInfo();
            downloadWeatherInfo(cityInfo, weatherData);
        }
    }

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    mReqWeatherDatas.add((WeatherInfo) msg.obj);
                    //wait for all data collected, then update UI.
                    if (mReqWeatherDatas.size() == mResquestCityCount) {
                        mDownLoadWeatherListener.onWeatherUpdatedSuccess(mReqWeatherDatas);
                    }
                    break;

                default:
                    break;
            }
        }

        ;
    };

    private void downloadWeatherInfo(final CityInfo cityInfo, final WeatherInfo weatherInfo) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    weatherInfo.setCityInfo(cityInfo);
                    String curWeatherJsonString = getJsonStringFromUrl(getWeatherDataQueryUrl(cityInfo.getCityKey(), BASE_CUR_URI));
                    parseCurrentWeatherInfo(curWeatherJsonString, weatherInfo);

                    String foreWeatherJsonString = getJsonStringFromUrl(getWeatherDataQueryUrl(cityInfo.getCityKey(), BASE_FORE_URI));
                    parseForecastWeatherInfo(foreWeatherJsonString, weatherInfo);

                    handler.sendMessage(handler.obtainMessage(1, weatherInfo));
                } catch (Exception e) {
                    Log.v("wq", "downloadWeatherInfo e=" + e.getMessage());
                }
            }
        }).start();

    }

    private String getWeatherDataQueryUrl(String cityKey, String baseUrl) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format(baseUrl, cityKey))
                .append(BASE_APIKEY)
                .append(apikey)
                .append("&")
                .append(BASE_METRIC)
                .append(metric)
                .append("&")
                .append(BASE_LANGUAGE)
                .append(language)
                .append("&")
                .append(BASE_DETAILS)
                .append(details);
        Log.v(TAG, "getWeatherDataQueryUrl: " + builder.toString());
        return builder.toString();
    }

    private void parseCurrentWeatherInfo(String jsonString, WeatherInfo weatherInfo) {

        List<WeatherInfoMeta> weatherInfoMetaList = mGson.fromJson(jsonString,
                new TypeToken<List<WeatherInfoMeta>>() {
                }.getType());
        for (WeatherInfoMeta weatherInfoMeta : weatherInfoMetaList) {
            weatherInfo.setCurTemp(String.valueOf(weatherInfoMeta.getTemperature().getMetric().getValue()));
            weatherInfo.setLowTemp(String.valueOf(weatherInfoMeta.getTemperature().getMetric().getValue()));
            weatherInfo.setHighTemp(String.valueOf(weatherInfoMeta.getTemperature().getMetric().getValue()));
            weatherInfo.setCondition(weatherInfoMeta.getWeatherText());
            weatherInfo.setIcon(convertIcon(weatherInfoMeta.getWeatherIcon()));
            weatherInfo.setRealfeel(String.valueOf(weatherInfoMeta.getRealFeelTemperature().getMetric().getValue()));
            weatherInfo.setLastUpdateTime(System.currentTimeMillis());
        }
    }

    private void parseForecastWeatherInfo(String foreWeatherJsonString, WeatherInfo weatherInfo) {
        List<WeatherForecastInfo> weatherForecastInfoList = weatherInfo.getForecastDetailList();
        WeatherForecastInfoMeta weatherForecastInfoMeta = mGson.fromJson(foreWeatherJsonString, WeatherForecastInfoMeta.class);
        List<WeatherForecastInfoMeta.DailyForecasts> dailyForecastsEntityList = weatherForecastInfoMeta.getDailyForecasts();
        for (WeatherForecastInfoMeta.DailyForecasts dailyForecasts : dailyForecastsEntityList) {
            WeatherForecastInfo forecastInfo = new WeatherForecastInfo();
            forecastInfo.setHighTemp(String.valueOf(dailyForecasts.getTemperature().getMaximum().getValue()));
            forecastInfo.setLowTemp(String.valueOf(dailyForecasts.getTemperature().getMinimum().getValue()));
            weatherForecastInfoList.add(forecastInfo);
        }
    }

    private String getJsonStringFromUrl(String baseUri) {
        String jsonString = "";
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(baseUri).openConnection();
            byte[] byteData = getByteInputStream(conn.getInputStream());
            jsonString = new String(byteData);
            return jsonString;
        } catch (Exception e) {
            Log.v("wq", "getJsonArrayFromUrl e=" + e.getMessage());
        }
        return jsonString;
    }

    private byte[] getByteInputStream(InputStream inputStream) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] tempByte = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(tempByte)) != -1) {
                out.write(tempByte, 0, len);
            }
            inputStream.close();
        } catch (IOException e) {
            Log.v("wq", "getByteInputStream e=" + e.getMessage());
        }
        return out.toByteArray();
    }


}
