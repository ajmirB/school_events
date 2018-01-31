
package com.xception.schoolevents.core.models.events;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("streetAddress")
    @Expose
    private String streetAddress;

    @SerializedName("zipCode")
    @Expose
    private String zipCode;

    @SerializedName("cityName")
    @Expose
    private String cityName;

    @SerializedName("countryCode")
    @Expose
    private String countryCode;

    @SerializedName("countryName")
    @Expose
    private String countryName;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

}
