package com.king.nowweather.data;

import android.os.Handler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

    private void downloadWeatherInfo(final CityInfo cityInfo, final WeatherInfo weatherData) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    weatherData.setCityName(cityInfo.getCityName());
                    weatherData.setResponseCityName(cityInfo.getCityName() + ", " + cityInfo.getFullName());
                    weatherData.setLocation(cityInfo.getCityKey());
                    weatherData.setLatitude(cityInfo.getLatitude());
                    weatherData.setLongitude(cityInfo.getLongitude());
                    weatherData.setFullName(cityInfo.getFullName());

//                    JSONArray curjsonArray = getJsonArrayFromUrl(getWeatherDataQueryUrl(cityInfo.getCityKey(), BASE_CUR_URI));
//                    getCurrentWeatherInfo(curjsonArray, weatherData);
                    String curWeatherJsonString = getJsonStringFromUrl(getWeatherDataQueryUrl(cityInfo.getCityKey(), BASE_CUR_URI));
                    parseCurrentWeatherInfo(curWeatherJsonString, weatherData);

//                    JSONObject foreJsonObject = getJsonObjectFromUrl(getWeatherDataQueryUrl(cityInfo.getCityKey(), BASE_FORE_URI));
//                    getForecastWeatherInfo(foreJsonObject, weatherData);
                    String foreWeatherJsonString = getJsonStringFromUrl(getWeatherDataQueryUrl(cityInfo.getCityKey(), BASE_FORE_URI));
                    parseForecastWeatherInfo(foreWeatherJsonString, weatherData);

                    handler.sendMessage(handler.obtainMessage(1, weatherData));
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

    private void parseCurrentWeatherInfo(String jsonString, WeatherInfo weatherData) {

        List<WeatherInfoMeta> weatherInfoMetaList = mGson.fromJson(jsonString,
                new TypeToken<List<WeatherInfoMeta>>() {
                }.getType());
        for (WeatherInfoMeta weatherInfoMeta : weatherInfoMetaList) {
            weatherData.setCurTemp(String.valueOf(weatherInfoMeta.getTemperature().getMetric().getValue()));
            weatherData.setCondition(weatherInfoMeta.getWeatherText());
            weatherData.setIcon(convertIcon(weatherInfoMeta.getWeatherIcon()));
            weatherData.setRealfeel(String.valueOf(weatherInfoMeta.getRealFeelTemperature().getMetric().getValue()));
            weatherData.setLastUpdateTime(System.currentTimeMillis());
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

    private void getCurrentWeatherInfo(JSONArray curjsonArray, WeatherInfo weatherData) {
        int arrayLen = curjsonArray.length();
        for (int i = 0; i < arrayLen; i++) {
            JSONObject object;
            try {
                object = curjsonArray.getJSONObject(i);
                weatherData.setCondition(object.getString(CURRENT_CONDITION));
                weatherData.setIcon(convertIcon(object.getInt(CURRENT_WEATHER_ICON)));
                weatherData.setCurTemp(object.getJSONObject(TEMPERATURE).getJSONObject(METRIC).getString(VALUE));
                weatherData.setRealfeel(object.getJSONObject(CURRENT_REALFEEL).getJSONObject(METRIC).getString(VALUE));
                weatherData.setLastUpdateTime(System.currentTimeMillis());
            } catch (JSONException e) {
                Log.v("wq", "getCurrentWeatherInfo e=" + e.getMessage());
            }
        }
    }

    private String convertIcon(int icon) {
        String newIcon = "";
        if (icon >= 0 && icon <= 9) {
            newIcon = "_0".concat(String.valueOf(icon)).concat("_");
        } else {
            newIcon = "_".concat(String.valueOf(icon)).concat("_");
        }
        return newIcon;
    }

    protected void getForecastWeatherInfo(JSONObject foreJsonObject, WeatherInfo weatherInfo) {
        JSONArray jsonArray;
        List<WeatherForecastInfo> weatherForecastInfoList = weatherInfo.getForecastDetailList();
        try {
            jsonArray = foreJsonObject.getJSONArray(FORECAST_DAILY_FORECASTS);
            int arrayLen = jsonArray.length();
            arrayLen = arrayLen > 7 ? 7 : arrayLen;
            String DayOrNight = weatherInfo.isDaylight() ? FORECAST_DAY : FORECAST_NIGHT;
            for (int i = 0; i < arrayLen; i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String highTemp = String.valueOf(object.getJSONObject(TEMPERATURE).getJSONObject(HIGH_TEMPRATURE).getInt(VALUE));
                String lowTemp = String.valueOf(object.getJSONObject(TEMPERATURE).getJSONObject(LOW_TEMPRATURE).getInt(VALUE));

                WeatherForecastInfo weatherForecastInfo = new WeatherForecastInfo();
                weatherForecastInfo.setHighTemp(highTemp);
                weatherForecastInfo.setLowTemp(lowTemp);
                weatherForecastInfo.setIcon(convertIcon(object.getJSONObject(DayOrNight).getInt(FORECAST_ICON)));
                weatherForecastInfoList.add(weatherForecastInfo);
            }
            weatherInfo.setForecastInfo(weatherForecastInfoList);
        } catch (JSONException e) {
            Log.v("wq", "getForecastWeatherInfo e=" + e.getMessage());
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

    protected JSONArray getJsonArrayFromUrl(String baseUri) {
        JSONArray jsonArray = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(baseUri).openConnection();
            byte[] byteData = getByteInputStream(conn.getInputStream());
            jsonArray = new JSONArray(new String(byteData));
        } catch (Exception e) {
            Log.v("wq", "getJsonArrayFromUrl e=" + e.getMessage());
        }
        return jsonArray;
    }

    protected JSONObject getJsonObjectFromUrl(String baseUri) {
        JSONObject jSONObject = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(baseUri).openConnection();
            byte[] byteData = getByteInputStream(conn.getInputStream());
            jSONObject = new JSONObject(new String(byteData));
        } catch (Exception e) {
            Log.v("wq", "getJsonObjectFromUrl e=" + e.getMessage());
        }
        return jSONObject;
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
