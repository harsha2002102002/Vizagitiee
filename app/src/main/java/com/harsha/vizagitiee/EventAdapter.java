package com.harsha.vizagitiee;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private Context context;
    private List<Event> eventList;

    // Constructor to initialize the adapter with context and data
    public EventAdapter(Context context, List<Event> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    // ViewHolder class to hold references to UI components for each item
    public static class EventViewHolder extends RecyclerView.ViewHolder {
        TextView eventName, eventLocation, eventDate, eventDescription;
ImageView image;
        public EventViewHolder(View itemView) {
            super(itemView);

            eventName = itemView.findViewById(R.id.event_name);
            eventLocation = itemView.findViewById(R.id.event_location);
            eventDate = itemView.findViewById(R.id.event_date);
            eventDescription = itemView.findViewById(R.id.event_description);
            image = itemView.findViewById(R.id.event_image);
        }
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.eventName.setText(event.getName());
        holder.eventLocation.setText(event.getLocation());
        holder.eventDate.setText(event.getDate());
        holder.eventDescription.setText(event.getDescription());
      Glide.with(holder.itemView.getContext()).load(event.getImageUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
