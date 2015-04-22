package com.tek3.restaurant.adapters.models;

/**
 * Created by mgvaldes on 22/04/15.
 */
public class Advertising {
    private String advertisingName;
    private String advertisingImageURL;

    public Advertising() {
    }

    public Advertising(String advertisingName, String advertisingImageURL) {
        this.advertisingName = advertisingName;
        this.advertisingImageURL = advertisingImageURL;
    }

    public String getAdvertisingName() {
        return advertisingName;
    }

    public void setAdvertisingName(String advertisingName) {
        this.advertisingName = advertisingName;
    }

    public String getAdvertisingImageURL() {
        return advertisingImageURL;
    }

    public void setAdvertisingImageURL(String advertisingImageURL) {
        this.advertisingImageURL = advertisingImageURL;
    }
}
