package com.king.nowweather.data;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public final class WeatherData extends Details implements Comparable<WeatherData> {


    private String cityName = ""; // city name
    private String city = "";
    private String province = "";
    private String responseCityName = ""; // city name from server
    private String fullName = "";
	private String postalCode = "";
    private String longitude = "";
    private String latitude = "";
    private String curTemp = "";
    private String timeZone = "";
    private String curDate = "";
    private String curDayOfWeek = "";
    private Calendar calendar = null;
    private String realfeel = ""; //that is personal feeling
    private String location = "";
	private String locationCity = "false";
    private boolean notifyAlarm = false;
    private boolean inStatusBar = false;

    private long lastRefreshTime = 0;
    private String lastRefreshString = "";
    private List<ForecastDetail> forecastDetail = new ArrayList<ForecastDetail>();


    public String getCityName() {
        return cityName;
    }


    public String city() {
        return city;
    }


    public String province() {
        return province;
    }

    public void setCityName(String cityName) {
        if (cityName != null) {
            this.cityName = cityName;
            String[] name = cityName.split(",");
            if (name != null && name.length >= 2) {
                city = name[0];
                province = name[1];
            } else {
                city = cityName;
            }
        }
    }


    public String getResponseCityName() {
        return responseCityName;
    }

    public void setResponseCityName(String responseCityName) {
        if (responseCityName != null) {
            this.responseCityName = responseCityName;
        }
    }
    
    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

//
    String getPostalCode() {
        return postalCode;
    }

    void setPostalCode(String postalCode) {
        if (postalCode != null) {
            this.postalCode = postalCode;
        }
    }

    public String getRealfeel() {
		return realfeel;
	}

	public void setRealfeel(String realfeel) {
		if (realfeel != null) {
			this.realfeel = realfeel;
		}
	}

    public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        if (latitude != null) {
            this.latitude = latitude;
        }
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        if (longitude != null) {
            this.longitude = longitude;
        }
    }


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


    public long lastRefreshed() {
        return lastRefreshTime;
    }


    public String getLastRefreshTime() {
        if (isEmpty(lastRefreshString)) {
            lastRefreshString = getLastRefreshTime("yyyy/MM/dd HH:mm");
        }
        return lastRefreshString;
    }


    public String getLastRefreshTime(String format) {
        if (format == null || "".equals(format)) {
            format = "yyyy/MM/dd HH:mm";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(lastRefreshTime);
    }

    public void setLastRefreshTime(long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }


    public String getCurrentDate() {
        return curDate;
    }

    public void setCurrentDate(String curDate) {
        if (curDate != null) {
            this.curDate = curDate;
        }
    }


    public String getCurrentDayOfWeek() {
        return curDayOfWeek;
    }

    public void setCurrentDayOfWeek(String curDayOfWeek) {
        if (curDayOfWeek != null) {
            this.curDayOfWeek = curDayOfWeek;
        }
    }

    public CityInfo createCityInfo() {
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCityKey(location);
        cityInfo.setCityName(cityName);
        cityInfo.setLatitude(latitude);
        cityInfo.setLongitude(longitude);
        cityInfo.setFullName(fullName);
        return cityInfo;
    }


    public Calendar getCalendar() {
        if (calendar == null) {
            if (timeZone != null && !"".equals(timeZone)) {
                calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZone));
            } else {
                calendar = Util.calendar;
            }
        }
        return calendar;
    }


    String getTimeZone() {
        return this.timeZone;
    }


    public void setTimeZone(String timeZone) {
        if (timeZone != null) {
            this.timeZone = timeZone;
        }
    }


    public boolean isDaylight() {
        Calendar c = getCalendar();
        if (c != null) {
            c.setTimeInMillis(System.currentTimeMillis());
            int hour = c.get(Calendar.HOUR_OF_DAY);
            return (hour >= DAYLIGHT_TIME_START && hour <= DAYLIGHT_TIME_END);
        }
        return true;
    }


    public boolean isInStatusBar() {
        return inStatusBar;
    }

    public void setInStatusBar(boolean statusBar) {
        this.inStatusBar = statusBar;
    }


    public boolean isNotifyAlarm() {
        return notifyAlarm;
    }

    public void setNotifyAlarm(boolean notifyAlarm) {
        this.notifyAlarm = notifyAlarm;
    }


    public boolean isLocationCity() {
        return "true".equals(locationCity);
    }

    String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }


    public List<ForecastDetail> getForecastDetailList() {
        return forecastDetail;
    }

    public void setForecastDetail(List<ForecastDetail> forecastDetail) {
        if (forecastDetail != null) {
            this.forecastDetail = forecastDetail;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof WeatherData) {
            WeatherData data = (WeatherData) object;
            return this.cityName.equals(data.cityName);
        }
        return false;
    }

    @Override
    public boolean isValid() {
        return (!isEmpty(cityName) && super.isValid());
    }


    public static class ForecastDetail extends Details {
        private int orderId = 0;


        int order() {
            return orderId;
        }

        void setOrderId(int orderId) {
            this.orderId = orderId;
        }
    }


    @Override
    public int compareTo(WeatherData another) {
        return 0;
    }

    public void setLocatedCity(String locationCity) {
        this.locationCity = locationCity;
    }
}
