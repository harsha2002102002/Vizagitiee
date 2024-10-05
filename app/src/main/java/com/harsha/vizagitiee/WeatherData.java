package com.harsha.vizagitiee;

import java.util.List;

public class WeatherData {
    private String locationName;
    private float temperature;
    private int humidity;
    private boolean isExpanded;
    private String description;

    private float airSpeed; // Add airSpeed field
    private int visibility;
    private float cloudPercentage; // Add cloudPercentage field
    private List<ForecastItem> forecastList;

    // Constructor


    public void setForecastList(List<ForecastItem> forecastList) {
        this.forecastList = forecastList;
    }

    // Getters for fields
    public String getLocationName() {
        return locationName;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }

    public float getAirSpeed() {
        return airSpeed;
    }

    public int getVisibility() {
        return visibility;
    }

    public float getCloudPercentage() {
        return cloudPercentage;
    }

    public List<ForecastItem> getForecastList() {
        return forecastList;
    }
}
