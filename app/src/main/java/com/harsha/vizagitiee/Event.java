package com.harsha.vizagitiee;

public class Event {
    private String name;
    private String location;
    private String date;
    private String description;
private  String ImageUrl;
    public Event() {
        // Default constructor required for calls to DataSnapshot.getValue(Event.class)
    }

    public Event(String ImageUrl, String name, String location, String date, String description) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.description = description;
        this.ImageUrl = ImageUrl;
    }

    public  String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
