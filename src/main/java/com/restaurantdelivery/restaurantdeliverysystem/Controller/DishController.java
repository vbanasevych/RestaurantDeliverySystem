package com.restaurantdelivery.restaurantdeliverysystem.Controller;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Dish;
import com.restaurantdelivery.restaurantdeliverysystem.Repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    @GetMapping
    public String listDishes(Model model) {
        model.addAttribute("dishes", dishRepository.findAll());
        return "dish/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("dish", new Dish());
        return "dish/form";
    }

    @PostMapping
    public String saveDish(@ModelAttribute Dish dish) {
        dishRepository.save(dish);
        return "redirect:/dishes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid dish Id:" + id));
        model.addAttribute("dish", dish);
        return "dish/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDish(@PathVariable Long id) {
        dishRepository.deleteById(id);
        return "redirect:/dishes";
    }
}
