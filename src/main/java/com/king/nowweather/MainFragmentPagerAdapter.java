package com.king.nowweather;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import com.king.nowweather.data.WeatherInfo;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqiang on 2017/4/11.
 */

public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private List<MainFragment> mMainFragmentList = new ArrayList<>();

    public MainFragmentPagerAdapter(Context context, FragmentManager fragmentManager){
        super(fragmentManager);
        mContext = context;
        createFragments();
    }

    private void createFragments(){
        mMainFragmentList.clear();
        List<WeatherInfo> weatherInfoList = DataSupport.findAll(WeatherInfo.class, true);
        for (WeatherInfo weatherInfo : weatherInfoList) {
            mMainFragmentList.add(MainFragment.newInstance(weatherInfo.getId()).setData(weatherInfo));
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mMainFragmentList.get(position);
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
        return mMainFragmentList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }


}
