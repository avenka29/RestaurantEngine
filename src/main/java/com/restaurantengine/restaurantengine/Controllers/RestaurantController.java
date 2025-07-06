package com.restaurantengine.restaurantengine.Controllers;

import com.restaurantengine.restaurantengine.Services.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public String getRestaurantsNearLocation() {
        return restaurantService.getRestaurantsNearLocation(0.00, 0.00);
    }
}
