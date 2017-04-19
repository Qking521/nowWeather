package com.king.nowweather.data;

/**
 * Created by wangqiang on 2017/4/18.
 */

public class WeatherInfoMeta {

    /**
     * Wind : {"Speed":{"Metric":{"UnitType":7,"Value":18.5,"Unit":"km/h"},"Imperial":{"UnitType":9,"Value":11.5,"Unit":"mi/h"}},"Direction":{"English":"NNW","Degrees":338,"Localized":"西北偏北"}}
     * Temperature : {"Metric":{"UnitType":17,"Value":10.7,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}}
     * Past24HourTemperatureDeparture : {"Metric":{"UnitType":17,"Value":-8.4,"Unit":"C"},"Imperial":{"UnitType":18,"Value":-15,"Unit":"F"}}
     * PressureTendency : {"Code":"F","LocalizedText":"下降"}
     * ObstructionsToVisibility : R-
     * Ceiling : {"Metric":{"UnitType":5,"Value":3048,"Unit":"m"},"Imperial":{"UnitType":0,"Value":10000,"Unit":"ft"}}
     * RealFeelTemperatureShade : {"Metric":{"UnitType":17,"Value":5.5,"Unit":"C"},"Imperial":{"UnitType":18,"Value":42,"Unit":"F"}}
     * EpochTime : 1492508100
     * RealFeelTemperature : {"Metric":{"UnitType":17,"Value":5.5,"Unit":"C"},"Imperial":{"UnitType":18,"Value":42,"Unit":"F"}}
     * RelativeHumidity : 60
     * PrecipitationSummary : {"Past6Hours":{"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.02,"Unit":"in"}},"Precipitation":{"Metric":{"UnitType":3,"Value":0,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0,"Unit":"in"}},"Past9Hours":{"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.04,"Unit":"in"}},"Past3Hours":{"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.02,"Unit":"in"}},"PastHour":{"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.02,"Unit":"in"}},"Past18Hours":{"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.05,"Unit":"in"}},"Past24Hours":{"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.05,"Unit":"in"}},"Past12Hours":{"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.04,"Unit":"in"}}}
     * TemperatureSummary : {"Past6HourRange":{"Minimum":{"Metric":{"UnitType":17,"Value":10.7,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}},"Maximum":{"Metric":{"UnitType":17,"Value":15.6,"Unit":"C"},"Imperial":{"UnitType":18,"Value":60,"Unit":"F"}}},"Past24HourRange":{"Minimum":{"Metric":{"UnitType":17,"Value":10.7,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}},"Maximum":{"Metric":{"UnitType":17,"Value":23.4,"Unit":"C"},"Imperial":{"UnitType":18,"Value":74,"Unit":"F"}}},"Past12HourRange":{"Minimum":{"Metric":{"UnitType":17,"Value":10.7,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}},"Maximum":{"Metric":{"UnitType":17,"Value":19.6,"Unit":"C"},"Imperial":{"UnitType":18,"Value":67,"Unit":"F"}}}}
     * LocalObservationDateTime : 2017-04-18T17:35:00+08:00
     * UVIndexText : 低
     * WeatherText : 阵雨
     * CloudCover : 100
     * LocalSource : {"WeatherCode":"03","Id":7,"Name":"Huafeng"}
     * WindGust : {"Speed":{"Metric":{"UnitType":7,"Value":24.8,"Unit":"km/h"},"Imperial":{"UnitType":9,"Value":15.4,"Unit":"mi/h"}}}
     * UVIndex : 1
     * Precip1hr : {"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.02,"Unit":"in"}}
     * WeatherIcon : 12
     * DewPoint : {"Metric":{"UnitType":17,"Value":3.3,"Unit":"C"},"Imperial":{"UnitType":18,"Value":38,"Unit":"F"}}
     * Pressure : {"Metric":{"UnitType":14,"Value":1014.4,"Unit":"mb"},"Imperial":{"UnitType":12,"Value":29.96,"Unit":"inHg"}}
     * IsDayTime : true
     * ApparentTemperature : {"Metric":{"UnitType":17,"Value":12.2,"Unit":"C"},"Imperial":{"UnitType":18,"Value":54,"Unit":"F"}}
     * WetBulbTemperature : {"Metric":{"UnitType":17,"Value":7.1,"Unit":"C"},"Imperial":{"UnitType":18,"Value":45,"Unit":"F"}}
     * Visibility : {"Metric":{"UnitType":6,"Value":9.7,"Unit":"km"},"Imperial":{"UnitType":2,"Value":6,"Unit":"mi"}}
     * WindChillTemperature : {"Metric":{"UnitType":17,"Value":10.6,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}}
     * Link : http://www.accuweather.com/zh/cn/suzhou-district/2-58039_13_al/current-weather/2-58039_13_al
     * MobileLink : http://m.accuweather.com/zh/cn/suzhou-district/2-58039_13_al/current-weather/2-58039_13_al
     */
    private WindEntity Wind;
    private TemperatureEntity Temperature;
    private Past24HourTemperatureDepartureEntity Past24HourTemperatureDeparture;
    private PressureTendencyEntity PressureTendency;
    private String ObstructionsToVisibility;
    private CeilingEntity Ceiling;
    private RealFeelTemperatureShadeEntity RealFeelTemperatureShade;
    private int EpochTime;
    private RealFeelTemperatureEntity RealFeelTemperature;
    private int RelativeHumidity;
    private PrecipitationSummaryEntity PrecipitationSummary;
    private TemperatureSummaryEntity TemperatureSummary;
    private String LocalObservationDateTime;
    private String UVIndexText;
    private String WeatherText;
    private int CloudCover;
    private LocalSourceEntity LocalSource;
    private WindGustEntity WindGust;
    private int UVIndex;
    private Precip1hrEntity Precip1hr;
    private int WeatherIcon;
    private DewPointEntity DewPoint;
    private PressureEntity Pressure;
    private boolean IsDayTime;
    private ApparentTemperatureEntity ApparentTemperature;
    private WetBulbTemperatureEntity WetBulbTemperature;
    private VisibilityEntity Visibility;
    private WindChillTemperatureEntity WindChillTemperature;
    private String Link;
    private String MobileLink;

    public void setWind(WindEntity Wind) {
        this.Wind = Wind;
    }

    public void setTemperature(TemperatureEntity Temperature) {
        this.Temperature = Temperature;
    }

    public void setPast24HourTemperatureDeparture(Past24HourTemperatureDepartureEntity Past24HourTemperatureDeparture) {
        this.Past24HourTemperatureDeparture = Past24HourTemperatureDeparture;
    }

    public void setPressureTendency(PressureTendencyEntity PressureTendency) {
        this.PressureTendency = PressureTendency;
    }

    public void setObstructionsToVisibility(String ObstructionsToVisibility) {
        this.ObstructionsToVisibility = ObstructionsToVisibility;
    }

    public void setCeiling(CeilingEntity Ceiling) {
        this.Ceiling = Ceiling;
    }

    public void setRealFeelTemperatureShade(RealFeelTemperatureShadeEntity RealFeelTemperatureShade) {
        this.RealFeelTemperatureShade = RealFeelTemperatureShade;
    }

    public void setEpochTime(int EpochTime) {
        this.EpochTime = EpochTime;
    }

    public void setRealFeelTemperature(RealFeelTemperatureEntity RealFeelTemperature) {
        this.RealFeelTemperature = RealFeelTemperature;
    }

    public void setRelativeHumidity(int RelativeHumidity) {
        this.RelativeHumidity = RelativeHumidity;
    }

    public void setPrecipitationSummary(PrecipitationSummaryEntity PrecipitationSummary) {
        this.PrecipitationSummary = PrecipitationSummary;
    }

    public void setTemperatureSummary(TemperatureSummaryEntity TemperatureSummary) {
        this.TemperatureSummary = TemperatureSummary;
    }

    public void setLocalObservationDateTime(String LocalObservationDateTime) {
        this.LocalObservationDateTime = LocalObservationDateTime;
    }

    public void setUVIndexText(String UVIndexText) {
        this.UVIndexText = UVIndexText;
    }

    public void setWeatherText(String WeatherText) {
        this.WeatherText = WeatherText;
    }

    public void setCloudCover(int CloudCover) {
        this.CloudCover = CloudCover;
    }

    public void setLocalSource(LocalSourceEntity LocalSource) {
        this.LocalSource = LocalSource;
    }

    public void setWindGust(WindGustEntity WindGust) {
        this.WindGust = WindGust;
    }

    public void setUVIndex(int UVIndex) {
        this.UVIndex = UVIndex;
    }

    public void setPrecip1hr(Precip1hrEntity Precip1hr) {
        this.Precip1hr = Precip1hr;
    }

    public void setWeatherIcon(int WeatherIcon) {
        this.WeatherIcon = WeatherIcon;
    }

    public void setDewPoint(DewPointEntity DewPoint) {
        this.DewPoint = DewPoint;
    }

    public void setPressure(PressureEntity Pressure) {
        this.Pressure = Pressure;
    }

    public void setIsDayTime(boolean IsDayTime) {
        this.IsDayTime = IsDayTime;
    }

    public void setApparentTemperature(ApparentTemperatureEntity ApparentTemperature) {
        this.ApparentTemperature = ApparentTemperature;
    }

    public void setWetBulbTemperature(WetBulbTemperatureEntity WetBulbTemperature) {
        this.WetBulbTemperature = WetBulbTemperature;
    }

    public void setVisibility(VisibilityEntity Visibility) {
        this.Visibility = Visibility;
    }

    public void setWindChillTemperature(WindChillTemperatureEntity WindChillTemperature) {
        this.WindChillTemperature = WindChillTemperature;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public void setMobileLink(String MobileLink) {
        this.MobileLink = MobileLink;
    }

    public WindEntity getWind() {
        return Wind;
    }

    public TemperatureEntity getTemperature() {
        return Temperature;
    }

    public Past24HourTemperatureDepartureEntity getPast24HourTemperatureDeparture() {
        return Past24HourTemperatureDeparture;
    }

    public PressureTendencyEntity getPressureTendency() {
        return PressureTendency;
    }

    public String getObstructionsToVisibility() {
        return ObstructionsToVisibility;
    }

    public CeilingEntity getCeiling() {
        return Ceiling;
    }

    public RealFeelTemperatureShadeEntity getRealFeelTemperatureShade() {
        return RealFeelTemperatureShade;
    }

    public int getEpochTime() {
        return EpochTime;
    }

    public RealFeelTemperatureEntity getRealFeelTemperature() {
        return RealFeelTemperature;
    }

    public int getRelativeHumidity() {
        return RelativeHumidity;
    }

    public PrecipitationSummaryEntity getPrecipitationSummary() {
        return PrecipitationSummary;
    }

    public TemperatureSummaryEntity getTemperatureSummary() {
        return TemperatureSummary;
    }

    public String getLocalObservationDateTime() {
        return LocalObservationDateTime;
    }

    public String getUVIndexText() {
        return UVIndexText;
    }

    public String getWeatherText() {
        return WeatherText;
    }

    public int getCloudCover() {
        return CloudCover;
    }

    public LocalSourceEntity getLocalSource() {
        return LocalSource;
    }

    public WindGustEntity getWindGust() {
        return WindGust;
    }

    public int getUVIndex() {
        return UVIndex;
    }

    public Precip1hrEntity getPrecip1hr() {
        return Precip1hr;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public DewPointEntity getDewPoint() {
        return DewPoint;
    }

    public PressureEntity getPressure() {
        return Pressure;
    }

    public boolean isIsDayTime() {
        return IsDayTime;
    }

    public ApparentTemperatureEntity getApparentTemperature() {
        return ApparentTemperature;
    }

    public WetBulbTemperatureEntity getWetBulbTemperature() {
        return WetBulbTemperature;
    }

    public VisibilityEntity getVisibility() {
        return Visibility;
    }

    public WindChillTemperatureEntity getWindChillTemperature() {
        return WindChillTemperature;
    }

    public String getLink() {
        return Link;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public class WindEntity {
        /**
         * Speed : {"Metric":{"UnitType":7,"Value":18.5,"Unit":"km/h"},"Imperial":{"UnitType":9,"Value":11.5,"Unit":"mi/h"}}
         * Direction : {"English":"NNW","Degrees":338,"Localized":"西北偏北"}
         */
        private SpeedEntity Speed;
        private DirectionEntity Direction;

        public void setSpeed(SpeedEntity Speed) {
            this.Speed = Speed;
        }

        public void setDirection(DirectionEntity Direction) {
            this.Direction = Direction;
        }

        public SpeedEntity getSpeed() {
            return Speed;
        }

        public DirectionEntity getDirection() {
            return Direction;
        }

        public class SpeedEntity {
            /**
             * Metric : {"UnitType":7,"Value":18.5,"Unit":"km/h"}
             * Imperial : {"UnitType":9,"Value":11.5,"Unit":"mi/h"}
             */
            private MetricEntity Metric;
            private ImperialEntity Imperial;

            public void setMetric(MetricEntity Metric) {
                this.Metric = Metric;
            }

            public void setImperial(ImperialEntity Imperial) {
                this.Imperial = Imperial;
            }

            public MetricEntity getMetric() {
                return Metric;
            }

            public ImperialEntity getImperial() {
                return Imperial;
            }

            public class MetricEntity {
                /**
                 * UnitType : 7
                 * Value : 18.5
                 * Unit : km/h
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }

            public class ImperialEntity {
                /**
                 * UnitType : 9
                 * Value : 11.5
                 * Unit : mi/h
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }
        }

        public class DirectionEntity {
            /**
             * English : NNW
             * Degrees : 338
             * Localized : 西北偏北
             */
            private String English;
            private int Degrees;
            private String Localized;

            public void setEnglish(String English) {
                this.English = English;
            }

            public void setDegrees(int Degrees) {
                this.Degrees = Degrees;
            }

            public void setLocalized(String Localized) {
                this.Localized = Localized;
            }

            public String getEnglish() {
                return English;
            }

            public int getDegrees() {
                return Degrees;
            }

            public String getLocalized() {
                return Localized;
            }
        }
    }

    public class TemperatureEntity {
        /**
         * Metric : {"UnitType":17,"Value":10.7,"Unit":"C"}
         * Imperial : {"UnitType":18,"Value":51,"Unit":"F"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 17
             * Value : 10.7
             * Unit : C
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 18
             * Value : 51.0
             * Unit : F
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class Past24HourTemperatureDepartureEntity {
        /**
         * Metric : {"UnitType":17,"Value":-8.4,"Unit":"C"}
         * Imperial : {"UnitType":18,"Value":-15,"Unit":"F"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 17
             * Value : -8.4
             * Unit : C
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 18
             * Value : -15.0
             * Unit : F
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class PressureTendencyEntity {
        /**
         * Code : F
         * LocalizedText : 下降
         */
        private String Code;
        private String LocalizedText;

        public void setCode(String Code) {
            this.Code = Code;
        }

        public void setLocalizedText(String LocalizedText) {
            this.LocalizedText = LocalizedText;
        }

        public String getCode() {
            return Code;
        }

        public String getLocalizedText() {
            return LocalizedText;
        }
    }

    public class CeilingEntity {
        /**
         * Metric : {"UnitType":5,"Value":3048,"Unit":"m"}
         * Imperial : {"UnitType":0,"Value":10000,"Unit":"ft"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 5
             * Value : 3048.0
             * Unit : m
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 0
             * Value : 10000.0
             * Unit : ft
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class RealFeelTemperatureShadeEntity {
        /**
         * Metric : {"UnitType":17,"Value":5.5,"Unit":"C"}
         * Imperial : {"UnitType":18,"Value":42,"Unit":"F"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 17
             * Value : 5.5
             * Unit : C
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 18
             * Value : 42.0
             * Unit : F
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class RealFeelTemperatureEntity {
        /**
         * Metric : {"UnitType":17,"Value":5.5,"Unit":"C"}
         * Imperial : {"UnitType":18,"Value":42,"Unit":"F"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 17
             * Value : 5.5
             * Unit : C
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 18
             * Value : 42.0
             * Unit : F
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class PrecipitationSummaryEntity {
        /**
         * Past6Hours : {"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.02,"Unit":"in"}}
         * Precipitation : {"Metric":{"UnitType":3,"Value":0,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0,"Unit":"in"}}
         * Past9Hours : {"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.04,"Unit":"in"}}
         * Past3Hours : {"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.02,"Unit":"in"}}
         * PastHour : {"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.02,"Unit":"in"}}
         * Past18Hours : {"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.05,"Unit":"in"}}
         * Past24Hours : {"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.05,"Unit":"in"}}
         * Past12Hours : {"Metric":{"UnitType":3,"Value":1,"Unit":"mm"},"Imperial":{"UnitType":1,"Value":0.04,"Unit":"in"}}
         */
        private Past6HoursEntity Past6Hours;
        private PrecipitationEntity Precipitation;
        private Past9HoursEntity Past9Hours;
        private Past3HoursEntity Past3Hours;
        private PastHourEntity PastHour;
        private Past18HoursEntity Past18Hours;
        private Past24HoursEntity Past24Hours;
        private Past12HoursEntity Past12Hours;

        public void setPast6Hours(Past6HoursEntity Past6Hours) {
            this.Past6Hours = Past6Hours;
        }

        public void setPrecipitation(PrecipitationEntity Precipitation) {
            this.Precipitation = Precipitation;
        }

        public void setPast9Hours(Past9HoursEntity Past9Hours) {
            this.Past9Hours = Past9Hours;
        }

        public void setPast3Hours(Past3HoursEntity Past3Hours) {
            this.Past3Hours = Past3Hours;
        }

        public void setPastHour(PastHourEntity PastHour) {
            this.PastHour = PastHour;
        }

        public void setPast18Hours(Past18HoursEntity Past18Hours) {
            this.Past18Hours = Past18Hours;
        }

        public void setPast24Hours(Past24HoursEntity Past24Hours) {
            this.Past24Hours = Past24Hours;
        }

        public void setPast12Hours(Past12HoursEntity Past12Hours) {
            this.Past12Hours = Past12Hours;
        }

        public Past6HoursEntity getPast6Hours() {
            return Past6Hours;
        }

        public PrecipitationEntity getPrecipitation() {
            return Precipitation;
        }

        public Past9HoursEntity getPast9Hours() {
            return Past9Hours;
        }

        public Past3HoursEntity getPast3Hours() {
            return Past3Hours;
        }

        public PastHourEntity getPastHour() {
            return PastHour;
        }

        public Past18HoursEntity getPast18Hours() {
            return Past18Hours;
        }

        public Past24HoursEntity getPast24Hours() {
            return Past24Hours;
        }

        public Past12HoursEntity getPast12Hours() {
            return Past12Hours;
        }

        public class Past6HoursEntity {
            /**
             * Metric : {"UnitType":3,"Value":1,"Unit":"mm"}
             * Imperial : {"UnitType":1,"Value":0.02,"Unit":"in"}
             */
            private MetricEntity Metric;
            private ImperialEntity Imperial;

            public void setMetric(MetricEntity Metric) {
                this.Metric = Metric;
            }

            public void setImperial(ImperialEntity Imperial) {
                this.Imperial = Imperial;
            }

            public MetricEntity getMetric() {
                return Metric;
            }

            public ImperialEntity getImperial() {
                return Imperial;
            }

            public class MetricEntity {
                /**
                 * UnitType : 3
                 * Value : 1.0
                 * Unit : mm
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }

            public class ImperialEntity {
                /**
                 * UnitType : 1
                 * Value : 0.02
                 * Unit : in
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }
        }

        public class PrecipitationEntity {
            /**
             * Metric : {"UnitType":3,"Value":0,"Unit":"mm"}
             * Imperial : {"UnitType":1,"Value":0,"Unit":"in"}
             */
            private MetricEntity Metric;
            private ImperialEntity Imperial;

            public void setMetric(MetricEntity Metric) {
                this.Metric = Metric;
            }

            public void setImperial(ImperialEntity Imperial) {
                this.Imperial = Imperial;
            }

            public MetricEntity getMetric() {
                return Metric;
            }

            public ImperialEntity getImperial() {
                return Imperial;
            }

            public class MetricEntity {
                /**
                 * UnitType : 3
                 * Value : 0.0
                 * Unit : mm
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }

            public class ImperialEntity {
                /**
                 * UnitType : 1
                 * Value : 0.0
                 * Unit : in
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }
        }

        public class Past9HoursEntity {
            /**
             * Metric : {"UnitType":3,"Value":1,"Unit":"mm"}
             * Imperial : {"UnitType":1,"Value":0.04,"Unit":"in"}
             */
            private MetricEntity Metric;
            private ImperialEntity Imperial;

            public void setMetric(MetricEntity Metric) {
                this.Metric = Metric;
            }

            public void setImperial(ImperialEntity Imperial) {
                this.Imperial = Imperial;
            }

            public MetricEntity getMetric() {
                return Metric;
            }

            public ImperialEntity getImperial() {
                return Imperial;
            }

            public class MetricEntity {
                /**
                 * UnitType : 3
                 * Value : 1.0
                 * Unit : mm
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }

            public class ImperialEntity {
                /**
                 * UnitType : 1
                 * Value : 0.04
                 * Unit : in
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }
        }

        public class Past3HoursEntity {
            /**
             * Metric : {"UnitType":3,"Value":1,"Unit":"mm"}
             * Imperial : {"UnitType":1,"Value":0.02,"Unit":"in"}
             */
            private MetricEntity Metric;
            private ImperialEntity Imperial;

            public void setMetric(MetricEntity Metric) {
                this.Metric = Metric;
            }

            public void setImperial(ImperialEntity Imperial) {
                this.Imperial = Imperial;
            }

            public MetricEntity getMetric() {
                return Metric;
            }

            public ImperialEntity getImperial() {
                return Imperial;
            }

            public class MetricEntity {
                /**
                 * UnitType : 3
                 * Value : 1.0
                 * Unit : mm
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }

            public class ImperialEntity {
                /**
                 * UnitType : 1
                 * Value : 0.02
                 * Unit : in
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }
        }

        public class PastHourEntity {
            /**
             * Metric : {"UnitType":3,"Value":1,"Unit":"mm"}
             * Imperial : {"UnitType":1,"Value":0.02,"Unit":"in"}
             */
            private MetricEntity Metric;
            private ImperialEntity Imperial;

            public void setMetric(MetricEntity Metric) {
                this.Metric = Metric;
            }

            public void setImperial(ImperialEntity Imperial) {
                this.Imperial = Imperial;
            }

            public MetricEntity getMetric() {
                return Metric;
            }

            public ImperialEntity getImperial() {
                return Imperial;
            }

            public class MetricEntity {
                /**
                 * UnitType : 3
                 * Value : 1.0
                 * Unit : mm
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }

            public class ImperialEntity {
                /**
                 * UnitType : 1
                 * Value : 0.02
                 * Unit : in
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }
        }

        public class Past18HoursEntity {
            /**
             * Metric : {"UnitType":3,"Value":1,"Unit":"mm"}
             * Imperial : {"UnitType":1,"Value":0.05,"Unit":"in"}
             */
            private MetricEntity Metric;
            private ImperialEntity Imperial;

            public void setMetric(MetricEntity Metric) {
                this.Metric = Metric;
            }

            public void setImperial(ImperialEntity Imperial) {
                this.Imperial = Imperial;
            }

            public MetricEntity getMetric() {
                return Metric;
            }

            public ImperialEntity getImperial() {
                return Imperial;
            }

            public class MetricEntity {
                /**
                 * UnitType : 3
                 * Value : 1.0
                 * Unit : mm
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }

            public class ImperialEntity {
                /**
                 * UnitType : 1
                 * Value : 0.05
                 * Unit : in
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }
        }

        public class Past24HoursEntity {
            /**
             * Metric : {"UnitType":3,"Value":1,"Unit":"mm"}
             * Imperial : {"UnitType":1,"Value":0.05,"Unit":"in"}
             */
            private MetricEntity Metric;
            private ImperialEntity Imperial;

            public void setMetric(MetricEntity Metric) {
                this.Metric = Metric;
            }

            public void setImperial(ImperialEntity Imperial) {
                this.Imperial = Imperial;
            }

            public MetricEntity getMetric() {
                return Metric;
            }

            public ImperialEntity getImperial() {
                return Imperial;
            }

            public class MetricEntity {
                /**
                 * UnitType : 3
                 * Value : 1.0
                 * Unit : mm
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }

            public class ImperialEntity {
                /**
                 * UnitType : 1
                 * Value : 0.05
                 * Unit : in
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }
        }

        public class Past12HoursEntity {
            /**
             * Metric : {"UnitType":3,"Value":1,"Unit":"mm"}
             * Imperial : {"UnitType":1,"Value":0.04,"Unit":"in"}
             */
            private MetricEntity Metric;
            private ImperialEntity Imperial;

            public void setMetric(MetricEntity Metric) {
                this.Metric = Metric;
            }

            public void setImperial(ImperialEntity Imperial) {
                this.Imperial = Imperial;
            }

            public MetricEntity getMetric() {
                return Metric;
            }

            public ImperialEntity getImperial() {
                return Imperial;
            }

            public class MetricEntity {
                /**
                 * UnitType : 3
                 * Value : 1.0
                 * Unit : mm
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }

            public class ImperialEntity {
                /**
                 * UnitType : 1
                 * Value : 0.04
                 * Unit : in
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }
        }
    }

    public class TemperatureSummaryEntity {
        /**
         * Past6HourRange : {"Minimum":{"Metric":{"UnitType":17,"Value":10.7,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}},"Maximum":{"Metric":{"UnitType":17,"Value":15.6,"Unit":"C"},"Imperial":{"UnitType":18,"Value":60,"Unit":"F"}}}
         * Past24HourRange : {"Minimum":{"Metric":{"UnitType":17,"Value":10.7,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}},"Maximum":{"Metric":{"UnitType":17,"Value":23.4,"Unit":"C"},"Imperial":{"UnitType":18,"Value":74,"Unit":"F"}}}
         * Past12HourRange : {"Minimum":{"Metric":{"UnitType":17,"Value":10.7,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}},"Maximum":{"Metric":{"UnitType":17,"Value":19.6,"Unit":"C"},"Imperial":{"UnitType":18,"Value":67,"Unit":"F"}}}
         */
        private Past6HourRangeEntity Past6HourRange;
        private Past24HourRangeEntity Past24HourRange;
        private Past12HourRangeEntity Past12HourRange;

        public void setPast6HourRange(Past6HourRangeEntity Past6HourRange) {
            this.Past6HourRange = Past6HourRange;
        }

        public void setPast24HourRange(Past24HourRangeEntity Past24HourRange) {
            this.Past24HourRange = Past24HourRange;
        }

        public void setPast12HourRange(Past12HourRangeEntity Past12HourRange) {
            this.Past12HourRange = Past12HourRange;
        }

        public Past6HourRangeEntity getPast6HourRange() {
            return Past6HourRange;
        }

        public Past24HourRangeEntity getPast24HourRange() {
            return Past24HourRange;
        }

        public Past12HourRangeEntity getPast12HourRange() {
            return Past12HourRange;
        }

        public class Past6HourRangeEntity {
            /**
             * Minimum : {"Metric":{"UnitType":17,"Value":10.7,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}}
             * Maximum : {"Metric":{"UnitType":17,"Value":15.6,"Unit":"C"},"Imperial":{"UnitType":18,"Value":60,"Unit":"F"}}
             */
            private MinimumEntity Minimum;
            private MaximumEntity Maximum;

            public void setMinimum(MinimumEntity Minimum) {
                this.Minimum = Minimum;
            }

            public void setMaximum(MaximumEntity Maximum) {
                this.Maximum = Maximum;
            }

            public MinimumEntity getMinimum() {
                return Minimum;
            }

            public MaximumEntity getMaximum() {
                return Maximum;
            }

            public class MinimumEntity {
                /**
                 * Metric : {"UnitType":17,"Value":10.7,"Unit":"C"}
                 * Imperial : {"UnitType":18,"Value":51,"Unit":"F"}
                 */
                private MetricEntity Metric;
                private ImperialEntity Imperial;

                public void setMetric(MetricEntity Metric) {
                    this.Metric = Metric;
                }

                public void setImperial(ImperialEntity Imperial) {
                    this.Imperial = Imperial;
                }

                public MetricEntity getMetric() {
                    return Metric;
                }

                public ImperialEntity getImperial() {
                    return Imperial;
                }

                public class MetricEntity {
                    /**
                     * UnitType : 17
                     * Value : 10.7
                     * Unit : C
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }

                public class ImperialEntity {
                    /**
                     * UnitType : 18
                     * Value : 51.0
                     * Unit : F
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }
            }

            public class MaximumEntity {
                /**
                 * Metric : {"UnitType":17,"Value":15.6,"Unit":"C"}
                 * Imperial : {"UnitType":18,"Value":60,"Unit":"F"}
                 */
                private MetricEntity Metric;
                private ImperialEntity Imperial;

                public void setMetric(MetricEntity Metric) {
                    this.Metric = Metric;
                }

                public void setImperial(ImperialEntity Imperial) {
                    this.Imperial = Imperial;
                }

                public MetricEntity getMetric() {
                    return Metric;
                }

                public ImperialEntity getImperial() {
                    return Imperial;
                }

                public class MetricEntity {
                    /**
                     * UnitType : 17
                     * Value : 15.6
                     * Unit : C
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }

                public class ImperialEntity {
                    /**
                     * UnitType : 18
                     * Value : 60.0
                     * Unit : F
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }
            }
        }

        public class Past24HourRangeEntity {
            /**
             * Minimum : {"Metric":{"UnitType":17,"Value":10.7,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}}
             * Maximum : {"Metric":{"UnitType":17,"Value":23.4,"Unit":"C"},"Imperial":{"UnitType":18,"Value":74,"Unit":"F"}}
             */
            private MinimumEntity Minimum;
            private MaximumEntity Maximum;

            public void setMinimum(MinimumEntity Minimum) {
                this.Minimum = Minimum;
            }

            public void setMaximum(MaximumEntity Maximum) {
                this.Maximum = Maximum;
            }

            public MinimumEntity getMinimum() {
                return Minimum;
            }

            public MaximumEntity getMaximum() {
                return Maximum;
            }

            public class MinimumEntity {
                /**
                 * Metric : {"UnitType":17,"Value":10.7,"Unit":"C"}
                 * Imperial : {"UnitType":18,"Value":51,"Unit":"F"}
                 */
                private MetricEntity Metric;
                private ImperialEntity Imperial;

                public void setMetric(MetricEntity Metric) {
                    this.Metric = Metric;
                }

                public void setImperial(ImperialEntity Imperial) {
                    this.Imperial = Imperial;
                }

                public MetricEntity getMetric() {
                    return Metric;
                }

                public ImperialEntity getImperial() {
                    return Imperial;
                }

                public class MetricEntity {
                    /**
                     * UnitType : 17
                     * Value : 10.7
                     * Unit : C
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }

                public class ImperialEntity {
                    /**
                     * UnitType : 18
                     * Value : 51.0
                     * Unit : F
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }
            }

            public class MaximumEntity {
                /**
                 * Metric : {"UnitType":17,"Value":23.4,"Unit":"C"}
                 * Imperial : {"UnitType":18,"Value":74,"Unit":"F"}
                 */
                private MetricEntity Metric;
                private ImperialEntity Imperial;

                public void setMetric(MetricEntity Metric) {
                    this.Metric = Metric;
                }

                public void setImperial(ImperialEntity Imperial) {
                    this.Imperial = Imperial;
                }

                public MetricEntity getMetric() {
                    return Metric;
                }

                public ImperialEntity getImperial() {
                    return Imperial;
                }

                public class MetricEntity {
                    /**
                     * UnitType : 17
                     * Value : 23.4
                     * Unit : C
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }

                public class ImperialEntity {
                    /**
                     * UnitType : 18
                     * Value : 74.0
                     * Unit : F
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }
            }
        }

        public class Past12HourRangeEntity {
            /**
             * Minimum : {"Metric":{"UnitType":17,"Value":10.7,"Unit":"C"},"Imperial":{"UnitType":18,"Value":51,"Unit":"F"}}
             * Maximum : {"Metric":{"UnitType":17,"Value":19.6,"Unit":"C"},"Imperial":{"UnitType":18,"Value":67,"Unit":"F"}}
             */
            private MinimumEntity Minimum;
            private MaximumEntity Maximum;

            public void setMinimum(MinimumEntity Minimum) {
                this.Minimum = Minimum;
            }

            public void setMaximum(MaximumEntity Maximum) {
                this.Maximum = Maximum;
            }

            public MinimumEntity getMinimum() {
                return Minimum;
            }

            public MaximumEntity getMaximum() {
                return Maximum;
            }

            public class MinimumEntity {
                /**
                 * Metric : {"UnitType":17,"Value":10.7,"Unit":"C"}
                 * Imperial : {"UnitType":18,"Value":51,"Unit":"F"}
                 */
                private MetricEntity Metric;
                private ImperialEntity Imperial;

                public void setMetric(MetricEntity Metric) {
                    this.Metric = Metric;
                }

                public void setImperial(ImperialEntity Imperial) {
                    this.Imperial = Imperial;
                }

                public MetricEntity getMetric() {
                    return Metric;
                }

                public ImperialEntity getImperial() {
                    return Imperial;
                }

                public class MetricEntity {
                    /**
                     * UnitType : 17
                     * Value : 10.7
                     * Unit : C
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }

                public class ImperialEntity {
                    /**
                     * UnitType : 18
                     * Value : 51.0
                     * Unit : F
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }
            }

            public class MaximumEntity {
                /**
                 * Metric : {"UnitType":17,"Value":19.6,"Unit":"C"}
                 * Imperial : {"UnitType":18,"Value":67,"Unit":"F"}
                 */
                private MetricEntity Metric;
                private ImperialEntity Imperial;

                public void setMetric(MetricEntity Metric) {
                    this.Metric = Metric;
                }

                public void setImperial(ImperialEntity Imperial) {
                    this.Imperial = Imperial;
                }

                public MetricEntity getMetric() {
                    return Metric;
                }

                public ImperialEntity getImperial() {
                    return Imperial;
                }

                public class MetricEntity {
                    /**
                     * UnitType : 17
                     * Value : 19.6
                     * Unit : C
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }

                public class ImperialEntity {
                    /**
                     * UnitType : 18
                     * Value : 67.0
                     * Unit : F
                     */
                    private int UnitType;
                    private double Value;
                    private String Unit;

                    public void setUnitType(int UnitType) {
                        this.UnitType = UnitType;
                    }

                    public void setValue(double Value) {
                        this.Value = Value;
                    }

                    public void setUnit(String Unit) {
                        this.Unit = Unit;
                    }

                    public int getUnitType() {
                        return UnitType;
                    }

                    public double getValue() {
                        return Value;
                    }

                    public String getUnit() {
                        return Unit;
                    }
                }
            }
        }
    }

    public class LocalSourceEntity {
        /**
         * WeatherCode : 03
         * Id : 7
         * Name : Huafeng
         */
        private String WeatherCode;
        private int Id;
        private String Name;

        public void setWeatherCode(String WeatherCode) {
            this.WeatherCode = WeatherCode;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getWeatherCode() {
            return WeatherCode;
        }

        public int getId() {
            return Id;
        }

        public String getName() {
            return Name;
        }
    }

    public class WindGustEntity {
        /**
         * Speed : {"Metric":{"UnitType":7,"Value":24.8,"Unit":"km/h"},"Imperial":{"UnitType":9,"Value":15.4,"Unit":"mi/h"}}
         */
        private SpeedEntity Speed;

        public void setSpeed(SpeedEntity Speed) {
            this.Speed = Speed;
        }

        public SpeedEntity getSpeed() {
            return Speed;
        }

        public class SpeedEntity {
            /**
             * Metric : {"UnitType":7,"Value":24.8,"Unit":"km/h"}
             * Imperial : {"UnitType":9,"Value":15.4,"Unit":"mi/h"}
             */
            private MetricEntity Metric;
            private ImperialEntity Imperial;

            public void setMetric(MetricEntity Metric) {
                this.Metric = Metric;
            }

            public void setImperial(ImperialEntity Imperial) {
                this.Imperial = Imperial;
            }

            public MetricEntity getMetric() {
                return Metric;
            }

            public ImperialEntity getImperial() {
                return Imperial;
            }

            public class MetricEntity {
                /**
                 * UnitType : 7
                 * Value : 24.8
                 * Unit : km/h
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }

            public class ImperialEntity {
                /**
                 * UnitType : 9
                 * Value : 15.4
                 * Unit : mi/h
                 */
                private int UnitType;
                private double Value;
                private String Unit;

                public void setUnitType(int UnitType) {
                    this.UnitType = UnitType;
                }

                public void setValue(double Value) {
                    this.Value = Value;
                }

                public void setUnit(String Unit) {
                    this.Unit = Unit;
                }

                public int getUnitType() {
                    return UnitType;
                }

                public double getValue() {
                    return Value;
                }

                public String getUnit() {
                    return Unit;
                }
            }
        }
    }

    public class Precip1hrEntity {
        /**
         * Metric : {"UnitType":3,"Value":1,"Unit":"mm"}
         * Imperial : {"UnitType":1,"Value":0.02,"Unit":"in"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 3
             * Value : 1.0
             * Unit : mm
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 1
             * Value : 0.02
             * Unit : in
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class DewPointEntity {
        /**
         * Metric : {"UnitType":17,"Value":3.3,"Unit":"C"}
         * Imperial : {"UnitType":18,"Value":38,"Unit":"F"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 17
             * Value : 3.3
             * Unit : C
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 18
             * Value : 38.0
             * Unit : F
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class PressureEntity {
        /**
         * Metric : {"UnitType":14,"Value":1014.4,"Unit":"mb"}
         * Imperial : {"UnitType":12,"Value":29.96,"Unit":"inHg"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 14
             * Value : 1014.4
             * Unit : mb
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 12
             * Value : 29.96
             * Unit : inHg
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class ApparentTemperatureEntity {
        /**
         * Metric : {"UnitType":17,"Value":12.2,"Unit":"C"}
         * Imperial : {"UnitType":18,"Value":54,"Unit":"F"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 17
             * Value : 12.2
             * Unit : C
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 18
             * Value : 54.0
             * Unit : F
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class WetBulbTemperatureEntity {
        /**
         * Metric : {"UnitType":17,"Value":7.1,"Unit":"C"}
         * Imperial : {"UnitType":18,"Value":45,"Unit":"F"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 17
             * Value : 7.1
             * Unit : C
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 18
             * Value : 45.0
             * Unit : F
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class VisibilityEntity {
        /**
         * Metric : {"UnitType":6,"Value":9.7,"Unit":"km"}
         * Imperial : {"UnitType":2,"Value":6,"Unit":"mi"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 6
             * Value : 9.7
             * Unit : km
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 2
             * Value : 6.0
             * Unit : mi
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }

    public class WindChillTemperatureEntity {
        /**
         * Metric : {"UnitType":17,"Value":10.6,"Unit":"C"}
         * Imperial : {"UnitType":18,"Value":51,"Unit":"F"}
         */
        private MetricEntity Metric;
        private ImperialEntity Imperial;

        public void setMetric(MetricEntity Metric) {
            this.Metric = Metric;
        }

        public void setImperial(ImperialEntity Imperial) {
            this.Imperial = Imperial;
        }

        public MetricEntity getMetric() {
            return Metric;
        }

        public ImperialEntity getImperial() {
            return Imperial;
        }

        public class MetricEntity {
            /**
             * UnitType : 17
             * Value : 10.6
             * Unit : C
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }

        public class ImperialEntity {
            /**
             * UnitType : 18
             * Value : 51.0
             * Unit : F
             */
            private int UnitType;
            private double Value;
            private String Unit;

            public void setUnitType(int UnitType) {
                this.UnitType = UnitType;
            }

            public void setValue(double Value) {
                this.Value = Value;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getUnitType() {
                return UnitType;
            }

            public double getValue() {
                return Value;
            }

            public String getUnit() {
                return Unit;
            }
        }
    }
}
