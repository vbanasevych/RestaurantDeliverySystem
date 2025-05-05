package DAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Dish;
public class DishDAO {
    private final Connection conn;

    public DishDAO(Connection conn) {
        if (conn == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.conn = conn;
    }

    public long addDish(Dish dish) throws SQLException {
        if (dish == null || dish.getName() == null) {
            throw new IllegalArgumentException("Dish and its fields cannot be null");
        }
        String sql = "INSERT INTO dish (name, price) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, dish.getName());
            pstmt.setBigDecimal(2, dish.getPrice());
            pstmt.executeUpdate();

            // Отримання згенерованого ID
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
            throw new SQLException("Failed to retrieve generated ID for the new dish");
        }
    }
    public boolean updateDish(Dish dish) throws SQLException {
        if (dish == null || dish.getName() == null) {
            throw new IllegalArgumentException("Dish and its fields cannot be null");
        }
        String sql = "UPDATE dish SET name = ?, price = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dish.getName());
            pstmt.setBigDecimal(2, dish.getPrice());
            pstmt.setLong(3, dish.getId());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public boolean deleteDish(long id) throws SQLException {
        String sql = "DELETE FROM dish WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public Dish getDishById(long id) throws SQLException {
        String sql = "SELECT * FROM dish WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Dish(rs.getLong("id"), rs.getString("name"), rs.getBigDecimal("price"));
                }
            }
        }
        return null;
    }
    public List<Dish> getAllDish() throws SQLException {
        List<Dish> dish = new ArrayList<>();
        String sql = "SELECT * FROM dish";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                dish.add(new Dish(rs.getLong("id"), rs.getString("name"), rs.getBigDecimal("price")));
            }
        }
        return dish;
    }
}
