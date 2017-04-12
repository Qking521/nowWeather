package com.king.nowweather;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wangqiang on 2017/4/11.
 */

public class MainFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private List<MainFragment> mMainFragmentList;

    public MainFragmentPagerAdapter(Context context, FragmentManager fragmentManager, List<MainFragment> mainFragmentList){
        super(fragmentManager);
        mContext = context;
        mMainFragmentList = mainFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mMainFragmentList.get(position);
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
