package com.restaurantdelivery.restaurantdeliverysystem.Service;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Restaurant;
import com.restaurantdelivery.restaurantdeliverysystem.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        if (restaurant == null || restaurant.getName() == null || restaurant.getLocation() == null) {
            throw new IllegalArgumentException("Restaurant and its fields cannot be null");
        }
        return restaurantRepository.save(restaurant);
    }

    public boolean updateRestaurant(Restaurant restaurant) {
        if (restaurant == null || restaurant.getId() == null || restaurant.getName() == null || restaurant.getLocation() == null) {
            throw new IllegalArgumentException("Restaurant and its fields cannot be null");
        }
        if (restaurantRepository.existsById(restaurant.getId())) {
            restaurantRepository.save(restaurant);
            return true;
        }
        return false;
    }

    public boolean deleteRestaurant(long id) {
        if (restaurantRepository.existsById(id)) {
            restaurantRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Restaurant> getRestaurantById(long id) {
        return restaurantRepository.findById(id);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
