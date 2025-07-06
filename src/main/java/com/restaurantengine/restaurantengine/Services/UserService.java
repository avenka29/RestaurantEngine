package com.restaurantengine.restaurantengine.Services;

import com.restaurantengine.restaurantengine.Model.Address;
import com.restaurantengine.restaurantengine.Model.GeocodeResponse;
import com.restaurantengine.restaurantengine.Model.User;
import com.restaurantengine.restaurantengine.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Service for user operations like create, delete, etc
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    //Used to call external APIs
    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    /**
     * Method to create user. Calls OSM's geocoding API to get a user's city, state, and country
     * based on coordinates.
     * @param username Username
     * @param firstname First name
     * @param lastname Last Name
     * @param vegan Value indicating whether user is vegan
     * @param vegetarian Value indicating whether user is vegetarian
     * @param latitude Latitude
     * @param longitude Longitude
     * @param password Raw password to hash
     */
    @PostMapping
    public void createUser(String username, String firstname, String lastname, boolean vegan, boolean vegetarian,
                                                     double latitude,
                                                     double longitude,
                                                     String password) {
        String url = String.format("https://nominatim.openstreetmap.org/reverse?lat=%f&lon=%f&format=json",
                latitude, longitude);
        GeocodeResponse response = restTemplate.getForObject(url, GeocodeResponse.class);
        Address address = response.getAddress();
        String city = address.getCity();
        String state = address.getState();
        String country = address.getCountry();

        User user = new User(username, firstname, lastname, vegan, vegetarian,
                latitude, longitude, password, city, state, country);
        userRepository.save(user);
    }


}
