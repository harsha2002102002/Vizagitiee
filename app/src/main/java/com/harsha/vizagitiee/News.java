package com.harsha.vizagitiee;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class News extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WeatherAdapter weatherAdapter;
    private List<WeatherData> weatherDataList = new ArrayList<>();
    private final String API_KEY = "5b5e194692da1125fbe0882a5097027c"; // Replace with your actual OpenWeatherMap API key
    private final String UNITS = "metric";

    // Define the locations
    private final String[] LOCATIONS = {
            "Visakhapatnam",
            "Anakapalle, Visakhapatnam",
            "Gajuwaka, Visakhapatnam",
            "Waltair, Visakhapatnam",
            "Parawada, Visakhapatnam",
            "Sabbavaram,Visakhapatnam"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        weatherAdapter = new WeatherAdapter(weatherDataList);
        recyclerView.setAdapter(weatherAdapter);

        // Get current weather for all locations
        getCurrentWeatherForAllLocations();
    }

    private void getCurrentWeatherForAllLocations() {
        for (String location : LOCATIONS) {
            getCurrentWeather(location);
        }
    }

    private void getCurrentWeather(final String location) {
        WeatherService weatherService = ApiClient.getClient().create(WeatherService.class);
        Call<WeatherResponse> call = weatherService.getCurrentWeather(location, API_KEY, UNITS);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    WeatherResponse weatherResponse = response.body();
                    WeatherData weatherData = new WeatherData();
                    weatherData.setLocationName(location);
                    weatherData.setTemperature(weatherResponse.getMain().getTemp());
                    weatherData.setHumidity((int) weatherResponse.getMain().getHumidity()); // Cast to int
                    weatherData.setDescription(weatherResponse.getWeather().get(0).getDescription());

                    // Add current location weather data at the top
                    if (location.equals(LOCATIONS[0])) {
                        weatherDataList.add(0, weatherData);
                    } else {
                        weatherDataList.add(weatherData);
                    }

                    // Update RecyclerView
                    weatherAdapter.notifyDataSetChanged();

                    // Fetch weather forecast after fetching current weather
                    getWeatherForecast(location);
                } else {
                    Log.e("Weather", "Response code: " + response.code() + ", message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Toast.makeText(News.this, "Failed to get current weather for " + location, Toast.LENGTH_SHORT).show();
                Log.e("Weather", "onFailure: " + t.getMessage());
            }
        });
    }

    private void getWeatherForecast(final String location) {
        WeatherService weatherService = ApiClient.getClient().create(WeatherService.class);
        Call<ForecastResponse> call = weatherService.getWeatherForecast(location, API_KEY, UNITS);
        call.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ForecastResponse forecastResponse = response.body();
                    for (WeatherData weatherData : weatherDataList) {
                        if (weatherData.getLocationName().equals(location)) {
                            List<ForecastItem> forecastList = new ArrayList<>();
                            for (ForecastResponse.ListItem item : forecastResponse.getList()) {
                                ForecastItem forecastItem = new ForecastItem();
                                forecastItem.setTime(item.getDtTxt());
                                forecastItem.setTemperature(item.getMain().getTemp());
                                forecastItem.setDescription(item.getWeather().get(0).getDescription());
                                forecastList.add(forecastItem);
                            }
                            weatherData.setForecastList(forecastList);
                            weatherAdapter.notifyDataSetChanged();
                            break;
                        }
                    }
                } else {
                    Log.e("Forecast", "Response code: " + response.code() + ", message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                Toast.makeText(News.this, "Failed to get weather forecast for " + location, Toast.LENGTH_SHORT).show();
                Log.e("Forecast", "onFailure: " + t.getMessage());
            }
        });
    }
}
