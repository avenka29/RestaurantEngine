package com.restaurantengine.restaurantengine.Model;

import com.restaurantengine.restaurantengine.DTO.RestaurantDTO;

import java.util.List;

public class OverpassResponse {
    private List<RestaurantDTO> elements;

    public List<RestaurantDTO> getElements() {
        return elements;
    }

    public void setElements(List<RestaurantDTO> elements) {
        this.elements = elements;
    }
}
