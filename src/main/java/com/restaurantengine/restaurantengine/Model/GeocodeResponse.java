package com.restaurantengine.restaurantengine.Model;

/**
 * Geocode response model that OSM api sends when given lat and long
 */
public class GeocodeResponse {

    /**
     * Gets address in GeocodeResponse
     * @return Address object
     */
    public Address getAddress() {
        return address;
    }


    private Address address;
}
