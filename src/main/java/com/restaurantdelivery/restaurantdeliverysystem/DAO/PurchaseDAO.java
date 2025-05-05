package com.restaurantdelivery.restaurantdeliverysystem.DAO;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Purchase;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO {
    private final Connection conn;

    public PurchaseDAO(Connection conn) {
        if (conn == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.conn = conn;
    }
    public long addPurchase(Purchase purchase) throws SQLException {
        if (purchase == null || purchase.getTotalPrice() == null) {
            throw new IllegalArgumentException("Restaurant and its fields cannot be null");
        }
        String sql = "INSERT INTO category (totalPrice) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, purchase.getQuantity());
            pstmt.setLong(2, purchase.getDish().getId());
            pstmt.setLong(3, purchase.getCustomer().getId());
            pstmt.setBigDecimal(4, purchase.getTotalPrice());
            pstmt.executeUpdate();

            // Отримання згенерованого ID
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
            throw new SQLException("Failed to retrieve generated ID for the new purchase");
        }
    }
    public boolean updatePurchase(Purchase purchase) throws SQLException {
        if (purchase == null || purchase.getTotalPrice() == null) {
            throw new IllegalArgumentException("Restaurant and its fields cannot be null");
        }
        String sql = "UPDATE dish SET name = ?, quantity = ?, totalPrice = ?, product_id = ?, cusromer_id WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, purchase.getQuantity());
            pstmt.setLong(2, purchase.getDish().getId());
            pstmt.setLong(3, purchase.getCustomer().getId());
            pstmt.setBigDecimal(4, purchase.getTotalPrice());
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
                    return new Purchase(rs.getLong("id"), rs.getInt("quantity"), rs.getBigDecimal("totalPrice"));
                }
            }
        }
        return null;
    }
    public List<Purchase> getAllPurchase() throws SQLException {
        List<Purchase> purchases = new ArrayList<>();
        String sql = "SELECT * FROM purchase";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                purchases.add(new Purchase(rs.getLong("id"), rs.getInt("quantity"), rs.getBigDecimal("totalPrice")));
            }
        }
        return purchases;
    }
}