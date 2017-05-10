package com.king.weather.data;

import android.icu.util.Calendar;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;

import static android.text.TextUtils.isEmpty;
import static com.king.weather.data.WeatherUtil.TEMP_COMMON_UNIT;

public class Details extends DataSupport {

    //temperature
    private String lowTemp = "";
    private String highTemp = "";
    private String tempUnit = "";
    private String realfeel = ""; //that is personal feeling
    private String icon = "";
    private String condition = "";

    //wind
    private String windVelocity = "";
    private String velocityUnit = "";
    private String windDirection = "";
    private String windPower = "";

    public String getWindVelocityUnit() {
        return velocityUnit;
    }

    public void setWindVelocityUnit(String velocityUnit) {
        if (velocityUnit != null) {
            this.velocityUnit = velocityUnit;
        }
    }

    public String getWindVelocity() {
        return windVelocity;
    }


    public String getWindVelocity(String unit) {
        String string = "";
        if (!isEmpty(windVelocity)) {
            if (isEmpty(unit)) {
                string = windVelocity + velocityUnit;
            } else {
                string = windVelocity + unit;
            }
        }
        return string;
    }

    public void setWindVelocity(String windVelocity) {
        if (windVelocity != null) {
            this.windVelocity = windVelocity;
        }
    }


    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        if (windDirection != null) {
            this.windDirection = windDirection;
        }
    }


    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        if (windPower != null) {
            this.windPower = windPower;
        }
    }


    public String getLowTemp() {
        return lowTemp;
    }


    public String getLowTemp(String unit) {
        if (isEmpty(unit)) {
            unit = TEMP_COMMON_UNIT;
        }
        return lowTemp + unit;
    }


    public void setLowTemp(String lowTemp) {
        if (lowTemp != null) {
            this.lowTemp = lowTemp;
        }
    }


    public String getHighTemp() {
        return highTemp;
    }


    public String getHighTemp(String unit) {
        if (isEmpty(unit)) {
            unit = TEMP_COMMON_UNIT;
        }
        return highTemp + unit;
    }


    public void setHighTemp(String highTemp) {
        if (highTemp != null) {
            this.highTemp = highTemp;
        }
    }


    public String getTempUnit() {
        return tempUnit;
    }

    public void setTempUnit(String tempUnit) {
        if (tempUnit != null) {
            this.tempUnit = tempUnit;
        }
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        if (icon != null) {
            this.icon = icon;
        }
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getRealfeel() {
        return realfeel;
    }

    public void setRealfeel(String realfeel) {
        if (realfeel != null) {
            this.realfeel = realfeel;
        }
    }
}
