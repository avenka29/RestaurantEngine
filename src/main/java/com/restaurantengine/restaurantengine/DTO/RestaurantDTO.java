package com.restaurantengine.restaurantengine.DTO;

public class RestaurantDTO {
    private String id;
    private double lat;
    private double lon;

    private TagsDTO tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public TagsDTO getTags() {
        return tags;
    }

    public void setTags(TagsDTO tags) {
        this.tags = tags;
    }
}
