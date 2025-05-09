package com.restaurantdelivery.restaurantdeliverysystem.Service;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Category;
import com.restaurantdelivery.restaurantdeliverysystem.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        if (category == null || category.getName() == null) {
            throw new IllegalArgumentException("Category and its fields cannot be null");
        }
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        if (category == null || category.getName() == null || category.getId() == null) {
            throw new IllegalArgumentException("Category and its fields cannot be null");
        }
        if (!categoryRepository.existsById(category.getId())) {
            throw new IllegalArgumentException("Category with id " + category.getId() + " does not exist");
        }
        return categoryRepository.save(category);
    }

    public boolean deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}

