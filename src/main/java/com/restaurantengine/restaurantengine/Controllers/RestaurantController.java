package com.restaurantengine.restaurantengine.Controllers;

import com.restaurantengine.restaurantengine.Model.Restaurant;
import com.restaurantengine.restaurantengine.Services.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for dealing with restaurant operations
 */
@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getRestaurantsNearLocation() {
        return restaurantService.getRestaurantsNearLocation(0.00, 0.00);
    }
}
