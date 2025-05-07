package com.restaurantdelivery.restaurantdeliverysystem.Repositories;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Category;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

    List<Dish> findByName(String name);

    List<Dish> findByCategory(Category category);

    List<Dish> findAllByOrderByPriceAsc();

    List<Dish> findAllByOrderByPriceDesc();
}