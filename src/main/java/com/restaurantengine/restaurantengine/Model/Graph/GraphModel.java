package com.restaurantengine.restaurantengine.Model.Graph;

import com.restaurantengine.restaurantengine.Model.Graph.Node.Node;
import com.restaurantengine.restaurantengine.Model.Graph.Node.RestaurantNode;
import com.restaurantengine.restaurantengine.Model.Graph.Node.UserNode;
import com.restaurantengine.restaurantengine.Model.Restaurant;
import com.restaurantengine.restaurantengine.Model.User;

import java.util.*;

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

//    @Override
//    public Iterable<Edge> userDislikes(User user) {
//        UserNode userNode = userNodes.get(user);
//        List<Edge> edges = new ArrayList<>();
//        for(Edge edge : userMap.get(userNode)) {
//            if(edge.getType() == InteractionType.DISLIKE){
//                edges.add(edge);
//            }
//        }
//        return edges;
//    }

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

    // TODO: Add depth limit to ensure dfs doesn't go too far
    /**
     * DFS implementation to find users that like the same restaurants
     * @param user User to match
     * @return List of similar users
     */
    public List<User> getSimilarUsers(User user){
        UserNode userNode = userNodes.get(user);
        List<User> similarUsers = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.push(userNode);
        while(!stack.isEmpty()){
            Node currentNode = stack.pop();
            if(currentNode instanceof UserNode){
                for(Edge likes: userMap.get((UserNode) currentNode)){
                    RestaurantNode restaurantEdge = likes.getRestaurant();
                    if(!visited.contains(restaurantEdge)){
                        stack.push(restaurantEdge);
                        visited.add(restaurantEdge);
                    }
                }
            }
            else if(currentNode instanceof RestaurantNode){
                for(Edge users: restaurantMap.get((RestaurantNode) currentNode)){
                    UserNode userEdge = users.getUser();
                    if(!visited.contains(userEdge) && !userEdge.getElement().equals(user)){
                        stack.push(userEdge);
                        visited.add(userEdge);
                        similarUsers.add(userEdge.getElement());

                    }
                }
            }
        }
        return similarUsers;
    }
}
