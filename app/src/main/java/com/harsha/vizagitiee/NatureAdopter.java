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

public class NatureAdopter extends RecyclerView.Adapter<NatureAdopter.NatureViewHolder> {

    private List<Nature> natureList;
    private Location userLocation;

    public NatureAdopter(List<Nature> natureList, Location userLocation) {
        this.natureList = natureList;
        this.userLocation = userLocation;
    }

    @NonNull
    @Override
    public NatureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_temples, parent, false);
        return new NatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NatureViewHolder holder, int position) {
        Nature natureSpot = natureList.get(position);
        holder.nameTextView.setText(natureSpot.getName());
        holder.locationTextView.setText(natureSpot.getLocation());
        holder.info.setText(natureSpot.getInfo());
        Glide.with(holder.itemView.getContext()).load(natureSpot.getImageUrl()).into(holder.imageView);

        if (userLocation != null) {
            Location natureLocation = new Location("");
            natureLocation.setLatitude(natureSpot.getLatitude());
            natureLocation.setLongitude(natureSpot.getLongitude());
            float distance = userLocation.distanceTo(natureLocation) / 1000; // distance in kilometers
            holder.distanceTextView.setText(String.format("%.2f km", distance));
        } else {
            holder.distanceTextView.setText("N/A");
        }
    }

    @Override
    public int getItemCount() {
        return natureList.size();
    }

    public static class NatureViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView locationTextView;
        TextView distanceTextView;
        ImageView imageView;
        TextView info;

        public NatureViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.temple_name);
            locationTextView = itemView.findViewById(R.id.temple_location);
            distanceTextView = itemView.findViewById(R.id.temple_distance);
            imageView = itemView.findViewById(R.id.temple_image);
            info = itemView.findViewById(R.id.temple_info);
        }
    }
}
