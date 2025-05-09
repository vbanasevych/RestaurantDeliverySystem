package com.restaurantdelivery.restaurantdeliverysystem.Controller;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Restaurant;
import com.restaurantdelivery.restaurantdeliverysystem.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping
    public String listRestaurants(Model model) {
        model.addAttribute("restaurants", restaurantRepository.findAll());
        return "restaurant/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurant/form";
    }

    @PostMapping
    public String saveRestaurant(@ModelAttribute Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return "redirect:/restaurants";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid restaurant Id:" + id));
        model.addAttribute("restaurant", restaurant);
        return "restaurant/form";
    }

    @GetMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable Long id) {
        restaurantRepository.deleteById(id);
        return "redirect:/restaurants";
    }
}
