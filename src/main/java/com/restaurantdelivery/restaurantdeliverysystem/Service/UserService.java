package com.restaurantdelivery.restaurantdeliverysystem.Service;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Role;
import com.restaurantdelivery.restaurantdeliverysystem.h2.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.restaurantdelivery.restaurantdeliverysystem.Repositories.UserRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(String username, String password, Role role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Шифруємо пароль
        user.setRole(role);
        user.setActive(true);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void changeUserRole(Long id, Role newRole) {
        User user = userRepository.findById(id).orElseThrow();
        user.setRole(newRole);
        userRepository.save(user);
    }

    public void blockUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user);
    }
}
