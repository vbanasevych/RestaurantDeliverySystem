package com.restaurantdelivery.restaurantdeliverysystem.Service;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Purchase;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Customer;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseService {
    private final Connection conn;

    public PurchaseService(Connection conn) {
        if (conn == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.conn = conn;
    }

    public long addPurchase(Purchase purchase) throws SQLException {
        if (purchase == null || purchase.getTotalPrice() == null
                || purchase.getCustomer() == null || purchase.getDish() == null) {
            throw new IllegalArgumentException("Purchase and its fields cannot be null");
        }

        String sql = "INSERT INTO purchase (quantity, dish_id, customer_id, totalPrice) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, purchase.getQuantity());
            pstmt.setLong(2, purchase.getDish().getId());
            pstmt.setLong(3, purchase.getCustomer().getId());
            pstmt.setBigDecimal(4, purchase.getTotalPrice());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }

            throw new SQLException("Failed to retrieve generated ID for the new purchase");
        }
    }

    public boolean updatePurchase(Purchase purchase) throws SQLException {
        if (purchase == null || purchase.getTotalPrice() == null
                || purchase.getCustomer() == null || purchase.getDish() == null) {
            throw new IllegalArgumentException("Purchase and its fields cannot be null");
        }

        String sql = "UPDATE purchase SET quantity = ?, dish_id = ?, customer_id = ?, totalPrice = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, purchase.getQuantity());
            pstmt.setLong(2, purchase.getDish().getId());
            pstmt.setLong(3, purchase.getCustomer().getId());
            pstmt.setBigDecimal(4, purchase.getTotalPrice());
            pstmt.setLong(5, purchase.getId());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public boolean deletePurchase(long id) throws SQLException {
        String sql = "DELETE FROM purchase WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public Purchase getPurchaseById(long id) throws SQLException {
        String sql = "SELECT * FROM purchase WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapToPurchase(rs);
                }
            }
        }
        return null;
    }

    public List<Purchase> getAllPurchases() throws SQLException {
        List<Purchase> purchases = new ArrayList<>();
        String sql = "SELECT * FROM purchase";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                purchases.add(mapToPurchase(rs));
            }
        }
        return purchases;
    }

    // Допоміжний метод для створення Purchase об'єкта з ResultSet
    private Purchase mapToPurchase(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        int quantity = rs.getInt("quantity");
        long dishId = rs.getLong("dish_id");
        long customerId = rs.getLong("customer_id");
        var totalPrice = rs.getBigDecimal("totalPrice");

        // Якщо немає зовнішніх DAO/Service — створюємо пусті об'єкти з ID
        Dish dish = new Dish(dishId, null, null);
        Customer customer = new Customer(customerId, null, null, null);

        return new Purchase(id, quantity, totalPrice, dish, customer);
    }
}