package com.restaurantdelivery.restaurantdeliverysystem.h2;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Purchase> purchases = new ArrayList<>();

}