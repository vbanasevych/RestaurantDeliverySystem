package com.restaurantdelivery.restaurantdeliverysystem.Controller;

import com.restaurantdelivery.restaurantdeliverysystem.Service.UserService;
import com.restaurantdelivery.restaurantdeliverysystem.h2.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {
        userService.registerUser(username, password, Role.USER);
        return "The user is successfully registered";
    }
}
