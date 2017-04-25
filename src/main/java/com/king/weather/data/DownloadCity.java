package com.king.weather.data;

import android.os.Handler;
import android.os.Message;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class DownloadCity {

    public interface DownLoadCityListener {
        void onCityDownLoadResult(ArrayList<CityInfo> cityInfoList);
    }


    private static final String PROVINCE = "AdministrativeArea";
    private static final String GEOPOSITION = "GeoPosition";
    private static final String COUNTRY = "Country";
    

    private static final String CITY_NAME = "LocalizedName";
    private static final String PROVINCE_NAME = "LocalizedName";
    private static final String COUNTRY_NAME = "LocalizedName";
    private static final String LATITUE = "Latitude";
    private static final String LONGITUDE = "Longitude";
    private static final String CITY_KEY = "Key";
    
    private static final String BASE_API_KEY = "&apikey=";
    private static final String BASE_LANGUAGE = "&language=";
    private static final String BASE_DETAILS = "&details=";
    private String apiKey = "srRLeAmTroxPinDG8Aus3Ikl6tLGJd94";
    private String language = "";
    private String countryCode = "";
    private boolean isDetails = true;
    
    private static final String BASE_URI = "http://api.accuweather.com/locations/v1/%s/search?q="; 
    private ArrayList<CityInfo> mCityInfos;
    private DownLoadCityListener mDownloadCityListener;
    private Gson mGson;

    public void startDownloadCity(final String searchStr, DownLoadCityListener listener) {
        mDownloadCityListener = listener;
        mGson = new Gson();
        countryCode = WeatherUtil.getCountryCode(); //eg: "CN"
        language = WeatherUtil.getLanguage(); //eg: "zh-cn"
        mCityInfos = new ArrayList<CityInfo>();
        new Thread(new Runnable() {
            public void run() {
                try {
                    parseCityInfoFromJsonString(getJsonStringFromUrl(getCityInfoQueryUrl(searchStr)));
                	mHandler.sendMessage(mHandler.obtainMessage());
                } catch (Exception e) {
                    Log.e("wq", "Error message = " + e.getMessage());
                    Log.e("wq", "network error... ");
                }
            }
        }).start();
    }



    private String getCityInfoQueryUrl(String searchStr) throws Exception{
		StringBuilder builder = new StringBuilder();
		builder.append(String.format(BASE_URI, countryCode))
                .append(URLEncoder.encode(searchStr, "UTF-8"))
				.append(BASE_API_KEY)
                .append(apiKey)
                .append(BASE_LANGUAGE)
                .append(language)
				.append(BASE_DETAILS)
                .append(isDetails);
        Log.v("wq", "getCityInfoQueryUrl=" + builder.toString());
        return builder.toString();
	}

    private String getJsonStringFromUrl(String baseUri) throws Exception{
        HttpURLConnection conn = (HttpURLConnection) new URL(baseUri).openConnection();
        byte[] byteData = getByteInputStream(conn.getInputStream());
        String jsonString = new String(byteData);
        return jsonString;
    }

    private void parseCityInfoFromJsonString(String jsonString) {
        List<CityInfoMeta> cityInfoMetaList = mGson.fromJson(jsonString, new TypeToken<List<CityInfoMeta>>(){}.getType());
        for (CityInfoMeta cityInfoMeta : cityInfoMetaList) {
            CityInfo cityInfo = new CityInfo();
            cityInfo.setCityKey(cityInfoMeta.getKey());
            cityInfo.setCityName(cityInfoMeta.getLocalizedName());
            cityInfo.setProvince(cityInfoMeta.getAdministrativeArea().getLocalizedName());
            cityInfo.setCountry(cityInfoMeta.getCountry().getLocalizedName());
            cityInfo.setLatitude(String.valueOf(cityInfoMeta.getGeoPosition().getLatitude()));
            cityInfo.setLongitude(String.valueOf(cityInfoMeta.getGeoPosition().getLongitude()));
            Log.v("wq", "parseCityInfoFromJson: cityInfo="+ cityInfo.toString());
            mCityInfos.add(cityInfo);
        }

    }

    private byte[] getByteInputStream(InputStream inputStream) throws Exception{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] tempByte = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(tempByte)) != -1) {
			out.write(tempByte, 0, len);
		}
		inputStream.close();
		return out.toByteArray();
	}

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (mDownloadCityListener != null) {
                mDownloadCityListener.onCityDownLoadResult(mCityInfos);
            }
        }
    };

}
