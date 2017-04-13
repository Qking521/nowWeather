package com.king.nowweather.data;

import android.os.Handler;
import android.os.Message;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;


public class DownloadCity {

    public interface DownLoadCityListener {
        void onCityDownLoadResult(ArrayList<CityInfo> cityInfo);
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
    private ArrayList<CityInfo> mCityInfos = new ArrayList<CityInfo>();
    private DownLoadCityListener mDownloadCityListener;

    public void startDownloadCity(final String searchStr, DownLoadCityListener listener) {
        mDownloadCityListener = listener;
        countryCode = Util.isChinese() ? "CN" : "US";
        language = Util.isChinese() ? "zh-cn" : "en";
        new Thread(new Runnable() {
            public void run() {
                try {
                	JSONArray jsonArray = getJsonArrayFromUrl(getCityInfoQueryUrl(searchStr));
                    parseCityInfoFromJsonArray(jsonArray);
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

    private void parseCityInfoFromJsonArray(JSONArray jsonArray) throws Exception{
		int arrayLen = jsonArray.length();
		for (int i = 0; i < arrayLen; i++) {
			CityInfo cityInfo = new CityInfo();
			JSONObject jObject = jsonArray.getJSONObject(i);
			cityInfo.setCityKey(jObject.getString(CITY_KEY));
			cityInfo.setCityName(jObject.getString(CITY_NAME));
			cityInfo.setCountry(jObject.getJSONObject(COUNTRY).getString(COUNTRY_NAME));
			cityInfo.setLatitude(String.valueOf(jObject.getJSONObject(GEOPOSITION).getInt(LATITUE)));
			cityInfo.setLongitude(String.valueOf(jObject.getJSONObject(GEOPOSITION).getInt(LONGITUDE)));
			cityInfo.setProvince(jObject.getJSONObject(PROVINCE).getString(PROVINCE_NAME));
			cityInfo.setFullName(cityInfo.getProvince() + ", " + cityInfo.getCountry()); 
			mCityInfos.add(cityInfo);
		}
	}

    private JSONArray getJsonArrayFromUrl(String baseUri) throws Exception{
    	JSONArray jsonArray = null;
		HttpURLConnection conn = (HttpURLConnection) new URL(baseUri).openConnection();
		byte[] byteData = getByteInputStream(conn.getInputStream());
        String string = new String(byteData);
        jsonArray = new JSONArray(new String(byteData));
		return jsonArray;
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
