package com.king.nowweather.data;

import java.util.List;

/**
 * Created by wangqiang on 2017/4/18.
 */

public class WeatherForecastInfoMeta {

    private Headline Headline;

    private List<DailyForecasts> DailyForecasts;

    public void setHeadline(Headline Headline) {
        this.Headline = Headline;
    }

    public Headline getHeadline() {
        return this.Headline;
    }

    public void setDailyForecasts(List<DailyForecasts> DailyForecasts) {
        this.DailyForecasts = DailyForecasts;
    }

    public List<DailyForecasts> getDailyForecasts() {
        return this.DailyForecasts;
    }

    public class Headline {
        private String EffectiveDate;

        private int EffectiveEpochDate;

        private int Severity;

        private String Text;

        private String Category;

        private String EndDate;

        private String EndEpochDate;

        private String MobileLink;

        private String Link;

        public void setEffectiveDate(String EffectiveDate) {
            this.EffectiveDate = EffectiveDate;
        }

        public String getEffectiveDate() {
            return this.EffectiveDate;
        }

        public void setEffectiveEpochDate(int EffectiveEpochDate) {
            this.EffectiveEpochDate = EffectiveEpochDate;
        }

        public int getEffectiveEpochDate() {
            return this.EffectiveEpochDate;
        }

        public void setSeverity(int Severity) {
            this.Severity = Severity;
        }

        public int getSeverity() {
            return this.Severity;
        }

        public void setText(String Text) {
            this.Text = Text;
        }

        public String getText() {
            return this.Text;
        }

        public void setCategory(String Category) {
            this.Category = Category;
        }

        public String getCategory() {
            return this.Category;
        }

        public void setEndDate(String EndDate) {
            this.EndDate = EndDate;
        }

        public String getEndDate() {
            return this.EndDate;
        }

        public void setEndEpochDate(String EndEpochDate) {
            this.EndEpochDate = EndEpochDate;
        }

        public String getEndEpochDate() {
            return this.EndEpochDate;
        }

        public void setMobileLink(String MobileLink) {
            this.MobileLink = MobileLink;
        }

        public String getMobileLink() {
            return this.MobileLink;
        }

        public void setLink(String Link) {
            this.Link = Link;
        }

        public String getLink() {
            return this.Link;
        }

    }

    public class Sun {
        private String Rise;

        private int EpochRise;

        private String Set;

        private int EpochSet;

        public void setRise(String Rise) {
            this.Rise = Rise;
        }

        public String getRise() {
            return this.Rise;
        }

        public void setEpochRise(int EpochRise) {
            this.EpochRise = EpochRise;
        }

        public int getEpochRise() {
            return this.EpochRise;
        }

        public void setSet(String Set) {
            this.Set = Set;
        }

        public String getSet() {
            return this.Set;
        }

        public void setEpochSet(int EpochSet) {
            this.EpochSet = EpochSet;
        }

        public int getEpochSet() {
            return this.EpochSet;
        }

    }

    public class Moon {
        private String Rise;

        private String EpochRise;

        private String Set;

        private int EpochSet;

        private String Phase;

        private int Age;

        public void setRise(String Rise) {
            this.Rise = Rise;
        }

        public String getRise() {
            return this.Rise;
        }

        public void setEpochRise(String EpochRise) {
            this.EpochRise = EpochRise;
        }

        public String getEpochRise() {
            return this.EpochRise;
        }

        public void setSet(String Set) {
            this.Set = Set;
        }

        public String getSet() {
            return this.Set;
        }

        public void setEpochSet(int EpochSet) {
            this.EpochSet = EpochSet;
        }

        public int getEpochSet() {
            return this.EpochSet;
        }

        public void setPhase(String Phase) {
            this.Phase = Phase;
        }

        public String getPhase() {
            return this.Phase;
        }

        public void setAge(int Age) {
            this.Age = Age;
        }

        public int getAge() {
            return this.Age;
        }

    }

    public class Minimum {
        private double Value;

        private String Unit;

        private int UnitType;

        public void setValue(double Value) {
            this.Value = Value;
        }

        public double getValue() {
            return this.Value;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getUnit() {
            return this.Unit;
        }

        public void setUnitType(int UnitType) {
            this.UnitType = UnitType;
        }

        public int getUnitType() {
            return this.UnitType;
        }

    }

    public class Maximum {
        private double Value;

        private String Unit;

        private int UnitType;

        public void setValue(double Value) {
            this.Value = Value;
        }

        public double getValue() {
            return this.Value;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getUnit() {
            return this.Unit;
        }

        public void setUnitType(int UnitType) {
            this.UnitType = UnitType;
        }

        public int getUnitType() {
            return this.UnitType;
        }

    }

    public class Temperature {
        private Minimum Minimum;

        private Maximum Maximum;

        public void setMinimum(Minimum Minimum) {
            this.Minimum = Minimum;
        }

        public Minimum getMinimum() {
            return this.Minimum;
        }

        public void setMaximum(Maximum Maximum) {
            this.Maximum = Maximum;
        }

        public Maximum getMaximum() {
            return this.Maximum;
        }

    }


    public class RealFeelTemperature {
        private Minimum Minimum;

        private Maximum Maximum;

        public void setMinimum(Minimum Minimum) {
            this.Minimum = Minimum;
        }

        public Minimum getMinimum() {
            return this.Minimum;
        }

        public void setMaximum(Maximum Maximum) {
            this.Maximum = Maximum;
        }

        public Maximum getMaximum() {
            return this.Maximum;
        }

    }


    public class RealFeelTemperatureShade {
        private Minimum Minimum;

        private Maximum Maximum;

        public void setMinimum(Minimum Minimum) {
            this.Minimum = Minimum;
        }

        public Minimum getMinimum() {
            return this.Minimum;
        }

        public void setMaximum(Maximum Maximum) {
            this.Maximum = Maximum;
        }

        public Maximum getMaximum() {
            return this.Maximum;
        }

    }

    public class Heating {
        private int Value;

        private String Unit;

        private int UnitType;

        public void setValue(int Value) {
            this.Value = Value;
        }

        public int getValue() {
            return this.Value;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getUnit() {
            return this.Unit;
        }

        public void setUnitType(int UnitType) {
            this.UnitType = UnitType;
        }

        public int getUnitType() {
            return this.UnitType;
        }

    }

    public class Cooling {
        private int Value;

        private String Unit;

        private int UnitType;

        public void setValue(int Value) {
            this.Value = Value;
        }

        public int getValue() {
            return this.Value;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getUnit() {
            return this.Unit;
        }

        public void setUnitType(int UnitType) {
            this.UnitType = UnitType;
        }

        public int getUnitType() {
            return this.UnitType;
        }

    }

    public class DegreeDaySummary {
        private Heating Heating;

        private Cooling Cooling;

        public void setHeating(Heating Heating) {
            this.Heating = Heating;
        }

        public Heating getHeating() {
            return this.Heating;
        }

        public void setCooling(Cooling Cooling) {
            this.Cooling = Cooling;
        }

        public Cooling getCooling() {
            return this.Cooling;
        }

    }

    public class LocalSource {
        private int Id;

        private String Name;

        private String WeatherCode;

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getId() {
            return this.Id;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getName() {
            return this.Name;
        }

        public void setWeatherCode(String WeatherCode) {
            this.WeatherCode = WeatherCode;
        }

        public String getWeatherCode() {
            return this.WeatherCode;
        }

    }

    public class Speed {
        private double Value;

        private String Unit;

        private int UnitType;

        public void setValue(double Value) {
            this.Value = Value;
        }

        public double getValue() {
            return this.Value;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getUnit() {
            return this.Unit;
        }

        public void setUnitType(int UnitType) {
            this.UnitType = UnitType;
        }

        public int getUnitType() {
            return this.UnitType;
        }

    }

    public class Direction {
        private int Degrees;

        private String Localized;

        private String English;

        public void setDegrees(int Degrees) {
            this.Degrees = Degrees;
        }

        public int getDegrees() {
            return this.Degrees;
        }

        public void setLocalized(String Localized) {
            this.Localized = Localized;
        }

        public String getLocalized() {
            return this.Localized;
        }

        public void setEnglish(String English) {
            this.English = English;
        }

        public String getEnglish() {
            return this.English;
        }

    }

    public class Wind {
        private Speed Speed;

        private Direction Direction;

        public void setSpeed(Speed Speed) {
            this.Speed = Speed;
        }

        public Speed getSpeed() {
            return this.Speed;
        }

        public void setDirection(Direction Direction) {
            this.Direction = Direction;
        }

        public Direction getDirection() {
            return this.Direction;
        }

    }

    public class WindGust {
        private Speed Speed;

        private Direction Direction;

        public void setSpeed(Speed Speed) {
            this.Speed = Speed;
        }

        public Speed getSpeed() {
            return this.Speed;
        }

        public void setDirection(Direction Direction) {
            this.Direction = Direction;
        }

        public Direction getDirection() {
            return this.Direction;
        }

    }

    public class TotalLiquid {
        private int Value;

        private String Unit;

        private int UnitType;

        public void setValue(int Value) {
            this.Value = Value;
        }

        public int getValue() {
            return this.Value;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getUnit() {
            return this.Unit;
        }

        public void setUnitType(int UnitType) {
            this.UnitType = UnitType;
        }

        public int getUnitType() {
            return this.UnitType;
        }

    }

    public class Rain {
        private int Value;

        private String Unit;

        private int UnitType;

        public void setValue(int Value) {
            this.Value = Value;
        }

        public int getValue() {
            return this.Value;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getUnit() {
            return this.Unit;
        }

        public void setUnitType(int UnitType) {
            this.UnitType = UnitType;
        }

        public int getUnitType() {
            return this.UnitType;
        }

    }

    public class Snow {
        private int Value;

        private String Unit;

        private int UnitType;

        public void setValue(int Value) {
            this.Value = Value;
        }

        public int getValue() {
            return this.Value;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getUnit() {
            return this.Unit;
        }

        public void setUnitType(int UnitType) {
            this.UnitType = UnitType;
        }

        public int getUnitType() {
            return this.UnitType;
        }

    }

    public class Ice {
        private int Value;

        private String Unit;

        private int UnitType;

        public void setValue(int Value) {
            this.Value = Value;
        }

        public int getValue() {
            return this.Value;
        }

        public void setUnit(String Unit) {
            this.Unit = Unit;
        }

        public String getUnit() {
            return this.Unit;
        }

        public void setUnitType(int UnitType) {
            this.UnitType = UnitType;
        }

        public int getUnitType() {
            return this.UnitType;
        }

    }

    public class Day {
        private int Icon;

        private String IconPhrase;

        private LocalSource LocalSource;

        private String ShortPhrase;

        private String LongPhrase;

        private int PrecipitationProbability;

        private int ThunderstormProbability;

        private int RainProbability;

        private int SnowProbability;

        private int IceProbability;

        private Wind Wind;

        private WindGust WindGust;

        private TotalLiquid TotalLiquid;

        private Rain Rain;

        private Snow Snow;

        private Ice Ice;

        private double HoursOfPrecipitation;

        private double HoursOfRain;

        private double HoursOfSnow;

        private double HoursOfIce;

        private double CloudCover;

        public void setIcon(int Icon) {
            this.Icon = Icon;
        }

        public int getIcon() {
            return this.Icon;
        }

        public void setIconPhrase(String IconPhrase) {
            this.IconPhrase = IconPhrase;
        }

        public String getIconPhrase() {
            return this.IconPhrase;
        }

        public void setLocalSource(LocalSource LocalSource) {
            this.LocalSource = LocalSource;
        }

        public LocalSource getLocalSource() {
            return this.LocalSource;
        }

        public void setShortPhrase(String ShortPhrase) {
            this.ShortPhrase = ShortPhrase;
        }

        public String getShortPhrase() {
            return this.ShortPhrase;
        }

        public void setLongPhrase(String LongPhrase) {
            this.LongPhrase = LongPhrase;
        }

        public String getLongPhrase() {
            return this.LongPhrase;
        }

        public void setPrecipitationProbability(int PrecipitationProbability) {
            this.PrecipitationProbability = PrecipitationProbability;
        }

        public int getPrecipitationProbability() {
            return this.PrecipitationProbability;
        }

        public void setThunderstormProbability(int ThunderstormProbability) {
            this.ThunderstormProbability = ThunderstormProbability;
        }

        public int getThunderstormProbability() {
            return this.ThunderstormProbability;
        }

        public void setRainProbability(int RainProbability) {
            this.RainProbability = RainProbability;
        }

        public int getRainProbability() {
            return this.RainProbability;
        }

        public void setSnowProbability(int SnowProbability) {
            this.SnowProbability = SnowProbability;
        }

        public int getSnowProbability() {
            return this.SnowProbability;
        }

        public void setIceProbability(int IceProbability) {
            this.IceProbability = IceProbability;
        }

        public int getIceProbability() {
            return this.IceProbability;
        }

        public void setWind(Wind Wind) {
            this.Wind = Wind;
        }

        public Wind getWind() {
            return this.Wind;
        }

        public void setWindGust(WindGust WindGust) {
            this.WindGust = WindGust;
        }

        public WindGust getWindGust() {
            return this.WindGust;
        }

        public void setTotalLiquid(TotalLiquid TotalLiquid) {
            this.TotalLiquid = TotalLiquid;
        }

        public TotalLiquid getTotalLiquid() {
            return this.TotalLiquid;
        }

        public void setRain(Rain Rain) {
            this.Rain = Rain;
        }

        public Rain getRain() {
            return this.Rain;
        }

        public void setSnow(Snow Snow) {
            this.Snow = Snow;
        }

        public Snow getSnow() {
            return this.Snow;
        }

        public void setIce(Ice Ice) {
            this.Ice = Ice;
        }

        public Ice getIce() {
            return this.Ice;
        }

        public void setHoursOfPrecipitation(double HoursOfPrecipitation) {
            this.HoursOfPrecipitation = HoursOfPrecipitation;
        }

        public double getHoursOfPrecipitation() {
            return this.HoursOfPrecipitation;
        }

        public void setHoursOfRain(double HoursOfRain) {
            this.HoursOfRain = HoursOfRain;
        }

        public double getHoursOfRain() {
            return this.HoursOfRain;
        }

        public void setHoursOfSnow(double HoursOfSnow) {
            this.HoursOfSnow = HoursOfSnow;
        }

        public double getHoursOfSnow() {
            return this.HoursOfSnow;
        }

        public void setHoursOfIce(double HoursOfIce) {
            this.HoursOfIce = HoursOfIce;
        }

        public double getHoursOfIce() {
            return this.HoursOfIce;
        }

        public void setCloudCover(double CloudCover) {
            this.CloudCover = CloudCover;
        }

        public double getCloudCover() {
            return this.CloudCover;
        }

    }

    public class Night {
        private int Icon;

        private String IconPhrase;

        private LocalSource LocalSource;

        private String ShortPhrase;

        private String LongPhrase;

        private int PrecipitationProbability;

        private int ThunderstormProbability;

        private int RainProbability;

        private int SnowProbability;

        private int IceProbability;

        private Wind Wind;

        private WindGust WindGust;

        private TotalLiquid TotalLiquid;

        private Rain Rain;

        private Snow Snow;

        private Ice Ice;

        private double HoursOfPrecipitation;

        private double HoursOfRain;

        private double HoursOfSnow;

        private double HoursOfIce;

        private double CloudCover;

        public void setIcon(int Icon){
            this.Icon = Icon;
        }
        public int getIcon(){
            return this.Icon;
        }
        public void setIconPhrase(String IconPhrase){
            this.IconPhrase = IconPhrase;
        }
        public String getIconPhrase(){
            return this.IconPhrase;
        }
        public void setLocalSource(LocalSource LocalSource){
            this.LocalSource = LocalSource;
        }
        public LocalSource getLocalSource(){
            return this.LocalSource;
        }
        public void setShortPhrase(String ShortPhrase){
            this.ShortPhrase = ShortPhrase;
        }
        public String getShortPhrase(){
            return this.ShortPhrase;
        }
        public void setLongPhrase(String LongPhrase){
            this.LongPhrase = LongPhrase;
        }
        public String getLongPhrase(){
            return this.LongPhrase;
        }
        public void setPrecipitationProbability(int PrecipitationProbability){
            this.PrecipitationProbability = PrecipitationProbability;
        }
        public int getPrecipitationProbability(){
            return this.PrecipitationProbability;
        }
        public void setThunderstormProbability(int ThunderstormProbability){
            this.ThunderstormProbability = ThunderstormProbability;
        }
        public int getThunderstormProbability(){
            return this.ThunderstormProbability;
        }
        public void setRainProbability(int RainProbability){
            this.RainProbability = RainProbability;
        }
        public int getRainProbability(){
            return this.RainProbability;
        }
        public void setSnowProbability(int SnowProbability){
            this.SnowProbability = SnowProbability;
        }
        public int getSnowProbability(){
            return this.SnowProbability;
        }
        public void setIceProbability(int IceProbability){
            this.IceProbability = IceProbability;
        }
        public int getIceProbability(){
            return this.IceProbability;
        }
        public void setWind(Wind Wind){
            this.Wind = Wind;
        }
        public Wind getWind(){
            return this.Wind;
        }
        public void setWindGust(WindGust WindGust){
            this.WindGust = WindGust;
        }
        public WindGust getWindGust(){
            return this.WindGust;
        }
        public void setTotalLiquid(TotalLiquid TotalLiquid){
            this.TotalLiquid = TotalLiquid;
        }
        public TotalLiquid getTotalLiquid(){
            return this.TotalLiquid;
        }
        public void setRain(Rain Rain){
            this.Rain = Rain;
        }
        public Rain getRain(){
            return this.Rain;
        }
        public void setSnow(Snow Snow){
            this.Snow = Snow;
        }
        public Snow getSnow(){
            return this.Snow;
        }
        public void setIce(Ice Ice){
            this.Ice = Ice;
        }
        public Ice getIce(){
            return this.Ice;
        }
        public void setHoursOfPrecipitation(double HoursOfPrecipitation){
            this.HoursOfPrecipitation = HoursOfPrecipitation;
        }
        public double getHoursOfPrecipitation(){
            return this.HoursOfPrecipitation;
        }
        public void setHoursOfRain(double HoursOfRain){
            this.HoursOfRain = HoursOfRain;
        }
        public double getHoursOfRain(){
            return this.HoursOfRain;
        }
        public void setHoursOfSnow(double HoursOfSnow){
            this.HoursOfSnow = HoursOfSnow;
        }
        public double getHoursOfSnow(){
            return this.HoursOfSnow;
        }
        public void setHoursOfIce(double HoursOfIce){
            this.HoursOfIce = HoursOfIce;
        }
        public double getHoursOfIce(){
            return this.HoursOfIce;
        }
        public void setCloudCover(double CloudCover){
            this.CloudCover = CloudCover;
        }
        public double getCloudCover(){
            return this.CloudCover;
        }

    }

    public class AirAndPollen {
        private String Name;

        private int Value;

        private String Category;

        private int CategoryValue;

        private String Type;

        public void setName(String Name){
            this.Name = Name;
        }
        public String getName(){
            return this.Name;
        }
        public void setValue(int Value){
            this.Value = Value;
        }
        public int getValue(){
            return this.Value;
        }
        public void setCategory(String Category){
            this.Category = Category;
        }
        public String getCategory(){
            return this.Category;
        }
        public void setCategoryValue(int CategoryValue){
            this.CategoryValue = CategoryValue;
        }
        public int getCategoryValue(){
            return this.CategoryValue;
        }
        public void setType(String Type){
            this.Type = Type;
        }
        public String getType(){
            return this.Type;
        }

    }


    public class DailyForecasts {
        private String Date;

        private int EpochDate;

        private Sun Sun;

        private Moon Moon;

        private Temperature Temperature;

        private RealFeelTemperature RealFeelTemperature;

        private RealFeelTemperatureShade RealFeelTemperatureShade;

        private double HoursOfSun;

        private DegreeDaySummary DegreeDaySummary;

        private List<AirAndPollen> AirAndPollen ;

        private Day Day;

        private Night Night;

        private List<String> Sources ;

        private String MobileLink;

        private String Link;

        public void setDate(String Date){
            this.Date = Date;
        }
        public String getDate(){
            return this.Date;
        }
        public void setEpochDate(int EpochDate){
            this.EpochDate = EpochDate;
        }
        public int getEpochDate(){
            return this.EpochDate;
        }
        public void setSun(Sun Sun){
            this.Sun = Sun;
        }
        public Sun getSun(){
            return this.Sun;
        }
        public void setMoon(Moon Moon){
            this.Moon = Moon;
        }
        public Moon getMoon(){
            return this.Moon;
        }
        public void setTemperature(Temperature Temperature){
            this.Temperature = Temperature;
        }
        public Temperature getTemperature(){
            return this.Temperature;
        }
        public void setRealFeelTemperature(RealFeelTemperature RealFeelTemperature){
            this.RealFeelTemperature = RealFeelTemperature;
        }
        public RealFeelTemperature getRealFeelTemperature(){
            return this.RealFeelTemperature;
        }
        public void setRealFeelTemperatureShade(RealFeelTemperatureShade RealFeelTemperatureShade){
            this.RealFeelTemperatureShade = RealFeelTemperatureShade;
        }
        public RealFeelTemperatureShade getRealFeelTemperatureShade(){
            return this.RealFeelTemperatureShade;
        }
        public void setHoursOfSun(double HoursOfSun){
            this.HoursOfSun = HoursOfSun;
        }
        public double getHoursOfSun(){
            return this.HoursOfSun;
        }
        public void setDegreeDaySummary(DegreeDaySummary DegreeDaySummary){
            this.DegreeDaySummary = DegreeDaySummary;
        }
        public DegreeDaySummary getDegreeDaySummary(){
            return this.DegreeDaySummary;
        }
        public void setAirAndPollen(List<AirAndPollen> AirAndPollen){
            this.AirAndPollen = AirAndPollen;
        }
        public List<AirAndPollen> getAirAndPollen(){
            return this.AirAndPollen;
        }
        public void setDay(Day Day){
            this.Day = Day;
        }
        public Day getDay(){
            return this.Day;
        }
        public void setNight(Night Night){
            this.Night = Night;
        }
        public Night getNight(){
            return this.Night;
        }
        public void setString(List<String> Sources){
            this.Sources = Sources;
        }
        public List<String> getString(){
            return this.Sources;
        }
        public void setMobileLink(String MobileLink){
            this.MobileLink = MobileLink;
        }
        public String getMobileLink(){
            return this.MobileLink;
        }
        public void setLink(String Link){
            this.Link = Link;
        }
        public String getLink(){
            return this.Link;
        }

    }
}
