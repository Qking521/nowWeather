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
import com.king.nowweather.data.WeatherData;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.R.attr.id;

public class AddCityActivity extends AppCompatActivity {

    private EditText mCityEditText;
    private Button mAddCityButton;
    private ListView mSearchResultListView;

    private String mAddedCityName;
    private String cityName;
    private List<CityInfo> mCityInfoList;
    private List<String> mDisplayCityList = new ArrayList<>();

    private DownloadCity mDownloadCity;
    private DownloadWeather mDownloadWeather;
    private ArrayAdapter<String> mSearchResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        mDownloadCity = new DownloadCity();
        mDownloadWeather = new DownloadWeather();

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
                mAddedCityName = mCityInfoList.get(position).getCityName();
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
        public void onWeatherUpdatedSuccess(List<WeatherData> reqWeatherDataList) {
            saveToDatabase(reqWeatherDataList);
        }
    };

    private void saveToDatabase(List<WeatherData> reqWeatherDataList) {
        //this here only one city result
        long id = -1;
        List<WeatherData> dbWeatherDataList = DataSupport.findAll(WeatherData.class);
        for (WeatherData weatherData : dbWeatherDataList) {
            if (weatherData.getCityName().equals(mAddedCityName)) {
                id = weatherData.getId();
            }
        }
        for (WeatherData weatherData : reqWeatherDataList) {
            Log.v("wq", "saveToDatabase: "+ mAddedCityName + " ,weatherData="+ weatherData.getCityName() + " ,id="+ weatherData.getId());
            if (weatherData.getCityName().equals(mAddedCityName)){
                if (id > 0) {
                    weatherData.update(id);
                } else {
                    weatherData.save();
                }
            }
        }
        finish();
    }


}
