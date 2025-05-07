package com.restaurantdelivery.restaurantdeliverysystem.Repositories;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Purchase;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Customer;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    // Find all purchases by a specific customer
    List<Purchase> findByCustomer(Customer customer);

    // Find all purchases by a specific dish
    List<Purchase> findByDish(Dish dish);

    // Find all purchases by a specific customer, ordered by purchase date in descending order
    List<Purchase> findByCustomerOrderByPurchaseDateDesc(Customer customer);

    // Find all purchases by a specific dish, ordered by purchase date in descending order
    List<Purchase> findByCustomerAndDish(Customer customer, Dish dish);
}