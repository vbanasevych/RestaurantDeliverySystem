package com.restaurantdelivery.restaurantdeliverysystem.h2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Restaurant {

    private final long id;
    private final String name;
    private final String location;
    private List<Purchase> purchases = new ArrayList<>();

    public Restaurant() {
        this.id = 0L;
        this.name = "";
        this.location = "";
        this.purchases = new ArrayList<>();
    }

    public Restaurant(long id, String name, String location, List<Purchase> purchases) {
        if (name == null || location == null) {
            throw new IllegalArgumentException("Name and location cannot be null");
        }
        this.id = id;
        this.name = name;
        this.location = location;
        this.purchases = purchases;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant restaurant = (Restaurant) o;
        return id == restaurant.id && Objects.equals(name, restaurant.name) && Objects.equals(location, restaurant.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, purchases);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", purchases=" + purchases + '\'' +
                '}';
    }
}
