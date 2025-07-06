package com.restaurantengine.restaurantengine.Controllers;

import com.restaurantengine.restaurantengine.Services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public void createUser(@RequestParam String username,
                          @RequestParam String firstname,
                          @RequestParam String lastname,
                          @RequestParam boolean vegan,
                          @RequestParam boolean vegetarian,
                          @RequestParam double latitude,
                          @RequestParam double longitude,
                          @RequestParam String password) {
        //[TODO] Add hashing password
        userService.createUser(username, firstname, lastname, vegan, vegetarian, latitude, longitude, password);
    }


}
