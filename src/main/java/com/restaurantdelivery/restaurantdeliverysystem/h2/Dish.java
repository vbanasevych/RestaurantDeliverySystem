package com.restaurantdelivery.restaurantdeliverysystem.h2;

import java.util.Objects;

public class Dish {

    private final long id;
    private final String name;
    private final double price;

    public Dish() {
        this.id = 0L;
        this.name = "";
        this.price = 0L;
    }

    public Dish(long id, String name, double price) {
        if (name == null || price == 0) {
            throw new IllegalArgumentException("Name and price cannot be null");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id && Objects.equals(name, dish.name) && Objects.equals(price, dish.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
