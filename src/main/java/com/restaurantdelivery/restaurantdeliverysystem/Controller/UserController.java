package com.restaurantdelivery.restaurantdeliverysystem.Controller;

import com.restaurantdelivery.restaurantdeliverysystem.Repositories.UserRepository;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Role;
import com.restaurantdelivery.restaurantdeliverysystem.h2.User;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // <-- обов’язково!
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("Валідаційна помилка:");
            result.getAllErrors().forEach(System.out::println);
            return "register";
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "redirect:/register?error=usernameExists";
        }

        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Role: " + user.getRole());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        userRepository.save(user);

        return user.getRole() == Role.ADMIN ? "redirect:/admin" : "redirect:/customer";
    }
}