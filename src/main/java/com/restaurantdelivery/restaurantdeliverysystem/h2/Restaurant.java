package com.restaurantdelivery.restaurantdeliverysystem.h2;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Store name cannot be blank")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Location cannot be blank")
    private String location;

    @Pattern(regexp = "\\+?[0-9\\-\\s]{7,20}", message = "Invalid contact number format")
    private String contactNumber;

    @Builder.Default
    @ManyToMany(mappedBy = "stores", fetch = FetchType.LAZY)
    private Set<Dish> products = new HashSet<>();

}
