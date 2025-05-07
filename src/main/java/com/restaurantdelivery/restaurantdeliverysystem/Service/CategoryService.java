package com.restaurantdelivery.restaurantdeliverysystem.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Category;

public class CategoryService {
    private final Connection conn;

    public CategoryService(Connection conn) {
        if (conn == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.conn = conn;
    }
    public long addCategory(Category category) throws SQLException {
        if (category == null || category.getName() == null) {
            throw new IllegalArgumentException("Category and its fields cannot be null");
        }
        String sql = "INSERT INTO category (name) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, category.getName());
            pstmt.executeUpdate();

            // Отримання згенерованого ID
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
            throw new SQLException("Failed to retrieve generated ID for the new category");
        }
    }
    public boolean updateCategory(Category category) throws SQLException {
        if (category == null || category.getName() == null) {
            throw new IllegalArgumentException("Category and its fields cannot be null");
        }
        String sql = "UPDATE dish SET name = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category.getName());
            pstmt.setLong(2, category.getId());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public boolean deleteCategory(long id) throws SQLException {
        String sql = "DELETE FROM category WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public Category getCategoryById(long id) throws SQLException {
        String sql = "SELECT * FROM category WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Category(rs.getLong("id"), rs.getString("name"));
                }
            }
        }
        return null;
    }
    public List<Category> getAllCategory() throws SQLException {
        List<Category> category = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                category.add(new Category(rs.getLong("id"), rs.getString("name")));
            }
        }
        return category;
    }

}

