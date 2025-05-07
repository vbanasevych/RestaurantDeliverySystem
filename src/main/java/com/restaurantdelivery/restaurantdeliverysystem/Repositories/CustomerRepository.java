package com.restaurantdelivery.restaurantdeliverysystem.Repositories;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmail(String email);

    List<Customer> findByFirstName(String firstName);

}
