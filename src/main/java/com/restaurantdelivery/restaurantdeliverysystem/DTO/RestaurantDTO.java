package com.restaurantdelivery.restaurantdeliverysystem.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RestaurantDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Location is required")
    private String location;

    @NotBlank(message = "Contsat number is required")
    private String contactNumber;

    public RestaurantDTO(Long id, @NotBlank(message = "Restaurant name cannot be blank") String name, @NotBlank(message = "Location cannot be blank") String location, @Pattern(regexp = "\\+?[0-9\\-\\s]{7,20}", message = "Invalid contact number format") String contactNumber) {
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