package com.king.nowweather.data;

import org.litepal.crud.DataSupport;

import static com.king.nowweather.data.WeatherUtil.TEMP_COMMON_UNIT;

public class Details extends DataSupport {

    //temperature
    private String curTemp = "";
    private String lowTemp = "";
    private String highTemp = "";
    private String tempUnit = "";
    private String realfeel = ""; //that is personal feeling
    private String icon = "";
    //wind
    private String windVelocity = "";
    private String velocityUnit = "";
    private String windDirection = "";
    private String windPower = "";
    //weather relevant
    private String chill = "";
    private String condition = "";
    private String humidity = "";
    private String visibility = "";
    private String pressure = "";
    private String rising = "";
    private String sunrise = "";
    private String sunset = "";


    public String getCurTemp() {
        return curTemp;
    }


    public String getCurTemp(String unit) {
        if (isEmpty(unit)) {
            unit = TEMP_COMMON_UNIT;
        }
        return curTemp + unit;
    }

    public void setCurTemp(String curTemp) {
        if (curTemp != null) {
            this.curTemp = curTemp;
        }
    }

    public String getChill() {
        return chill;
    }

    public void setChill(String chill) {
        if (chill != null) {
            this.chill = chill;
        }
    }


    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        if (visibility != null) {
            this.visibility = visibility;
        }
    }


    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        if (pressure != null) {
            this.pressure = pressure;
        }
    }


    public String getRising() {
        return rising;
    }

    public void setRising(String rising) {
        if (rising != null) {
            this.rising = rising;
        }
    }


    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        if (sunrise != null) {
            this.sunrise = sunrise;
        }
    }


    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        if (sunset != null) {
            this.sunset = sunset;
        }
    }


    public String getWindVelocityUnit() {
        return velocityUnit;
    }

    public void setWindVelocityUnit(String velocityUnit) {
        if (velocityUnit != null) {
            this.velocityUnit = velocityUnit;
        }
    }


    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        if (humidity != null) {
            this.humidity = humidity;
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
        if (condition != null) {
            this.condition = condition;
        }
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


    public boolean isValid() {
        return true;
    }


    public boolean isEmpty(String string) {
        if (string == null || "NONE".equals(string) || "".equals(string) || "N/A".equals(string)) {
            return true;
        }
        return false;
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
