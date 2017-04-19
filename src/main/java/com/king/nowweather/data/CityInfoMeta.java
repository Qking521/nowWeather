package com.king.nowweather.data;

import java.util.List;

/**
 * Created by wangqiang on 2017/4/18.
 */

public class CityInfoMeta {
    private int Version;

    private String Key;

    private String Type;

    private int Rank;

    private String LocalizedName;

    private String EnglishName;

    private String PrimaryPostalCode;

    private Region Region;

    private Country Country;

    private AdministrativeArea AdministrativeArea;

    private TimeZone TimeZone;

    private GeoPosition GeoPosition;

    private boolean IsAlias;

    private List<String> DataSets ;

    private Details Details;
    /**
     * SupplementalAdminAreas : [{"LocalizedName":"苏州市","Level":2,"EnglishName":"Suzhou"}]
     */
    private List<SupplementalAdminAreasEntity> SupplementalAdminAreas;

    public void setVersion(int Version){
        this.Version = Version;
    }
    public int getVersion(){
        return this.Version;
    }
    public void setKey(String Key){
        this.Key = Key;
    }
    public String getKey(){
        return this.Key;
    }
    public void setType(String Type){
        this.Type = Type;
    }
    public String getType(){
        return this.Type;
    }
    public void setRank(int Rank){
        this.Rank = Rank;
    }
    public int getRank(){
        return this.Rank;
    }
    public void setLocalizedName(String LocalizedName){
        this.LocalizedName = LocalizedName;
    }
    public String getLocalizedName(){
        return this.LocalizedName;
    }
    public void setEnglishName(String EnglishName){
        this.EnglishName = EnglishName;
    }
    public String getEnglishName(){
        return this.EnglishName;
    }
    public void setPrimaryPostalCode(String PrimaryPostalCode){
        this.PrimaryPostalCode = PrimaryPostalCode;
    }
    public String getPrimaryPostalCode(){
        return this.PrimaryPostalCode;
    }
    public void setRegion(Region Region){
        this.Region = Region;
    }
    public Region getRegion(){
        return this.Region;
    }
    public void setCountry(Country Country){
        this.Country = Country;
    }
    public Country getCountry(){
        return this.Country;
    }
    public void setAdministrativeArea(AdministrativeArea AdministrativeArea){
        this.AdministrativeArea = AdministrativeArea;
    }
    public AdministrativeArea getAdministrativeArea(){
        return this.AdministrativeArea;
    }
    public void setTimeZone(TimeZone TimeZone){
        this.TimeZone = TimeZone;
    }
    public TimeZone getTimeZone(){
        return this.TimeZone;
    }
    public void setGeoPosition(GeoPosition GeoPosition){
        this.GeoPosition = GeoPosition;
    }
    public GeoPosition getGeoPosition(){
        return this.GeoPosition;
    }
    public void setIsAlias(boolean IsAlias){
        this.IsAlias = IsAlias;
    }
    public boolean getIsAlias(){
        return this.IsAlias;
    }
    public void setString(List<String> DataSets){
        this.DataSets = DataSets;
    }
    public List<String> getString(){
        return this.DataSets;
    }
    public void setDetails(Details Details){
        this.Details = Details;
    }
    public Details getDetails(){
        return this.Details;
    }

    public void setSupplementalAdminAreas(List<SupplementalAdminAreasEntity> SupplementalAdminAreas) {
        this.SupplementalAdminAreas = SupplementalAdminAreas;
    }

    public List<SupplementalAdminAreasEntity> getSupplementalAdminAreas() {
        return SupplementalAdminAreas;
    }

    public class Region {
        private String ID;

        private String LocalizedName;

        private String EnglishName;

        public void setID(String ID){
            this.ID = ID;
        }
        public String getID(){
            return this.ID;
        }
        public void setLocalizedName(String LocalizedName){
            this.LocalizedName = LocalizedName;
        }
        public String getLocalizedName(){
            return this.LocalizedName;
        }
        public void setEnglishName(String EnglishName){
            this.EnglishName = EnglishName;
        }
        public String getEnglishName(){
            return this.EnglishName;
        }

    }
    public class Country {
        private String ID;

        private String LocalizedName;

        private String EnglishName;

        public void setID(String ID){
            this.ID = ID;
        }
        public String getID(){
            return this.ID;
        }
        public void setLocalizedName(String LocalizedName){
            this.LocalizedName = LocalizedName;
        }
        public String getLocalizedName(){
            return this.LocalizedName;
        }
        public void setEnglishName(String EnglishName){
            this.EnglishName = EnglishName;
        }
        public String getEnglishName(){
            return this.EnglishName;
        }

    }
    public class AdministrativeArea {
        private String ID;

        private String LocalizedName;

        private String EnglishName;

        private int Level;

        private String LocalizedType;

        private String EnglishType;

        private String CountryID;

        public void setID(String ID){
            this.ID = ID;
        }
        public String getID(){
            return this.ID;
        }
        public void setLocalizedName(String LocalizedName){
            this.LocalizedName = LocalizedName;
        }
        public String getLocalizedName(){
            return this.LocalizedName;
        }
        public void setEnglishName(String EnglishName){
            this.EnglishName = EnglishName;
        }
        public String getEnglishName(){
            return this.EnglishName;
        }
        public void setLevel(int Level){
            this.Level = Level;
        }
        public int getLevel(){
            return this.Level;
        }
        public void setLocalizedType(String LocalizedType){
            this.LocalizedType = LocalizedType;
        }
        public String getLocalizedType(){
            return this.LocalizedType;
        }
        public void setEnglishType(String EnglishType){
            this.EnglishType = EnglishType;
        }
        public String getEnglishType(){
            return this.EnglishType;
        }
        public void setCountryID(String CountryID){
            this.CountryID = CountryID;
        }
        public String getCountryID(){
            return this.CountryID;
        }

    }
    public class TimeZone {
        private String Code;

        private String Name;

        private int GmtOffset;

        private boolean IsDaylightSaving;

        private String NextOffsetChange;

        public void setCode(String Code){
            this.Code = Code;
        }
        public String getCode(){
            return this.Code;
        }
        public void setName(String Name){
            this.Name = Name;
        }
        public String getName(){
            return this.Name;
        }
        public void setGmtOffset(int GmtOffset){
            this.GmtOffset = GmtOffset;
        }
        public int getGmtOffset(){
            return this.GmtOffset;
        }
        public void setIsDaylightSaving(boolean IsDaylightSaving){
            this.IsDaylightSaving = IsDaylightSaving;
        }
        public boolean getIsDaylightSaving(){
            return this.IsDaylightSaving;
        }
        public void setNextOffsetChange(String NextOffsetChange){
            this.NextOffsetChange = NextOffsetChange;
        }
        public String getNextOffsetChange(){
            return this.NextOffsetChange;
        }

    }
    public class Metric {
        private int Value;

        private String Unit;

        private int UnitType;

        public void setValue(int Value){
            this.Value = Value;
        }
        public int getValue(){
            return this.Value;
        }
        public void setUnit(String Unit){
            this.Unit = Unit;
        }
        public String getUnit(){
            return this.Unit;
        }
        public void setUnitType(int UnitType){
            this.UnitType = UnitType;
        }
        public int getUnitType(){
            return this.UnitType;
        }

    }
    public class Imperial {
        private int Value;

        private String Unit;

        private int UnitType;

        public void setValue(int Value){
            this.Value = Value;
        }
        public int getValue(){
            return this.Value;
        }
        public void setUnit(String Unit){
            this.Unit = Unit;
        }
        public String getUnit(){
            return this.Unit;
        }
        public void setUnitType(int UnitType){
            this.UnitType = UnitType;
        }
        public int getUnitType(){
            return this.UnitType;
        }

    }
    public class Elevation {
        private Metric Metric;

        private Imperial Imperial;

        public void setMetric(Metric Metric){
            this.Metric = Metric;
        }
        public Metric getMetric(){
            return this.Metric;
        }
        public void setImperial(Imperial Imperial){
            this.Imperial = Imperial;
        }
        public Imperial getImperial(){
            return this.Imperial;
        }

    }
    public class GeoPosition {
        private double Latitude;

        private double Longitude;

        private Elevation Elevation;

        public void setLatitude(double Latitude){
            this.Latitude = Latitude;
        }
        public double getLatitude(){
            return this.Latitude;
        }
        public void setLongitude(double Longitude){
            this.Longitude = Longitude;
        }
        public double getLongitude(){
            return this.Longitude;
        }
        public void setElevation(Elevation Elevation){
            this.Elevation = Elevation;
        }
        public Elevation getElevation(){
            return this.Elevation;
        }

    }
    public class Sources {
        private String DataType;

        private String Source;

        private int SourceId;

        public void setDataType(String DataType){
            this.DataType = DataType;
        }
        public String getDataType(){
            return this.DataType;
        }
        public void setSource(String Source){
            this.Source = Source;
        }
        public String getSource(){
            return this.Source;
        }
        public void setSourceId(int SourceId){
            this.SourceId = SourceId;
        }
        public int getSourceId(){
            return this.SourceId;
        }

    }
    public class Details {
        private String Key;

        private String StationCode;

        private int StationGmtOffset;

        private String BandMap;

        private String Climo;

        private String LocalRadar;

        private String MediaRegion;

        private String Metar;

        private String NXMetro;

        private String NXState;

        private int Population;

        private String PrimaryWarningCountyCode;

        private String PrimaryWarningZoneCode;

        private String Satellite;

        private String Synoptic;

        private String MarineStation;

        private String MarineStationGMTOffset;

        private String VideoCode;

        private String PartnerID;

        private List<Sources> Sources ;

        private String CanonicalPostalCode;

        private String CanonicalLocationKey;

        public void setKey(String Key){
            this.Key = Key;
        }
        public String getKey(){
            return this.Key;
        }
        public void setStationCode(String StationCode){
            this.StationCode = StationCode;
        }
        public String getStationCode(){
            return this.StationCode;
        }
        public void setStationGmtOffset(int StationGmtOffset){
            this.StationGmtOffset = StationGmtOffset;
        }
        public int getStationGmtOffset(){
            return this.StationGmtOffset;
        }
        public void setBandMap(String BandMap){
            this.BandMap = BandMap;
        }
        public String getBandMap(){
            return this.BandMap;
        }
        public void setClimo(String Climo){
            this.Climo = Climo;
        }
        public String getClimo(){
            return this.Climo;
        }
        public void setLocalRadar(String LocalRadar){
            this.LocalRadar = LocalRadar;
        }
        public String getLocalRadar(){
            return this.LocalRadar;
        }
        public void setMediaRegion(String MediaRegion){
            this.MediaRegion = MediaRegion;
        }
        public String getMediaRegion(){
            return this.MediaRegion;
        }
        public void setMetar(String Metar){
            this.Metar = Metar;
        }
        public String getMetar(){
            return this.Metar;
        }
        public void setNXMetro(String NXMetro){
            this.NXMetro = NXMetro;
        }
        public String getNXMetro(){
            return this.NXMetro;
        }
        public void setNXState(String NXState){
            this.NXState = NXState;
        }
        public String getNXState(){
            return this.NXState;
        }
        public void setPopulation(int Population){
            this.Population = Population;
        }
        public int getPopulation(){
            return this.Population;
        }
        public void setPrimaryWarningCountyCode(String PrimaryWarningCountyCode){
            this.PrimaryWarningCountyCode = PrimaryWarningCountyCode;
        }
        public String getPrimaryWarningCountyCode(){
            return this.PrimaryWarningCountyCode;
        }
        public void setPrimaryWarningZoneCode(String PrimaryWarningZoneCode){
            this.PrimaryWarningZoneCode = PrimaryWarningZoneCode;
        }
        public String getPrimaryWarningZoneCode(){
            return this.PrimaryWarningZoneCode;
        }
        public void setSatellite(String Satellite){
            this.Satellite = Satellite;
        }
        public String getSatellite(){
            return this.Satellite;
        }
        public void setSynoptic(String Synoptic){
            this.Synoptic = Synoptic;
        }
        public String getSynoptic(){
            return this.Synoptic;
        }
        public void setMarineStation(String MarineStation){
            this.MarineStation = MarineStation;
        }
        public String getMarineStation(){
            return this.MarineStation;
        }
        public void setMarineStationGMTOffset(String MarineStationGMTOffset){
            this.MarineStationGMTOffset = MarineStationGMTOffset;
        }
        public String getMarineStationGMTOffset(){
            return this.MarineStationGMTOffset;
        }
        public void setVideoCode(String VideoCode){
            this.VideoCode = VideoCode;
        }
        public String getVideoCode(){
            return this.VideoCode;
        }
        public void setPartnerID(String PartnerID){
            this.PartnerID = PartnerID;
        }
        public String getPartnerID(){
            return this.PartnerID;
        }
        public void setSources(List<Sources> Sources){
            this.Sources = Sources;
        }
        public List<Sources> getSources(){
            return this.Sources;
        }
        public void setCanonicalPostalCode(String CanonicalPostalCode){
            this.CanonicalPostalCode = CanonicalPostalCode;
        }
        public String getCanonicalPostalCode(){
            return this.CanonicalPostalCode;
        }
        public void setCanonicalLocationKey(String CanonicalLocationKey){
            this.CanonicalLocationKey = CanonicalLocationKey;
        }
        public String getCanonicalLocationKey(){
            return this.CanonicalLocationKey;
        }

    }


    public class SupplementalAdminAreasEntity {
        /**
         * LocalizedName : 苏州市
         * Level : 2
         * EnglishName : Suzhou
         */
        private String LocalizedName;
        private int Level;
        private String EnglishName;

        public void setLocalizedName(String LocalizedName) {
            this.LocalizedName = LocalizedName;
        }

        public void setLevel(int Level) {
            this.Level = Level;
        }

        public void setEnglishName(String EnglishName) {
            this.EnglishName = EnglishName;
        }

        public String getLocalizedName() {
            return LocalizedName;
        }

        public int getLevel() {
            return Level;
        }

        public String getEnglishName() {
            return EnglishName;
        }
    }
}
