package com.restaurantengine.restaurantengine.Model.Graph;

public abstract class AbstractGraph <V, E>  implements Graph<V, E> {


    protected int userCount;
    protected int restaurantCount;
    protected int edgeCount;

    @Override
    public int numVertices() {
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

    protected class RestaurantVertex implements Vertex<V> {
        private V element;

        @Override
        public V getElement() {
            return null;
        }
    }

}
