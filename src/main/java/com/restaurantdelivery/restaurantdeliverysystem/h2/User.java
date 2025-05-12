package com.restaurantdelivery.restaurantdeliverysystem.h2;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true, nullable = false)
        private String username;

        @Column(nullable = false)
        private String password;

        @Enumerated(EnumType.STRING)
        private Role role;

        private boolean active = true;
    }

