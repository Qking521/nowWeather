package com.king.nowweather.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import static android.R.attr.timeZone;

public final class WeatherUtil {

    public static final int DAYLIGHT_TIME_START = 7;
    public static final int DAYLIGHT_TIME_END = 18;

    public static final String TEMP_COMMON_UNIT = "°";

    private static String versionName = null;


    public static final String TCARD_FILE_PATH = "/mnt/sdcard/Weather";

    public static final String APP_SUGGEST_APK_PATH = TCARD_FILE_PATH + "/suggest/app";

    public static final String APP_SUGGEST_ICON_PATH = TCARD_FILE_PATH + "/suggest/iconCache";


    public static final String ACTION_WEATHER_UPDATED = "mega.weather.action.WEATHER_UPDATED";

    public static final String ACTION_WEATHER_UPDATE_FAILED = "mega.weather.action.WEATHER_UPDATED_FAILED";

    public static final String ACTION_DELETE_CITY = "mega.weather.action.DELETE_CITY";

    public static final String ACTION_ADD_CITY = "mega.weather.action.ADD_CITY";

    public static final String ACTION_WIDGET_CITY_CHANGED = "mega.weather.action.WIDGET_CITY_CHANGED";

    public static final String ACTION_WIDGET_SKIN_CHANGED = "mega.weather.action.WIDGET_SKIN_CHANGED";

    public static final String ACTION_TIME_HOUR_CHANGED = "mega.weather.action.TIME_HOUR_CHANGED";

    public static final String ACTION_WIDGET_SCROLL_UP = "mega.weather.action.SCROLL_UP";

    public static final String ACTION_WIDGET_SCROLL_DOWN = "mega.weather.action.SCROLL_DOWN";


    public static final String ACTION_SETTING = "com.mega.weather.action.setting";


    public final class Setting {

        public static final String KEY_USE_DEFAULT_TIMEZONE = "use_default_time_zone";

        public static final String KEY_TEMP_UNIT = "temp_unit";

        public static final String KEY_HAS_NEW_VERSION = "has_new_version";

        public static final String KEY_VERSION_UPDATE_TIME = "version_update_time";

        public static final String KEY_WEATHER_UPDATE_TIME = "weather_update_time";

        public static final String KEY_WEATHER_UPDATE_START_TIME = "auto_update_start_time";

        public static final String KEY_WEATHER_UPDATE_END_TIME = "auto_update_end_time";

        public static final String KEY_OPEN_NOTICE = "NoticeOpen";

        public static final String KEY_AUTO_UPDATE = "AutoUpdate";

        public static final String KEY_NOTICE_CITY_CN = "notice_city_cn";

        public static final String KEY_NOTICE_CITY_EN = "notice_city_en";
    }


    public static boolean isChinese() {
        return Locale.CHINA.getCountry().equals(Locale.getDefault().getCountry());
    }


    public static String getDBName() {
        String dbName = "weatherdata_en.db";
        if (isChinese()) {
            dbName = "weatherdata_zh.db";
        }
        return dbName;
    }


    public static boolean isNetworkValid(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connManager.getActiveNetworkInfo();
        return (info != null && info.isAvailable());
    }


    public static boolean isMediaMounted() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    public static final String NO_CHINISE_CITY = "no_chinise_city";
    
    public static String getFTmep(int temp) {
		return String.valueOf(Math.round((double) temp * 9 / 5 + 32));
	}

    protected static String check(String string) {
        return (string == null) ? "" : string;
    }


    protected static String convert(String string) {
        if ("".equals(string)) {
            return "N/A";
        } else if (string == null) {
            return "";
        }
        return string;
    }


    protected static String convert(String data, String unit) {
        if ("".equals(data)) {
            data = "N/A";
        } else if (data == null) {
            return "";
        }
        if (unit == null) {
            unit = "";
        }
        return data + unit;
    }


    public static boolean isValid() {
        return true;
    }


    public boolean isEmpty(String string) {
        if (string == null || "NONE".equals(string) || "".equals(string) || "N/A".equals(string)) {
            return true;
        }
        return false;
    }

    public static void logV(String logInfo){
        logV("wq", logInfo);
    }

    public static void logV(String tag, String logInfo){
        Log.v(tag, logInfo);
    }
}
