package com.king.weather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wangqiang on 2017/4/11.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "ViewPagerAdapter";
    private List<Fragment> mFragmentList;
    private FragmentManager mFragmentManager;

    public ViewPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList){
        super(fragmentManager);
        mFragmentList = fragmentList;
        mFragmentManager = fragmentManager;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    //override this method to let notifyDataSetChanged enable
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "instantiateItem: position ="+ position);
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.d(TAG, "destroyItem: position ="+ position);
        super.destroyItem(container, position, object);
    }
}
