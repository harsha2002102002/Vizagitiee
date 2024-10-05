package com.harsha.vizagitiee;

import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class BeachAdopter extends RecyclerView.Adapter<BeachAdopter.BeachViewHolder> {

    private List<Beaches> beachList;
    private Location userLocation;

    public BeachAdopter(List<Beaches> beachList, Location userLocation) {
        this.beachList = beachList;
        this.userLocation = userLocation;
    }

    @NonNull
    @Override
    public BeachViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_temples, parent, false);
        return new BeachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeachViewHolder holder, int position) {
        Beaches beach = beachList.get(position);
        holder.nameTextView.setText(beach.getName());
        holder.locationTextView.setText(beach.getLocation());
        holder.info.setText(beach.getInfo());
        Glide.with(holder.itemView.getContext()).load(beach.getImageUrl()).into(holder.imageView);

        if (userLocation != null) {
            Location beachLocation = new Location("");
            beachLocation.setLatitude(beach.getLatitude());
            beachLocation.setLongitude(beach.getLongitude());
            float distance = userLocation.distanceTo(beachLocation) / 1000; // distance in kilometers
            holder.distanceTextView.setText(String.format("%.2f km", distance));
        } else {
            holder.distanceTextView.setText("N/A");
        }
    }

    @Override
    public int getItemCount() {
        return beachList.size();
    }

    public static class BeachViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView locationTextView;
        TextView distanceTextView;
        ImageView imageView;
           TextView info;

        public BeachViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.temple_name);
            locationTextView = itemView.findViewById(R.id.temple_location);
            distanceTextView = itemView.findViewById(R.id.temple_distance);
            imageView = itemView.findViewById(R.id.temple_image);
            info = itemView.findViewById(R.id.temple_info);
        }
    }
}
