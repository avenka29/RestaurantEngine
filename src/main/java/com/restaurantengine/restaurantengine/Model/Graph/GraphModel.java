package com.restaurantengine.restaurantengine.Model.Graph;

import com.restaurantengine.restaurantengine.Model.Graph.Node.RestaurantNode;
import com.restaurantengine.restaurantengine.Model.Graph.Node.UserNode;
import com.restaurantengine.restaurantengine.Model.Restaurant;
import com.restaurantengine.restaurantengine.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

//TODO improve input validating and error handling
public class GraphModel implements Graph{

    private int userCount;
    private int restaurantCount;
    private int edgeCount;
    private Map<UserNode, List<Edge>> userMap;
    private Map<RestaurantNode, List<Edge>> restaurantMap;

    public GraphModel() {
        userCount = 0;
        restaurantCount = 0;
        edgeCount = 0;
        userMap = new HashMap<>();
        restaurantMap = new HashMap<>();
    }


    @Override
    public int numNodes() {
        return userCount + restaurantCount;
    }

    @Override
    public int numEdges() {
        return edgeCount;
    }

    @Override
    public int numRestaurants() {
        return restaurantCount;
    }

    @Override
    public int numUsers() {
        return userCount;
    }

    @Override
    public Edge getEdge(UserNode node1, RestaurantNode node2) {
        List<Edge> edges = userMap.get(node1);
        if (edges == null) {
            return null;
        }
        for (Edge edge : edges) {
            if (edge.getRestaurant().equals(node2)) {
                return edge;
            }
        }
        return null;
    }

//    @Override
//    public int users(RestaurantNode restaurant) {
//        return 0;
//    }

    @Override
    public Iterable<Edge> userLikes(UserNode user) {
        List<Edge> edges = new ArrayList<>();
        for(Edge edge : userMap.get(user)) {
            if(edge.getType() == InteractionType.LIKE){
                edges.add(edge);
            }
        }
        return edges;
    }

    @Override
    public Iterable<Edge> userDislikes(UserNode user) {
        List<Edge> edges = new ArrayList<>();
        for(Edge edge : userMap.get(user)) {
            if(edge.getType() == InteractionType.DISLIKE){
                edges.add(edge);
            }
        }
        return edges;
    }

    @Override
    public UserNode addUser(User user) {
        UserNode userNode = new UserNode(user);
        userMap.put(userNode, new ArrayList<>());
        userCount++;
        return userNode;
    }

    @Override
    public RestaurantNode addRestaurant(Restaurant restaurant) {
        RestaurantNode restaurantNode = new RestaurantNode(restaurant);
        restaurantMap.put(restaurantNode, new ArrayList<>());
        restaurantCount++;
        return restaurantNode;
    }

    @Override
    public Edge addInteraction(UserNode user, RestaurantNode restaurant, InteractionType interactionType) {
        Edge edge = new Edge(user, restaurant, interactionType);
        edgeCount++;
        userMap.get(user).add(edge);
        restaurantMap.get(restaurant).add(edge);
        return edge;
    }
}
