package com.hacaller.lighthousejourney;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Herbert Caller on 11/09/2018.
 */

public class IPStackLocation {

    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("continent_code")
    @Expose
    private String continentCode;
    @SerializedName("continent_name")
    @Expose
    private String continentName;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("country_name")
    @Expose
    private String countryName;
    @SerializedName("region_code")
    @Expose
    private String regionCode;
    @SerializedName("region_name")
    @Expose
    private String regionName;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("time_zone")
    @Expose
    private TimeZone timeZone;
    @SerializedName("currency")
    @Expose
    private Currency currency;
    @SerializedName("connection")
    @Expose
    private Connection connection;
    @SerializedName("security")
    @Expose
    private Security security;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public class Connection {

        @SerializedName("asn")
        @Expose
        private Integer asn;
        @SerializedName("isp")
        @Expose
        private String isp;

        public Integer getAsn() {
            return asn;
        }

        public void setAsn(Integer asn) {
            this.asn = asn;
        }

        public String getIsp() {
            return isp;
        }

        public void setIsp(String isp) {
            this.isp = isp;
        }

    }

    public class Currency {

        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("plural")
        @Expose
        private String plural;
        @SerializedName("symbol")
        @Expose
        private String symbol;
        @SerializedName("symbol_native")
        @Expose
        private String symbolNative;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlural() {
            return plural;
        }

        public void setPlural(String plural) {
            this.plural = plural;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbolNative() {
            return symbolNative;
        }

        public void setSymbolNative(String symbolNative) {
            this.symbolNative = symbolNative;
        }

    }

    public class Language {

        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("native")
        @Expose
        private String _native;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNative() {
            return _native;
        }

        public void setNative(String _native) {
            this._native = _native;
        }

    }

    public class Location {

        @SerializedName("geoname_id")
        @Expose
        private Integer geonameId;
        @SerializedName("capital")
        @Expose
        private String capital;
        @SerializedName("languages")
        @Expose
        private List<Language> languages = null;
        @SerializedName("country_flag")
        @Expose
        private String countryFlag;
        @SerializedName("country_flag_emoji")
        @Expose
        private String countryFlagEmoji;
        @SerializedName("country_flag_emoji_unicode")
        @Expose
        private String countryFlagEmojiUnicode;
        @SerializedName("calling_code")
        @Expose
        private String callingCode;
        @SerializedName("is_eu")
        @Expose
        private Boolean isEu;

        public Integer getGeonameId() {
            return geonameId;
        }

        public void setGeonameId(Integer geonameId) {
            this.geonameId = geonameId;
        }

        public String getCapital() {
            return capital;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        public List<Language> getLanguages() {
            return languages;
        }

        public void setLanguages(List<Language> languages) {
            this.languages = languages;
        }

        public String getCountryFlag() {
            return countryFlag;
        }

        public void setCountryFlag(String countryFlag) {
            this.countryFlag = countryFlag;
        }

        public String getCountryFlagEmoji() {
            return countryFlagEmoji;
        }

        public void setCountryFlagEmoji(String countryFlagEmoji) {
            this.countryFlagEmoji = countryFlagEmoji;
        }

        public String getCountryFlagEmojiUnicode() {
            return countryFlagEmojiUnicode;
        }

        public void setCountryFlagEmojiUnicode(String countryFlagEmojiUnicode) {
            this.countryFlagEmojiUnicode = countryFlagEmojiUnicode;
        }

        public String getCallingCode() {
            return callingCode;
        }

        public void setCallingCode(String callingCode) {
            this.callingCode = callingCode;
        }

        public Boolean getIsEu() {
            return isEu;
        }

        public void setIsEu(Boolean isEu) {
            this.isEu = isEu;
        }

    }

    public class Security {

        @SerializedName("is_proxy")
        @Expose
        private Boolean isProxy;
        @SerializedName("proxy_type")
        @Expose
        private Object proxyType;
        @SerializedName("is_crawler")
        @Expose
        private Boolean isCrawler;
        @SerializedName("crawler_name")
        @Expose
        private Object crawlerName;
        @SerializedName("crawler_type")
        @Expose
        private Object crawlerType;
        @SerializedName("is_tor")
        @Expose
        private Boolean isTor;
        @SerializedName("threat_level")
        @Expose
        private String threatLevel;
        @SerializedName("threat_types")
        @Expose
        private Object threatTypes;

        public Boolean getIsProxy() {
            return isProxy;
        }

        public void setIsProxy(Boolean isProxy) {
            this.isProxy = isProxy;
        }

        public Object getProxyType() {
            return proxyType;
        }

        public void setProxyType(Object proxyType) {
            this.proxyType = proxyType;
        }

        public Boolean getIsCrawler() {
            return isCrawler;
        }

        public void setIsCrawler(Boolean isCrawler) {
            this.isCrawler = isCrawler;
        }

        public Object getCrawlerName() {
            return crawlerName;
        }

        public void setCrawlerName(Object crawlerName) {
            this.crawlerName = crawlerName;
        }

        public Object getCrawlerType() {
            return crawlerType;
        }

        public void setCrawlerType(Object crawlerType) {
            this.crawlerType = crawlerType;
        }

        public Boolean getIsTor() {
            return isTor;
        }

        public void setIsTor(Boolean isTor) {
            this.isTor = isTor;
        }

        public String getThreatLevel() {
            return threatLevel;
        }

        public void setThreatLevel(String threatLevel) {
            this.threatLevel = threatLevel;
        }

        public Object getThreatTypes() {
            return threatTypes;
        }

        public void setThreatTypes(Object threatTypes) {
            this.threatTypes = threatTypes;
        }

    }

    public class TimeZone {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("current_time")
        @Expose
        private String currentTime;
        @SerializedName("gmt_offset")
        @Expose
        private Integer gmtOffset;
        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("is_daylight_saving")
        @Expose
        private Boolean isDaylightSaving;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public Integer getGmtOffset() {
            return gmtOffset;
        }

        public void setGmtOffset(Integer gmtOffset) {
            this.gmtOffset = gmtOffset;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Boolean getIsDaylightSaving() {
            return isDaylightSaving;
        }

        public void setIsDaylightSaving(Boolean isDaylightSaving) {
            this.isDaylightSaving = isDaylightSaving;
        }

    }

}


