package com.king.weather;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.king.weather.data.WeatherInfo;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by wangqiang on 2017/4/11.
 */

public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    List<WeatherInfo> mWeatherInfoList;

    public MainFragmentPagerAdapter(Context context, FragmentManager fragmentManager){
        super(fragmentManager);
        mContext = context;
        mWeatherInfoList = DataSupport.findAll(WeatherInfo.class, true);
    }

    @Override
    public Fragment getItem(int position) {
        WeatherInfo weatherInfo = mWeatherInfoList.get(position);
        MainFragment fragment = MainFragment.newInstance(weatherInfo.getId());
        fragment.setData(weatherInfo);
        return fragment;
    }

    //override this method to let notifyDataSetChanged enable
    @Override
    public int getItemPosition(Object object) {
        MainFragment mainFragment = (MainFragment)object;
        if (mainFragment != null) {
            mainFragment.update();
        }
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return mWeatherInfoList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        MainFragment fragment = (MainFragment)super.instantiateItem(container, position);
        fragment.setData(mWeatherInfoList.get(position));
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }


}
