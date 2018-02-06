package com.king.weather;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.weather.data.WeatherManager;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "wq";
    private MainFragmentPagerAdapter mPagerAdapter;
    private int mCityCount = -1;
    private int mCurrentSelectedPager = -1;

    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private TextView mToolbarTitle;
    private TextView mToolbarSubtitle;
    private ImageView mToolbarSlide;
    private FloatingActionButton mAddCityButton;
    private ImageView mDeleteCityButton;
    private NavigationView mNavigationView;
    private WeatherManager mWeatherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWeatherManager = WeatherManager.getInstance();
        mCityCount = mWeatherManager.getWeatherInfos().size();
        if (mCityCount == 0) {
            addCity();
        }
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));

        initViews();
        if (mCityCount > 0) {
            initData();
        }


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initData();
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mAddCityButton = (FloatingActionButton) findViewById(R.id.main_add_city_button);
        mDeleteCityButton = (ImageView) findViewById(R.id.main_delete);
        mToolbarTitle = (TextView) mToolbar.findViewById(R.id.main_title);
        mToolbarSubtitle = (TextView) mToolbar.findViewById(R.id.main_subtitle);
        mToolbarSlide = (ImageView) mToolbar.findViewById(R.id.main_slide);
        mNavigationView = (NavigationView) findViewById(R.id.main_navigation);
    }

    private void showDeleteView() {
        Log.v(TAG, "showDeleteView: ");
        Snackbar snackbar = Snackbar.make(mAddCityButton,
                getString(R.string.tips_delete_city), Snackbar.LENGTH_LONG);
        snackbar.setAction(getString(R.string.snack_action_delete), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment mainFragment = (MainFragment)getFragmentPagerAdapter().getItem(mCurrentSelectedPager);
                mWeatherManager.deleteWeather(mainFragment.getDBId());
                mPagerAdapter = new MainFragmentPagerAdapter(MainActivity.this, getSupportFragmentManager());
                mViewPager.setAdapter(mPagerAdapter);
                updateToolbarTitle(0);
            }
        });
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }

    private void addCity() {
        Intent intent = new Intent(MainActivity.this, AddCityActivity.class);
        startActivity(intent);
    }

    private void initData() {
        mPagerAdapter = new MainFragmentPagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        updateToolbarTitle( 0);
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
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int menuId = item.getItemId();
                switch (menuId) {
                    case R.id.menu_app_recommend:
                        startActivity(new Intent(MainActivity.this, AppRecommendActivity.class));
                }
                return true;
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
        mCurrentSelectedPager = position;
        if (mPagerAdapter.getCount() > 0) {
            MainFragment mainFragment = (MainFragment) mPagerAdapter.getItem(position);
            mToolbarTitle.setText(mainFragment.getCityName());
            mToolbarSubtitle.setText(mainFragment.getCityAdministrativeArea());
        } else {
            startActivity(new Intent(this, AddCityActivity.class));
        }
    }


    public MainFragmentPagerAdapter getFragmentPagerAdapter() {
        return mPagerAdapter;
    }
}
