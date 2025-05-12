package com.restaurantdelivery.restaurantdeliverysystem.Controller;

import com.restaurantdelivery.restaurantdeliverysystem.Service.CategoryService;
import com.restaurantdelivery.restaurantdeliverysystem.Service.DishService;
import com.restaurantdelivery.restaurantdeliverysystem.Service.UserService;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Category;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Dish;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Role;
import com.restaurantdelivery.restaurantdeliverysystem.h2.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted";
    }

    @PutMapping("/users/{id}/role")
    public String changeRole(@PathVariable Long id, @RequestParam Role role) {
        userService.changeUserRole(id, role);
        return "The role has changed";
    }

    @PutMapping("/users/{id}/block")
    public String blockUser(@PathVariable Long id) {
        userService.blockUser(id);
        return "The user is blocked";
    }

}
