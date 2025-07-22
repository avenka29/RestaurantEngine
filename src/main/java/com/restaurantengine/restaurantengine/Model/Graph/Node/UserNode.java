package com.restaurantengine.restaurantengine.Model.Graph.Node;

import com.restaurantengine.restaurantengine.Model.User;


/**
 * Represents a user node in the graph
 */
//TODO: Override equals method
public class UserNode implements Node {


    private User user;

    public UserNode(User user) {
        this.user = user;
    }
    @Override
    public User getElement() {
        return user;
    }
}
