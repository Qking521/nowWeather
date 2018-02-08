package com.king.weather;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.king.weather.data.CityInfo;
import com.king.weather.data.WeatherManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqiang on 2018/2/7.
 */

public class NavigationFragment extends Fragment {


    interface OnItemClickListener {
        void onItemClick(int position);
    }

    private ListView mListView;
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
                mItemClickListener.onItemClick(position);
            }
        });
    }
}
