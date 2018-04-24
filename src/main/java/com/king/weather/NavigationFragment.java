package com.king.weather;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.king.weather.data.CityInfo;
import com.king.weather.data.WeatherInfo;
import com.king.weather.data.WeatherManager;
import com.king.weather.data.WeatherUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqiang on 2018/2/7.
 */

public class NavigationFragment extends Fragment {


    interface OnItemClickListener {
        void onItemLongClick(int position);
        void onItemDeleted();
    }

    private ListView mListView;
    private ImageView  mWeatherIcon;
    private ImageView mWeatherDelete;
    private TextView mWeatherTemp;
    private TextView mWeatherCity;
    private List<ResolvedInfo> mResolvedInfoList = new ArrayList<>();
    private WeatherManager mWeatherManager;
    private ResolvedInfoAdapter mAdapter;
    private OnItemClickListener mItemClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemClickListener) {
            mItemClickListener = (OnItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnItemClickListener in NavigationFragment");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_fragment, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mWeatherManager = WeatherManager.getInstance();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("wq", "NavigationFragment onResume");
        initDatas();

    }

    public void initDatas() {
        if (mResolvedInfoList != null) {
            mResolvedInfoList.clear();
        }
        if (mWeatherManager.getCityInfos().size() > 0) {
            updateHeader(mWeatherManager.getWeatherInfos().get(0));
        }
        for (CityInfo cityInfo : mWeatherManager.getCityInfos()) {
            ResolvedInfo resolvedInfo = new ResolvedInfo();
            resolvedInfo.setTitle(cityInfo.getCityName());
            mResolvedInfoList.add(resolvedInfo);
        }
        mAdapter = new ResolvedInfoAdapter(getContext(), mResolvedInfoList);
        mListView.setAdapter(mAdapter);
    }

    private void initViews(View view) {
        mListView = (ListView) view.findViewById(R.id.navigation_fragment_listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateHeader(mWeatherManager.getWeatherInfos().get(position));
            }
        });
       mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
               mItemClickListener.onItemLongClick(position);
               return true;
           }
       });
        mWeatherIcon = (ImageView) view.findViewById(R.id.navigation_weather_icon);
        mWeatherTemp = (TextView) view.findViewById(R.id.navigation_weather_temp);
        mWeatherCity = (TextView) view.findViewById(R.id.navigation_weather_city);
        mWeatherDelete = (ImageView)view.findViewById(R.id.navigation_bottom_delete);
        mWeatherDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (WeatherInfo weatherInfo : mWeatherManager.getWeatherInfos()) {
                    if (weatherInfo.getCityName().equals(mWeatherCity.getText().toString())) {
                        long id = weatherInfo.getId();
                        mWeatherManager.deleteWeatherInfo(id);
                       initDatas();
                       mItemClickListener.onItemDeleted();
                    }
                }
            }
        });
    }

    private void updateHeader(WeatherInfo weatherInfo) {
        mWeatherIcon.setImageResource(WeatherUtil.getDrawable(getContext(), weatherInfo.getIcon()));
        mWeatherTemp.setText(weatherInfo.getCurTemp());
        mWeatherCity.setText(weatherInfo.getCityName());
    }
}
