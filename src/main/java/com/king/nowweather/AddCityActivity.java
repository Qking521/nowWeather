package com.king.nowweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.king.nowweather.data.CityInfo;
import com.king.nowweather.data.DownloadCity;
import com.king.nowweather.data.DownloadWeather;
import com.king.nowweather.data.WeatherForecastInfo;
import com.king.nowweather.data.WeatherInfo;
import com.king.nowweather.data.WeatherManager;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCityActivity extends AppCompatActivity {

    private EditText mCityEditText;
    private Button mAddCityButton;
    private ListView mSearchResultListView;

    private String mSelectedCityName;
    private String cityName;
    private List<CityInfo> mCityInfoList;
    private List<String> mDisplayCityList = new ArrayList<>();

    private DownloadCity mDownloadCity;
    private DownloadWeather mDownloadWeather;
    private ArrayAdapter<String> mSearchResultAdapter;
    private WeatherManager mWeatherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        mDownloadCity = new DownloadCity();
        mDownloadWeather = new DownloadWeather();
        mWeatherManager = new WeatherManager();
        initViews();
        initData();
    }

    private void initData() {
        mCityEditText.addTextChangedListener(mCityEditTextWatcher);
        mAddCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDownloadCity.startDownloadCity(cityName, mDownLoadCityListener);
            }
        });
        mSearchResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectedCityName = mCityInfoList.get(position).getCityName();
                mDownloadWeather.startDownloadWeather(Arrays.asList(mCityInfoList.get(position)), mDownLoadWeatherListener);
            }
        });
    }


    private void initViews() {
        mCityEditText = (EditText) findViewById(R.id.add_city_edittext);
        mAddCityButton = (Button) findViewById(R.id.add_city_button);
        mSearchResultListView = (ListView) findViewById(R.id.add_listview);
    }


    private TextWatcher mCityEditTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            cityName = s.toString().trim();
        }
    };

    private DownloadCity.DownLoadCityListener mDownLoadCityListener = new DownloadCity.DownLoadCityListener() {
        @Override
        public void onCityDownLoadResult(ArrayList<CityInfo> cityInfoList) {
            if (mCityInfoList != null) mCityInfoList.clear();
            mCityInfoList = cityInfoList;
            for (CityInfo cityInfo : mCityInfoList) {
                mDisplayCityList.add(cityInfo.getCityName());
            }
            mSearchResultAdapter = new ArrayAdapter<String>(AddCityActivity.this, android.R.layout.simple_list_item_1,
                    (String[]) mDisplayCityList.toArray(new String[mDisplayCityList.size()]));
            mSearchResultListView.setAdapter(mSearchResultAdapter);
        }
    };

    private DownloadWeather.DownLoadWeatherListener mDownLoadWeatherListener = new DownloadWeather.DownLoadWeatherListener() {
        @Override
        public void onWeatherUpdateFailed(int paramInt) {
            Toast.makeText(AddCityActivity.this, "weather update failed " + paramInt, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onWeatherUpdatedSuccess(List<WeatherInfo> reqWeatherDataList) {
            saveToDatabase(reqWeatherDataList);
            finish();
        }
    };

    private void saveToDatabase(List<WeatherInfo> reqWeatherInfoList) {

        //query all weather include bounded table
        List<WeatherInfo> dbWeatherInfoList = DataSupport.findAll(WeatherInfo.class, true);
        //this is only one city, so get the first one.
        WeatherInfo reqWeatherInfo = reqWeatherInfoList.get(0);
        //if database is empty, save directly. if not, need to judge whether to update.
        boolean isNeedUpdate = false;
        if (dbWeatherInfoList.size() > 0) {
            for (WeatherInfo dbWeatherInfo : dbWeatherInfoList) {
                List<WeatherForecastInfo> reqWeatherForecastInfoList = reqWeatherInfo.getForecastDetailList();
                List<WeatherForecastInfo> dbWeatherForecastInfoList = dbWeatherInfo.getForecastDetailList();
                //if the city has been in database, update, if not , save.
                if (dbWeatherInfo.getCityName().equals(mSelectedCityName)) {
                    isNeedUpdate = true;
                    dbWeatherInfo.setWeatherInfo(reqWeatherInfo);
                    dbWeatherInfo.update(dbWeatherInfo.getId());
                    for (int i = 0; i < reqWeatherForecastInfoList.size(); i++) {
                        WeatherForecastInfo dbWeatherForecastInfo = dbWeatherForecastInfoList.get(i);
                        dbWeatherForecastInfo.setWeatherForecastInfo(reqWeatherForecastInfoList.get(i));
                        dbWeatherForecastInfo.update(dbWeatherForecastInfo.getId());
                    }
                }
            }
            if (!isNeedUpdate) {
                reqWeatherInfo.save();
                DataSupport.saveAll(reqWeatherInfo.getForecastDetailList());
            }
        } else {
            reqWeatherInfo.save();
            DataSupport.saveAll(reqWeatherInfo.getForecastDetailList());
        }
//        long id = -1;
//        long[] ids = new long[]{};
//        List<WeatherInfo> dbWeatherInfoList = DataSupport.findAll(WeatherInfo.class, true);
//        for (WeatherInfo weatherInfo : dbWeatherInfoList) {
//            if (weatherInfo.getCityName().equals(mSelectedCityName)) {
//                id = weatherInfo.getId();
//                List<WeatherForecastInfo> dbWeatherForecastInfoList = weatherInfo.getForecastDetailList();
//                for (int i = 0; i < dbWeatherForecastInfoList.size(); i++) {
//                    ids[i] = dbWeatherForecastInfoList.get(i).getId();
//                }
//            }
//        }
//        //this here only one city result, so list get(0)
//        WeatherInfo weatherInfo = reqWeatherInfoList.get(0);
//        Log.v("wq", "isSaved=" + weatherInfo.isSaved());
//        if (weatherInfo.getCityName().equals(mSelectedCityName)){
//            List<WeatherForecastInfo> weatherForecastInfoList = weatherInfo.getForecastDetailList();
//            if (id > -1) {
//                weatherInfo.update(id);
//                for (int i = 0; i < weatherForecastInfoList.size(); i++) {
//                    WeatherForecastInfo weatherForecastInfo = weatherForecastInfoList.get(i);
//                    weatherForecastInfo.update(ids[i]);
//                }
//            } else {
//                weatherInfo.save();
//                DataSupport.saveAll(weatherForecastInfoList);
//            }
//            Log.v("wq", "saveToDatabase: cityname"+ weatherInfo.getCityName() + " ,id="+ weatherInfo.getId());
//        }
    }


}
