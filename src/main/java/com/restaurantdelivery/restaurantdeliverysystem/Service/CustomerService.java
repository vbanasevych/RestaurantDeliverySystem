package com.restaurantdelivery.restaurantdeliverysystem.Service;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final Connection conn;

    public CustomerService(Connection conn) {
        if (conn == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.conn = conn;
    }
    public long addCustomer(Customer customer) throws SQLException {
        if (customer == null || customer.getFirstName() == null || customer.getLastName() == null || customer.getEmail() == null ) {
            throw new IllegalArgumentException("Customer and its fields cannot be null");
        }
        String sql = "INSERT INTO customer (firstName, lastName, email) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getEmail());
            pstmt.executeUpdate();

            // Отримання згенерованого ID
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
            throw new SQLException("Failed to retrieve generated ID for the new customer");
        }
    }
    public boolean updateCustomer(Customer customer) throws SQLException {
        if (customer == null || customer.getFirstName() == null || customer.getLastName() == null || customer.getEmail() == null) {
            throw new IllegalArgumentException("Customer and its fields cannot be null");
        }
        String sql = "UPDATE dish SET firstName = ?, lastName = ?, email = ?  WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getEmail());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public boolean deleteCustomer(long id) throws SQLException {
        String sql = "DELETE FROM customer WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public Customer getCustomerById(long id) throws SQLException {
        String sql = "SELECT * FROM customer WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Customer(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"));
                }
            }
        }
        return null;
    }
    public List<Customer> getAllCustomer() throws SQLException {
        List<Customer> customer = new ArrayList<>();
        String sql = "SELECT * FROM customer";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                customer.add(new Customer(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email")));
            }
        }
        return customer;
    }

}

