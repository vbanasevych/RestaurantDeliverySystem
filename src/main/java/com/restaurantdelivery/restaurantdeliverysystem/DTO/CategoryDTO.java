package com.restaurantdelivery.restaurantdeliverysystem.DTO;

import jakarta.validation.constraints.NotBlank;

public class CategoryDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    public CategoryDTO(Long id, @NotBlank(message = "Category name cannot be blank") String name) {
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
}
