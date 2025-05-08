package com.restaurantdelivery.restaurantdeliverysystem.Mapper;

import org.springframework.stereotype.Component;
import com.restaurantdelivery.restaurantdeliverysystem.DTO.DishDTO;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Dish;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DishMapper {
    public DishDTO toDTO(Dish dish) {
        if (dish == null) {
            return null;
        }

        DishDTO dto = new DishDTO(
                dish.getId(),
                dish.getName(),
                dish.getPrice(),
                dish.getCategory()
        );
        return dto;
    }

    public Dish toEntity(DishDTO dto) {
        if (dto == null) {
            return null;
        }

        Dish dish = new Dish();
        dish.setId(dto.getId());
        dish.setName(dto.getName());
        dish.setPrice(dto.getPrice());
        dish.setCategory(dto.getCategory());
        return dish;
    }

    public List<DishDTO> toDTOList(List<Dish> dishes) {
        if (dishes == null) {
            return null;
        }

        return dishes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}