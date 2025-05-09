package com.restaurantdelivery.restaurantdeliverysystem;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Dish;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class RestaurantDeliverySystemApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Dish dish = new Dish();

    }

    public static void main(String[] args) {
        SpringApplication.run(RestaurantDeliverySystemApplication.class, args);
    }

}
