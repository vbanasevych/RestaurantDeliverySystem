package com.restaurantdelivery.restaurantdeliverysystem.h2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Category {

    private final long id;
    private final String name;
    private List<Dish> dishes = new ArrayList<>();

    public Category() {
        this.id = 0L;
        this.name = "";
        this.dishes = new ArrayList<>();
    }

    public Category(long id, String name, List<Dish> dishes) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.id = id;
        this.name = name;
        this.dishes = dishes;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dishes);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dishes='" + dishes + '\'' +
                '}';
    }
}
