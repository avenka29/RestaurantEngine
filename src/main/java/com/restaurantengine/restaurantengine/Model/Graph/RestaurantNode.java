package com.restaurantengine.restaurantengine.Model.Graph;

import com.restaurantengine.restaurantengine.Model.Restaurant;

public class RestaurantNode implements Node{

    private Restaurant restaurant;

    public RestaurantNode(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public Restaurant getElement() {
        return restaurant;
    }
}
