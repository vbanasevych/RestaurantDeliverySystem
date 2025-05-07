package com.restaurantdelivery.restaurantdeliverysystem.Repositories;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
}