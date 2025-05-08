package com.restaurantdelivery.restaurantdeliverysystem.Mapper;

import org.springframework.stereotype.Component;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Customer;
import com.restaurantdelivery.restaurantdeliverysystem.DTO.CustomerDTO;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerDTO toDTO(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerDTO dto = new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
        return dto;
    }

    public Customer toEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }

        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setFirstName(dto.getFirstname());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        return customer;
    }

    public List<CustomerDTO> toDTOList(List<Customer> customer) {
        if (customer == null) {
            return null;
        }

        return customer.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}