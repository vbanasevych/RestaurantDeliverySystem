package com.restaurantdelivery.restaurantdeliverysystem.DTO;

import jakarta.validation.constraints.NotBlank;

public class RestaurantDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Contsat number is required")
    private String contactNumber;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
