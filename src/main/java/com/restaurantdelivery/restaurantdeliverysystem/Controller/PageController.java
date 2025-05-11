package com.restaurantdelivery.restaurantdeliverysystem.Controller;

import com.restaurantdelivery.restaurantdeliverysystem.Repositories.CategoryRepository;
import com.restaurantdelivery.restaurantdeliverysystem.Repositories.DishRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PageController {

    private final CategoryRepository categoryRepository;
    private final DishRepository dishRepository;

    public PageController(CategoryRepository categoryRepository, DishRepository dishRepository) {
        this.categoryRepository = categoryRepository;
        this.dishRepository = dishRepository;
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("dishes", dishRepository.findAll());
        return "admin"; // admin.jsp
    }

    @GetMapping("/customer")
    public String showCustomerPage(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cart", List.of()); // або отримати з сесії/сервісу
        return "customer"; // customer.jsp
    }

    @GetMapping("/customer/category/{id}")
    public String showCategory(@PathVariable Long id, Model model) {
        var category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            model.addAttribute("selectedCategory", category);
            model.addAttribute("dishes", dishRepository.findByCategory(category));
        }
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("cart", List.of()); // або з сервісу
        return "customer";
    }
}

