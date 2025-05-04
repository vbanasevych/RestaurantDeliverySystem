package com.restaurantdelivery.restaurantdeliverysystem;

import java.sql.*;

public class probe {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:restaurantH2", "sa", "");
             Statement statement = connection.createStatement()) {
            // 1. Create a table to work with
            String createTableSql = "CREATE TABLE custumers (id INT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255))";
            statement.execute(createTableSql);
            // 2. Execute an INSERT query to add a new record
            String insertSql = "INSERT INTO users (id, name, email) VALUES (1, 'Alice', 'alice@example.com')";
            int rowsInserted = statement.executeUpdate(insertSql);
            System.out.println("Rows inserted: " + rowsInserted);
            // 3. Execute a SELECT query and retrieve data
            String selectSql = "SELECT id, name, email FROM users";
            ResultSet resultSet = statement.executeQuery(selectSql);
            System.out.println("User data:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
            // 4. Execute an UPDATE query to modify existing data
            String updateSql = "UPDATE users SET email='alice.new@example.com' WHERE id=1";
            int rowsUpdated = statement.executeUpdate(updateSql);
            System.out.println("Rows updated: " + rowsUpdated);
            // 5. Execute a DELETE query to remove a record
            String deleteSql = "DELETE FROM users WHERE id=1";
            int rowsDeleted = statement.executeUpdate(deleteSql);
            System.out.println("Rows deleted: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}