package com.king.nowweather;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.king.nowweather.data.WeatherInfo;
import com.king.nowweather.data.WeatherManager;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "wq";
    private List<MainFragment> mContentFragmentList = new ArrayList<>();
    private MainFragmentPagerAdapter mPagerAdapter;

    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private FloatingActionButton mAddCityButton;
    private WeatherManager mWeatherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DataSupport.findAll(WeatherInfo.class).size() == 0) {
            goToAddCityActivity();
        }
        setContentView(R.layout.activity_main);
        mWeatherManager = new WeatherManager();
        initViews();

    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
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
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_more);
        }
    }

    private void goToAddCityActivity(){
        Intent intent = new Intent(MainActivity.this, AddCityActivity.class);
        MainActivity.this.startActivity(intent);
    }

    private void initData() {
        if (mContentFragmentList != null) {
            mContentFragmentList.clear();
        }
        mPagerAdapter = new MainFragmentPagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

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
