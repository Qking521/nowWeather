package com.king.weather;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
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

import com.king.weather.data.WeatherInfo;
import com.king.weather.data.WeatherManager;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "wq";
    private List<MainFragment> mContentFragmentList = new ArrayList<>();
    private MainFragmentPagerAdapter mPagerAdapter;
    private int mCityCount = -1;

    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private TextView mToolbarTitle;
    private TextView mToolbarSubtitle;
    private ImageView mToolbarSlide;
    private FloatingActionButton mAddCityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCityCount = DataSupport.findAll(WeatherInfo.class).size();
        if (mCityCount == 0) {
            goToAddCityActivity();
        }
        setContentView(R.layout.activity_main);
        initViews();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mCityCount = DataSupport.findAll(WeatherInfo.class).size();
        if (mCityCount > 0) {
            initData();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mAddCityButton = (FloatingActionButton) findViewById(R.id.main_add_city_button);
        mAddCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToAddCityActivity();
            }
        });
        mToolbarTitle = (TextView) mToolbar.findViewById(R.id.main_title);
        mToolbarSubtitle = (TextView) mToolbar.findViewById(R.id.main_subtitle);
        mToolbarSlide = (ImageView) mToolbar.findViewById(R.id.main_slide);

    }

    private void goToAddCityActivity(){
        Intent intent = new Intent(MainActivity.this, AddCityActivity.class);
        startActivity(intent);
    }

    private void initData() {
        if (mContentFragmentList != null) {
            mContentFragmentList.clear();
        }
        mPagerAdapter = new MainFragmentPagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        mToolbarSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        updateToolbarTitle(0);
    }

    private ViewPager.OnPageChangeListener  mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
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
        MainFragment mainFragment = (MainFragment)mPagerAdapter.getItem(position);
        mToolbarTitle.setText(mainFragment.getCityName());
        mToolbarSubtitle.setText(mainFragment.getCityCityAdministrativeArea());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        switch (menuId) {
            case android.R.id.home:
                //when click icon in actionbar , close drawer layout
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public MainFragmentPagerAdapter getFragmentPagerAdapter(){
        return mPagerAdapter;
    }
}
