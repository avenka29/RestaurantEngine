package com.restaurantengine.restaurantengine.Repositories;

import com.restaurantengine.restaurantengine.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
