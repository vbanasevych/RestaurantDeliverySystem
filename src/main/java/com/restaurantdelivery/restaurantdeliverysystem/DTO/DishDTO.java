package com.restaurantdelivery.restaurantdeliverysystem.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Category;
import java.math.BigDecimal;

public class DishDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotNull(message = "Category price is required")
    private Category category;

    public DishDTO(Long id, @NotBlank(message = "Dish name cannot be blank") String name, @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0") BigDecimal price, Category category) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
