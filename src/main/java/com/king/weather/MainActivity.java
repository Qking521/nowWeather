package com.king.weather;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.weather.data.DownloadWeather;
import com.king.weather.data.WeatherInfo;
import com.king.weather.data.WeatherManager;
import com.king.weather.utils.VpSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationFragment.OnItemClickListener{

    private static final String TAG = "wq";
    public static final int REQUEST_CODE_ADD_CITY = 1;

    private ViewPagerAdapter mPagerAdapter;
    private List<Fragment> mMainFragments = new ArrayList<Fragment>();
    private int mCurrentSelectedPager = 0;

    private ViewPager mViewPager;
    private VpSwipeRefreshLayout mRefreshLayout;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private TextView mToolbarTitle;
    private TextView mToolbarSubtitle;
    private ImageView mToolbarSlide;
    private FloatingActionButton mAddCityButton;
    private ImageView mDeleteCityButton;
    private WeatherManager mWeatherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        mWeatherManager = WeatherManager.getInstance();
        if (mWeatherManager.getWeatherInfos().size() == 0) {
            addCity();
        } else {
            initViews();
            initData();
        }
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        mRefreshLayout = (VpSwipeRefreshLayout)findViewById(R.id.refresh_layout) ;
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mAddCityButton = (FloatingActionButton) findViewById(R.id.main_add_city_button);
        mDeleteCityButton = (ImageView) findViewById(R.id.main_delete);
        mToolbarTitle = (TextView) mToolbar.findViewById(R.id.main_title);
        mToolbarSubtitle = (TextView) mToolbar.findViewById(R.id.main_subtitle);
        mToolbarSlide = (ImageView) mToolbar.findViewById(R.id.main_slide);

    }

    private void showDeleteView() {
        Snackbar snackbar = Snackbar.make(mAddCityButton,
                getString(R.string.tips_delete_city), Snackbar.LENGTH_LONG);
        snackbar.setAction(getString(R.string.snack_action_delete), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MainFragment mainFragment = mMainFragments.get(mCurrentSelectedPager);
//                mWeatherManager.deleteWeatherInfo(mainFragment.getDBId());
//                mMainFragments.remove(mainFragment);
//                mPagerAdapter.notifyDataSetChanged();
            }
        });
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }

    private void addCity() {
        Intent intent = new Intent(MainActivity.this, AddCityActivity.class);
        startActivityForResult(intent, REQUEST_CODE_ADD_CITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_CITY) {
            //this indicate that successed add city on addCityActivity
            if (resultCode == Activity.RESULT_OK) {
                initViews();
                initData(true);
            }
        }
    }

    private void initData() {
        //called on create
        initData(false);
    }

    /**
     * called when added city
     * @param addedCity
     */
    private void initData(boolean addedCity) {
        mMainFragments.clear();
        for (WeatherInfo weatherInfo : mWeatherManager.getWeatherInfos()) {
            MainFragment fragment = MainFragment.newInstance(weatherInfo.getId());
            fragment.setData(weatherInfo);
            mMainFragments.add(fragment);
        }
        if (addedCity) {
            mCurrentSelectedPager = mMainFragments.size() - 1;
        }
        mRefreshLayout.setColorSchemeColors(Color.BLUE);
        mRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateWeatherInfo();
            }
        });
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mMainFragments);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);

        mViewPager.setCurrentItem(mCurrentSelectedPager, true);
        updateToolbarTitle( mCurrentSelectedPager);
        mToolbarSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        mDeleteCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteView();
            }
        });
        mAddCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCity();
            }
        });

    }

    private void updateWeatherInfo() {

        mWeatherManager.downloadWeatherInfo(mWeatherManager.getCityInfos(), new DownloadWeather.DownLoadWeatherListener() {
            @Override
            public void onWeatherUpdateFailed(int paramInt) {

            }

            @Override
            public void onWeatherUpdatedSuccess(List<WeatherInfo> reqWeatherInfoList) {
                Log.v("wq", "updateWeatherInfo onWeatherUpdatedSuccess: ");
                mWeatherManager.updateWeatherInfos(reqWeatherInfoList);
                mRefreshLayout.setRefreshing(false);
                initData();
            }
        });
    }

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            updateToolbarTitle(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void updateToolbarTitle(int position) {
        MainFragment mainFragment = getCurrentFragment(position);
        mToolbarTitle.setText(mainFragment.getCityName());
        mToolbarSubtitle.setText(mainFragment.getCityAdministrativeArea());
    }

    private MainFragment getCurrentFragment(int position) {
        return  (MainFragment) mPagerAdapter.getItem(position);
    }

    @Override
    public void onItemClick(int position) {
        mCurrentSelectedPager = position;
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mViewPager.setCurrentItem(position, true);

    }
}
