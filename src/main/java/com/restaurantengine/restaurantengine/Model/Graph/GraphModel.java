package com.restaurantengine.restaurantengine.Model.Graph;

/**
 * Graph implementation for restaurant recommendations
 */
public class GraphModel<V, E> extends AbstractGraph<V, E> {

    @Override
    public Edge<E> getEdge(Vertex<V> vertex1, Vertex<V> vertex2) {
        return null;
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> edge) {
        return null;
    }

    @Override
    public Vertex<V> opposite(Vertex<V> vertex, Edge<E> edge) {
        return null;
    }

    @Override
    public int outDegree(Vertex<V> vertex) {
        return 0;
    }

    @Override
    public int inDegree(Vertex<V> vertex) {
        return 0;
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> vertex) {
        return null;
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> vertex) {
        return null;
    }

    @Override
    public Vertex<V> addUser(V vertexData) {
        return null;
    }

    @Override
    public Vertex<V> addRestaurant(V vertexData) {
        return null;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeData) {
        return null;
    }

    @Override
    public void removeVertex(Vertex<V> vertex) {

    }

    @Override
    public void removeEdge(Edge<E> edge) {

    }
}
