package com.restaurantdelivery.restaurantdeliverysystem.h2;

import java.util.Objects;

public class Customer {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String email;

    public Customer() {
        this.id = 0L;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }

    public Customer(long id, String firstName, String lastName, String email) {
        if (firstName == null || lastName == null || email == null) {
            throw new IllegalArgumentException("First name, last name and email cannot be null");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName ,lastName, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first name='" + firstName + '\'' +
                ", last name='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}