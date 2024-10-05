package com.harsha.vizagitiee;

public class FoodItem {
    private String name;
    private String description;
            private String location;
    private String ImageUrl;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public FoodItem(String name, String description, String location, String ImageUrl) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.ImageUrl = ImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
