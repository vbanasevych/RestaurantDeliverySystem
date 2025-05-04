package com.restaurantdelivery.restaurantdeliverysystem.h2;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;
import java.util.Set;
import java.util.HashSet;

public class Dish {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "product_store",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "store_id")
    )
    private Set<Restaurant> restaurants = new HashSet<>();

}
