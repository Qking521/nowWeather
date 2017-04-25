package com.king.weather.data;

import android.content.Context;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

/**
 * Created by wangqiang on 2017/4/25.
 */

public class LocationByBD {
    private Context context;
    private LocationClient mLocationClient;

    public LocationByBD(Context context) {
        this.context = context;
        mLocationClient = new LocationClient(context);
    }

    public void startBaiDuLocationService(BDLocationListener paramBDLocationListener) {
        if (mLocationClient.isStarted()) {
            return;
        } else {
            LocationClientOption localLocationClientOption = new LocationClientOption();
            localLocationClientOption.setCoorType("bd09ll");
            localLocationClientOption.setPriority(2);
            localLocationClientOption.setProdName("Weather");
            localLocationClientOption.setScanSpan(2000);
            localLocationClientOption.setAddrType("all");
            mLocationClient.setLocOption(localLocationClientOption);
            mLocationClient.registerLocationListener(paramBDLocationListener);
            mLocationClient.start();
        }
    }

    public void stopBaiDuLocationService() {
        if ((mLocationClient != null) && (mLocationClient.isStarted()))
            mLocationClient.stop();
    }
}
