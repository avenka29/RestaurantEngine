package com.restaurantengine.restaurantengine.Controllers;

import com.restaurantengine.restaurantengine.Model.Restaurant;
import com.restaurantengine.restaurantengine.Repositories.RestaurantRepository;
import com.restaurantengine.restaurantengine.Services.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for dealing with restaurant operations
 */
@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantService restaurantService, RestaurantRepository restaurantRepository) {
        this.restaurantService = restaurantService;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping
    public List<Restaurant> getRestaurantsNearLocation(@RequestParam double lat, @RequestParam double lng) {
        List<Restaurant> response = restaurantService.getRestaurantsNearLocation(lat, lng);
        restaurantRepository.saveAll(response);
        return response;
    }




}
