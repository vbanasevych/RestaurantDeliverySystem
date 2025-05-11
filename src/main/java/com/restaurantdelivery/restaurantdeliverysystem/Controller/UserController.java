package com.restaurantdelivery.restaurantdeliverysystem.Controller;

import com.restaurantdelivery.restaurantdeliverysystem.Repositories.UserRepository;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Role;
import com.restaurantdelivery.restaurantdeliverysystem.h2.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String showRegistrationForm(@RequestParam(required = false) String role, Model model) {
        User user = new User();

        if (role != null) {
            try {
                user.setRole(Role.valueOf(role.toUpperCase()));
            } catch (IllegalArgumentException e) {
                user.setRole(Role.CUSTOMER);
            }
        } else {
            user.setRole(Role.CUSTOMER);
        }

        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "redirect:/register?error=usernameExists";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true); // <-- це обов’язково!
        userRepository.save(user);

        if (user.getRole() == Role.ADMIN) {
            return "redirect:/admin";
        } else {
            return "redirect:/customer";
        }
    }

    @GetMapping("/login")
    public String showLoginPage(@RequestParam(required = false) String role, Model model) {
        model.addAttribute("role", role != null ? role : "customer");
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String role,
                               Model model) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (passwordEncoder.matches(password, user.getPassword())) {
                if (user.getRole().name().equalsIgnoreCase(role)) {
                    // Перенаправляємо залежно від ролі
                    if (user.getRole() == Role.ADMIN) {
                        return "redirect:/admin";
                    } else {
                        return "redirect:/customer";
                    }
                } else {
                    model.addAttribute("loginError", "Role mismatch");
                    model.addAttribute("role", role);
                    return "login";
                }
            }
        }

        model.addAttribute("loginError", "Invalid username or password");
        model.addAttribute("role", role);
        return "login";
    }

}
