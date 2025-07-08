package com.restaurantengine.restaurantengine.Repositories;

import com.restaurantengine.restaurantengine.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
