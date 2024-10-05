package com.harsha.vizagitiee;

public class Nature {
    private String name;
    private String location;
    private double latitude;
    private double longitude;
    private String imageUrl;
    private String info;

    public Nature(String info, String name, String location, double latitude, double longitude, String imageUrl) {
        this.name = name;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
        this.info = info;
    }

    // Getters and setters


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
