package com.harsha.vizagitiee;

import java.util.List;

// WeatherResponse.java
public class WeatherResponse {
    // Define the fields based on the JSON response
    private Main main;
    private List<Weather> weather;

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public class Main {
        private float temp;
        private float humidity;

        public float getTemp() {
            return temp;
        }

        public float getHumidity() {
            return humidity;
        }
    }

    public class Weather {
        private String description;

        public String getDescription() {
            return description;
        }
    }
}

// ForecastResponse.java
