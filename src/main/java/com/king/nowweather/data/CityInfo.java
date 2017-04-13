package com.king.nowweather.data;
public class CityInfo {
	String cityKey = "";
	String cityName = "";
	String country = "";
	String latitude = "";
	String longitude = "";
	String province = "";
	String fullName = "";
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCityKey() {
		return cityKey;
	}
	public void setCityKey(String cityKey) {
		this.cityKey = cityKey;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "citykey="+ cityKey + " ,cityName="+ cityName + " ,country="+ country+ " ,province="+
				province + " ,fullName="+ fullName + " ,latitude="+ latitude + " ,longitude="+
				longitude;
	}
}


