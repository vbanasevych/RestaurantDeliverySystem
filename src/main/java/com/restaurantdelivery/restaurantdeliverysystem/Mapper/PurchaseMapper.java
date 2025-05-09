package com.restaurantdelivery.restaurantdeliverysystem.Mapper;

import com.restaurantdelivery.restaurantdeliverysystem.DTO.PurchaseDTO;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Purchase;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PurchaseMapper {
    public PurchaseDTO toDTO(Purchase purchase) {
        if (purchase == null) {
            return null;
        }

        PurchaseDTO dto = new PurchaseDTO(
                purchase.getId(),
                purchase.getQuantity(),
                purchase.getDish(),
                purchase.getTotalPrice(),
                purchase.getCustomer()
        );
        return dto;
    }

    public Purchase toEntity(PurchaseDTO dto) {
        if (dto == null) {
            return null;
        }

        Purchase purchase = new Purchase();
        purchase.setId(dto.getId());
        purchase.setQuantity(dto.getQuantity());
        purchase.setDish(dto.getDish());
        purchase.setCustomer(dto.getCustomer());
        purchase.setTotalPrice(dto.getTotalPrice());
        return purchase;
    }

    public List<PurchaseDTO> toDTOList(List<Purchase> purchases) {
        if (purchases == null) {
            return null;
        }

        return purchases.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
