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

public class TempleAdapter extends RecyclerView.Adapter<TempleAdapter.TempleViewHolder> {

    private List<Temple> templeList;
    private Location userLocation;

    public TempleAdapter(List<Temple> templeList, Location userLocation) {
        this.templeList = templeList;
        this.userLocation = userLocation;
    }

    @NonNull
    @Override
    public TempleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_temples, parent, false);
        return new TempleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TempleViewHolder holder, int position) {
        Temple temple = templeList.get(position);
        holder.nameTextView.setText(temple.getName());
        holder.locationTextView.setText(temple.getLocation());
        holder.info.setText(temple.getInfo());
         Glide.with(holder.itemView.getContext()).load(temple.getImageUrl()).into(holder.imageView);

        if (userLocation != null) {
            Location templeLocation = new Location("");
            templeLocation.setLatitude(temple.getLatitude());
            templeLocation.setLongitude(temple.getLongitude());
            float distance = userLocation.distanceTo(templeLocation) / 1000 + 5; // distance in kilometers
            holder.distanceTextView.setText(String.format("%.2fkm ", distance));
        } else {
            holder.distanceTextView.setText("N/A");
        }
    }

    @Override
    public int getItemCount() {
        return templeList.size();
    }

    public static class TempleViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView locationTextView;
        TextView distanceTextView;
        ImageView imageView;
TextView info;
        public TempleViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.temple_name);
            locationTextView = itemView.findViewById(R.id.temple_location);
             distanceTextView = itemView.findViewById(R.id.temple_distance);
            imageView = itemView.findViewById(R.id.temple_image);
            info = itemView.findViewById(R.id.temple_info);
        }
    }
}
