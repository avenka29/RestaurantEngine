package com.restaurantengine.restaurantengine.Model;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Made to process api call response for nearby restaurants
 */
public class Restaurant {
     private long id;
     private double lat;

    @JsonProperty("lon")
    private double lng;

    @JsonProperty("tags")
    Map<String, String> tags;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }
}
