package com.restaurantdelivery.restaurantdeliverysystem.h2;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private long id;
    private String name;
    private List<Dish> dishes = new ArrayList<>();
}
