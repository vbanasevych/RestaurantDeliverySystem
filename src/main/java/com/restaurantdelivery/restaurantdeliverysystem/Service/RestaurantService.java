package com.restaurantdelivery.restaurantdeliverysystem.Service;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private final Connection conn;

    public RestaurantService(Connection conn) {
        if (conn == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.conn = conn;
    }
    public long addRestaurant(Restaurant restaurant) throws SQLException {
        if (restaurant == null || restaurant.getName() == null || restaurant.getLocation() == null) {
            throw new IllegalArgumentException("Restaurant and its fields cannot be null");
        }
        String sql = "INSERT INTO category (name, location) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getLocation());
            pstmt.executeUpdate();

            // Отримання згенерованого ID
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
            throw new SQLException("Failed to retrieve generated ID for the new restaurant");
        }
    }
    public boolean updateRestaurant(Restaurant restaurant) throws SQLException {
        if (restaurant == null || restaurant.getName() == null || restaurant.getLocation() == null) {
            throw new IllegalArgumentException("Restaurant and its fields cannot be null");
        }
        String sql = "UPDATE dish SET name = ?, location WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setLong(2, restaurant.getId());
            pstmt.setString(3, restaurant.getLocation());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public boolean deleteRestaurant(long id) throws SQLException {
        String sql = "DELETE FROM restaurant WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public Restaurant getRestaurantById(long id) throws SQLException {
        String sql = "SELECT * FROM restaurant WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Restaurant(rs.getLong("id"), rs.getString("name"), rs.getString("location"));
                }
            }
        }
        return null;
    }
    public List<Restaurant> getAllRestaurant() throws SQLException {
        List<Restaurant> restaurant = new ArrayList<>();
        String sql = "SELECT * FROM restaurant";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                restaurant.add(new Restaurant(rs.getLong("id"), rs.getString("name"), rs.getString("location")));
            }
        }
        return restaurant;
    }
}
