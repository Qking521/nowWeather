package com.king.weather;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.weather.data.WeatherInfo;

import org.litepal.crud.DataSupport;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCityCount = DataSupport.findAll(WeatherInfo.class).size();
        if (mCityCount == 0) {
            goToAddCityActivity();
        }
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent));
        initViews();
        initData();

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
    }

    private void showDeleteView() {
        Log.v(TAG, "showDeleteView: ");
        Snackbar snackbar = Snackbar.make(mAddCityButton,
                getString(R.string.tips_delete_city), Snackbar.LENGTH_LONG);
        snackbar.setAction(getString(R.string.snack_action_delete), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainFragment mainFragment = (MainFragment)getFragmentPagerAdapter().getItem(mCurrentSelectedPager);
                DataSupport.delete(WeatherInfo.class, mainFragment.getDBId());
                mPagerAdapter = new MainFragmentPagerAdapter(MainActivity.this, getSupportFragmentManager());
                mViewPager.setAdapter(mPagerAdapter);
                updateToolbarTitle(mCurrentSelectedPager);
            }
        });
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }

    private void goToAddCityActivity() {
        Intent intent = new Intent(MainActivity.this, AddCityActivity.class);
        startActivity(intent);
    }

    private void initData() {
        mPagerAdapter = new MainFragmentPagerAdapter(this, getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        updateToolbarTitle(mCurrentSelectedPager > 0? mCurrentSelectedPager : 0);
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
                goToAddCityActivity();
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
        MainFragment mainFragment = (MainFragment) mPagerAdapter.getItem(position);
        mToolbarTitle.setText(mainFragment.getCityName());
        mToolbarSubtitle.setText(mainFragment.getCityAdministrativeArea());
    }


    public MainFragmentPagerAdapter getFragmentPagerAdapter() {
        return mPagerAdapter;
    }
}
