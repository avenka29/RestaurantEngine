package com.restaurantengine.restaurantengine.Model.Graph;

import com.restaurantengine.restaurantengine.Model.Graph.Node.RestaurantNode;
import com.restaurantengine.restaurantengine.Model.Graph.Node.UserNode;

public class Edge {

    private InteractionType type;
    private UserNode user;
    private RestaurantNode restaurant;

    public Edge(UserNode user, RestaurantNode restaurant, InteractionType type) {
        setUser(user);
        setRestaurant(restaurant);
        setType(type);
    }

    /**
     * Gets type of interaction
     * @return Enumerated value
     */
    public InteractionType getType(){
        return type;
    };

    public void setType(InteractionType type){
        this.type = type;
    }


    public UserNode getUser() {
        return user;
    }

    public void setUser(UserNode user) {
        this.user = user;
    }

    public RestaurantNode getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantNode restaurant) {
        this.restaurant = restaurant;
    }
}
