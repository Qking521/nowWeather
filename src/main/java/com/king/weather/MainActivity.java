package com.king.weather;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
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
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.weather.data.DownloadWeather;
import com.king.weather.data.WeatherInfo;
import com.king.weather.data.WeatherManager;
import com.king.weather.utils.VpSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationFragment.OnItemClickListener, AddCityFragment.OnCityAddedListener{

    private static final String TAG = "wq";
    public static final int REQUEST_CODE_ADD_CITY = 1;

    private ViewPagerAdapter mPagerAdapter;
    private List<Fragment> mMainFragmentList = new ArrayList<Fragment>();
    private NavigationFragment mNavigationFragment;
    private int mCurrentSelectedPager = 0; //default has AddFragment in viewpager

    private ViewPager mViewPager;
    private VpSwipeRefreshLayout mRefreshLayout;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private TextView mToolbarTitle;
    private TextView mToolbarSubtitle;
    private TextView mToolbarUpdateTime;
    private ImageView mToolbarSlide;
    private FloatingActionButton mAddCityButton;
    private WeatherManager mWeatherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        mWeatherManager = WeatherManager.getInstance();
        initViews();
        initData();
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        mRefreshLayout = (VpSwipeRefreshLayout)findViewById(R.id.refresh_layout) ;
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mNavigationFragment = (NavigationFragment) getSupportFragmentManager().findFragmentById(R.id.main_navigation_fragment);
        mAddCityButton = (FloatingActionButton) findViewById(R.id.main_add_city_button);
        mToolbarTitle = (TextView) mToolbar.findViewById(R.id.main_title);
        mToolbarSubtitle = (TextView) mToolbar.findViewById(R.id.main_subtitle);
        mToolbarSlide = (ImageView) mToolbar.findViewById(R.id.main_slide);
        mToolbarUpdateTime = (TextView) mToolbar.findViewById(R.id.main_update_time);
    }

    private void showDeleteView() {
        Snackbar snackbar = Snackbar.make(mAddCityButton,
                getString(R.string.tips_delete_city), Snackbar.LENGTH_LONG);
        snackbar.setAction(getString(R.string.snack_action_delete), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = mMainFragmentList.get(mCurrentSelectedPager);
                if (fragment instanceof MainFragment) {
                    MainFragment mainFragment = (MainFragment)fragment;
                    mWeatherManager.deleteWeatherInfo(mainFragment.getDBId());
                    mMainFragmentList.remove(mainFragment);
                    mPagerAdapter.notifyDataSetChanged();
                }
            }
        });
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }

    private void addCity() {
        mViewPager.setCurrentItem(mWeatherManager.getCityInfos().size(), true);
    }

    /**
     * called when added city
     */
    private void initData() {
        mMainFragmentList.clear();
        for (WeatherInfo weatherInfo : mWeatherManager.getWeatherInfos()) {
            MainFragment fragment = MainFragment.newInstance(weatherInfo.getId());
            fragment.setData(weatherInfo);
            mMainFragmentList.add(fragment);
        }
        mMainFragmentList.add(AddCityFragment.newInstance());
        mRefreshLayout.setColorSchemeColors(Color.BLUE);
        mRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateWeatherInfo();
            }
        });
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mMainFragmentList);
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
        Fragment fragment = getCurrentFragment(position);
        if (fragment instanceof MainFragment) {
            mToolbar.setVisibility(View.VISIBLE);
            MainFragment mainFragment = (MainFragment) fragment;
            mToolbarTitle.setText(mainFragment.getCityName());
            mToolbarSubtitle.setText(mainFragment.getCityAdministrativeArea());
            mToolbarUpdateTime.setText(mainFragment.getLastUpdateTime());
        } else {
            mToolbar.setVisibility(View.GONE);
        }
    }

    private Fragment getCurrentFragment(int position) {
        return  mPagerAdapter.getItem(position);
    }

    @Override
    public void onItemLongClick(int position) {
        mCurrentSelectedPager = position;
        mDrawerLayout.closeDrawer(GravityCompat.START);
        mViewPager.setCurrentItem(position, true);
    }

    @Override
    public void onItemDeleted() {
        initData();
    }

    @Override
    public void onCityAdded() {
        initData();
        mNavigationFragment.initDatas();
    }
}
