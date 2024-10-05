package com.harsha.vizagitiee;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherData> weatherDataList;

    public WeatherAdapter(List<WeatherData> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherData weatherData = weatherDataList.get(position);
        holder.locationTextView.setText(weatherData.getLocationName());

        // Check if forecastList is null before accessing it
        if (weatherData.getForecastList() != null) {
            int forecastCount = weatherData.getForecastList().size();
            boolean isExpanded = weatherData.isExpanded();
            int itemCountToShow = isExpanded ? forecastCount : Math.min(forecastCount, 3);

            holder.forecastLayout.removeAllViews(); // Clear any previous views

            for (int i = 0; i < itemCountToShow; i++) {
                ForecastItem item = weatherData.getForecastList().get(i);
                View forecastView = LayoutInflater.from(holder.itemView.getContext()).inflate(R.layout.forecast_layout, holder.forecastLayout, false);
                ImageView forecastIcon = forecastView.findViewById(R.id.forecastIcon);
                TextView forecastDetails = forecastView.findViewById(R.id.forecast);

                // Set forecast details
                forecastDetails.setText(String.format("%s: %.1f°C, %s", item.getTime(), item.getTemperature(), item.getDescription()));
                // Set forecast icon based on the forecast description or type
                setForecastIcon(forecastIcon, item.getDescription());

                holder.forecastLayout.addView(forecastView);
            }

            // Show "Show More" or "Show Less" button
            TextView toggleButton = new TextView(holder.itemView.getContext());
            toggleButton.setText(isExpanded ? "Show Less" : "Show More");
            toggleButton.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.black));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            layoutParams.gravity = Gravity.END;
            toggleButton.setLayoutParams(layoutParams);
            toggleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    weatherData.setExpanded(!isExpanded);
                    notifyItemChanged(holder.getAdapterPosition()); // Update only the clicked item
                }
            });
            holder.forecastLayout.addView(toggleButton);

        } else {
            // Handle case where forecastList is null or empty
            holder.forecastLayout.removeAllViews(); // Clear any previous views
        }

        // Set weather details without air speed and cloud percentage
        holder.weatherDetailsTextView.setText(String.format(
                "%s\nTemp: %.1f°C, Humidity: %d%%",
                weatherData.getDescription(),
                weatherData.getTemperature(),
                weatherData.getHumidity()
        ));

        // Set weather image based on the weather description or type
        setWeatherIcon(holder.weatherImageView, weatherData.getDescription());
    }

    @Override
    public int getItemCount() {
        return weatherDataList.size();
    }

    static class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView locationTextView;
        TextView weatherDetailsTextView;
        ImageView weatherImageView;
        LinearLayout forecastLayout;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            locationTextView = itemView.findViewById(R.id.locationName);
            weatherDetailsTextView = itemView.findViewById(R.id.weatherDetails);
            weatherImageView = itemView.findViewById(R.id.weatherImageView);
            forecastLayout = itemView.findViewById(R.id.forecastLayout); // Ensure this ID matches
        }
    }

    private void setWeatherIcon(ImageView imageView, String description) {
        switch (description.toLowerCase()) {
            case "mist":
                imageView.setImageResource(R.drawable.clear_icon);
                break;
            case "overcast clouds":
                imageView.setImageResource(R.drawable.cloudy_icon);
                break;
            case "light rain":
                imageView.setImageResource(R.drawable.light);
                break;
            case "heavy intensity rain":
                imageView.setImageResource(R.drawable.icon_storm);
                break;
            case "very heavy rain":
                imageView.setImageResource(R.drawable.icon_storm);
                break;
            case "moderate rain":
                imageView.setImageResource(R.drawable.moderaterain);
                break;
            // Add other cases as needed
            default:
                imageView.setImageResource(R.drawable.icon_storm);
                break;
        }
    }

    private void setForecastIcon(ImageView imageView, String description) {
        switch (description.toLowerCase()) {
            case "clear":
                imageView.setImageResource(R.drawable.clear_icon);
                break;
            case "overcast clouds":
                imageView.setImageResource(R.drawable.cloudy_icon);
                break;
            case "light rain":
                imageView.setImageResource(R.drawable.light);
                break;
            case "moderate rain":
                imageView.setImageResource(R.drawable.moderaterain);
                break;
            case "heavy intensity rain":
                imageView.setImageResource(R.drawable.icon_storm);
                break;
            case "very heavy rain":
                imageView.setImageResource(R.drawable.icon_storm);
                break;
            // Add other cases as needed
            default:
                imageView.setImageResource(R.drawable.icon_storm);
                break;
        }
    }
}
