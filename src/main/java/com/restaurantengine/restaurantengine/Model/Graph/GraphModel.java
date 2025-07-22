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

//    private int userCount;
//    private int restaurantCount;
    private int edgeCount;

    private Map<User, UserNode> userNodes;
    private Map<Restaurant, RestaurantNode> restaurantNodes;
    private Map<UserNode, List<Edge>> userMap;
    private Map<RestaurantNode, List<Edge>> restaurantMap;

    public GraphModel() {
//        userCount = 0;
//        restaurantCount = 0;
        edgeCount = 0;
        userMap = new HashMap<>();
        restaurantMap = new HashMap<>();
        userNodes = new HashMap<>();
        restaurantNodes = new HashMap<>();
    }


    @Override
    public int numNodes() {
        return userNodes.size() + restaurantNodes.size();
    }

    @Override
    public int numEdges() {
        return edgeCount;
    }

    @Override
    public int numRestaurants() {
        return restaurantNodes.size();
    }

    @Override
    public int numUsers() {
        return userNodes.size();
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
    public Iterable<Edge> userLikes(User user) {
        UserNode userNode = userNodes.get(user);
        List<Edge> edges = new ArrayList<>();
        for(Edge edge : userMap.get(userNode)) {
            if(edge.getType() == InteractionType.LIKE){
                edges.add(edge);
            }
        }
        return edges;
    }

    @Override
    public Iterable<Edge> userDislikes(User user) {
        UserNode userNode = userNodes.get(user);
        List<Edge> edges = new ArrayList<>();
        for(Edge edge : userMap.get(userNode)) {
            if(edge.getType() == InteractionType.DISLIKE){
                edges.add(edge);
            }
        }
        return edges;
    }

    @Override
    public UserNode addUser(User user) {
        UserNode userNode = new UserNode(user);
        userNodes.put(user, userNode);
        userMap.put(userNode, new ArrayList<>());
        return userNode;
    }

    @Override
    public RestaurantNode addRestaurant(Restaurant restaurant) {
        RestaurantNode restaurantNode = new RestaurantNode(restaurant);
        restaurantNodes.put(restaurant, restaurantNode);
        restaurantMap.put(restaurantNode, new ArrayList<>());
        return restaurantNode;
    }

    @Override
    public Edge addInteraction(User user, Restaurant restaurant, InteractionType interactionType) {
        UserNode userNode = userNodes.get(user);
        RestaurantNode restaurantNode = restaurantNodes.get(restaurant);
        Edge edge = new Edge(userNode, restaurantNode, interactionType);
        edgeCount++;
        userMap.get(userNode).add(edge);
        restaurantMap.get(restaurantNode).add(edge);
        return edge;
    }

    public  List<Restaurant> getRecommendations(User user){
        UserNode userNode = userNodes.get(user);
        List<Restaurant> recommendations = new ArrayList<>();

        return recommendations;
    }
}
