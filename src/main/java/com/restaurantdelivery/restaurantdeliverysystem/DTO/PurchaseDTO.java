package com.restaurantdelivery.restaurantdeliverysystem.DTO;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Customer;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Dish;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public class PurchaseDTO {
    private Long id;

    @NotBlank(message = "Username is required")
    private String username;

    @NotNull(message = "Customer is required")
    private Customer customer;

    @NotNull(message = "Dish is required")
    private Dish dish;

    @NotBlank(message = "Quantity is required")
    private int quantity;

    @NotNull(message = "Total price is required")
    private BigDecimal totalPrice;

    public PurchaseDTO(Long id, @PositiveOrZero(message = "Quantity must be zero or positive") int quantity, Dish dish, @PositiveOrZero(message = "Total price must be zero or positive") @Digits(integer = 19, fraction = 2) @NotNull(message = "Total price cannot be null") BigDecimal totalPrice, Object o) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
