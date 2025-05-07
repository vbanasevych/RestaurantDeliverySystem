package com.restaurantdelivery.restaurantdeliverysystem.h2;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "purchase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"customer", "product"})
@Builder
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Customer cannot be null")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Dish dish;

    @Column(nullable = false)
    @PositiveOrZero(message = "Quantity must be zero or positive")
    private int quantity;

    @Column(nullable = false)
    @PositiveOrZero(message = "Total price must be zero or positive")
    @Digits(integer = 19, fraction = 2)
    @NotNull(message = "Total price cannot be null")
    private BigDecimal totalPrice;

    @Column(nullable = false)
    @FutureOrPresent(message = "Purchase date must be in the present or future")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime purchaseDate;

    public Purchase(long id, int quantity, BigDecimal totalPrice, Dish dish, Customer customer) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.dish = dish;
        this.customer = customer;
    }

}