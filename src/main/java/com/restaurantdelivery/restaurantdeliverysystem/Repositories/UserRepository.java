package com.restaurantdelivery.restaurantdeliverysystem.Repositories;

import com.restaurantdelivery.restaurantdeliverysystem.h2.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
