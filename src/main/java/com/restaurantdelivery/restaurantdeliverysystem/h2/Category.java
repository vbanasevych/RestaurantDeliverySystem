package com.restaurantdelivery.restaurantdeliverysystem.h2;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Category name cannot be blank")
    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "dishes", fetch = FetchType.LAZY)
    private List<Dish> dishes = new ArrayList<>();
}
