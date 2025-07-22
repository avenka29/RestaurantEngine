package com.restaurantengine.restaurantengine.Model.Graph;

import com.restaurantengine.restaurantengine.Model.Graph.Node.RestaurantNode;
import com.restaurantengine.restaurantengine.Model.Graph.Node.UserNode;
import com.restaurantengine.restaurantengine.Model.Restaurant;
import com.restaurantengine.restaurantengine.Model.User;

public interface Graph {

    /**
     * Method for number of vertices in a graph
     *
     * @return Integer of vertices in a graph
     */
    int numNodes();

    /**
     * Method for number of edges in a graph
     *
     * @return Integer of edges in a graph
     */
    int numEdges();


    /**
     * Method for number of restaurant nodes
     *
     * @return Integer of restaurant nodes in a graph
     */
    int numRestaurants();


    /**
     * Method for number of user nodes in graph
     *
     * @return Integer of user nodes in graph
     */
    int numUsers();


    /**
     * Returns the edge that exists between a restaurant and a user
     *
     * @param node1 source (user node)
     * @param node2 destination (restaurant node
     * @return the edge that exists between a restaurant and a user
     */
    Edge getEdge(UserNode node1, RestaurantNode node2);

//    /**
//     * The number of users who like a restaurant
//     * @param restaurant the vertex for which to retrieve the indegree
//     * @return the indegree of the given restaurant
//     */
//    int users(RestaurantNode restaurant);


    /**
     * Returns a collection of likes for a given user
     *
     * @param user for which to retrieve like edges
     * @return an {@link Iterable} collection of like edges for a given user
     */
    Iterable<Edge> userLikes(User user);


    /**
     * Returns a collection of dislikes for a given user
     *
     * @param user for which to retrieve dislike edges
     * @return an {@link Iterable} collection of dislike edges for a given user
     */
    Iterable<Edge> userDislikes(User user);


    /**
     * Adds a new user to the graph, and returns a reference to the node that
     * was created
     *
     * @param user the data to store in the new node
     * @return a reference to the newly created node
     */
    UserNode addUser(User user);


    /**
     * Adds a new restaurant to the graph, and returns a reference to the node that
     * was created
     *
     * @param restaurant the data to store in the new node
     * @return a reference to the newly created node
     */
    RestaurantNode addRestaurant(Restaurant restaurant);


    /**
     * Adds a new interaction edge (e.g., like or dislike) from a user to a restaurant.
     *
     * @param user The {@link UserNode} initiating the interaction.
     * @param restaurant The {@link RestaurantNode} that is the subject of the interaction.
     * @param interactionType An enumerated value defining the type of interaction (e.g., "LIKE", "DISLIKE").
     * @return The newly created {@link Edge} representing the interaction.
     */
    Edge addInteraction(User user, Restaurant restaurant, InteractionType interactionType);




}
