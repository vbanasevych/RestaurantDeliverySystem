package com.restaurantdelivery.restaurantdeliverysystem.Mapper;

import com.restaurantdelivery.restaurantdeliverysystem.DTO.PurchaseDTO;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Purchase;
import org.springframework.stereotype.Component;
import com.restaurantdelivery.restaurantdeliverysystem.DTO.CategoryDTO;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Category;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {
    public CategoryDTO toDTO(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDTO dto = new CategoryDTO(
                category.getId(),
                category.getName()
        );
        return dto;
    }

    public Category toEntity(CategoryDTO dto) {
        if (dto == null) {
            return null;
        }

        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }

    public List<CategoryDTO> toDTOList(List<Category> categories) {
        if (categories == null) {
            return null;
        }

        return categories.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}