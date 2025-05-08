package com.restaurantdelivery.restaurantdeliverysystem.Mapper;

import org.springframework.stereotype.Component;
import com.restaurantdelivery.restaurantdeliverysystem.DTO.RestaurantDTO;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Restaurant;

@Component
public class RestaurantMapper {
    public RestaurantDTO toDTO(Restaurant restaurant) {
        if (restaurant == null) {
            return null;
        }

        RestaurantDTO dto = new RestaurantDTO(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getLocation(),
                restaurant.getContactNumber()
        );
        return dto;
    }

    public Restaurant toEntity(RestaurantDTO dto) {
        if (dto == null) {
            return null;
        }

        Restaurant restaurant = new Restaurant();
        restaurant.setId(dto.getId());
        restaurant.setName(dto.getName());
        restaurant.setLocation(dto.getLocation());
        restaurant.setContactNumber(dto.getContactNumber());
        return restaurant;
    }

}