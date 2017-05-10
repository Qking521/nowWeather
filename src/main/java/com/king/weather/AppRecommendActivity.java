package com.king.weather;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangqiang on 2017/5/9.
 */

public class AppRecommendActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<ResolveInfo> mAppList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_recommend_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.app_recommend_recycler_view);
        LinearLayoutManager llManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(llManager);
        initData();
        CustomAdapter customAdapter = new CustomAdapter();
        mRecyclerView.setAdapter(customAdapter);

    }

    private void initData() {
        PackageManager pm = getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mAppList = pm.queryIntentActivities(mainIntent, 0);
        for (ResolveInfo resolveInfo : mAppList) {
            Log.v("wq", "initData: name="+ resolveInfo.loadLabel(getPackageManager()).toString());
        }
    }

    class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(AppRecommendActivity.this).inflate(R.layout.app_recommend_item_layout, parent, false);
            CustomViewHolder viewHolder = new CustomViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            ResolveInfo resolveInfo = mAppList.get(position);
            holder.icon.setImageDrawable(resolveInfo.loadIcon(getPackageManager()));
            holder.name.setText(resolveInfo.loadLabel(getPackageManager()).toString());
        }

        @Override
        public int getItemCount() {
            return mAppList.size();
        }
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView name;

        public CustomViewHolder(View view) {
            super(view);
            icon = (ImageView) view.findViewById(R.id.app_recommend_item_icon);
            name = (TextView) view.findViewById(R.id.app_recommend_item_name);

        }

    }

    
}
