package com.restaurantengine.restaurantengine.Model.Graph.Node;

import com.restaurantengine.restaurantengine.Model.Restaurant;

//TODO: Override equals method
public class RestaurantNode implements Node {

    private Restaurant restaurant;

    public RestaurantNode(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public Restaurant getElement() {
        return restaurant;
    }
}
