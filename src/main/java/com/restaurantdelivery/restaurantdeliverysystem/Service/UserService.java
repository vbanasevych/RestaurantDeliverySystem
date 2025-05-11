package com.restaurantdelivery.restaurantdeliverysystem.Service;

import com.restaurantdelivery.restaurantdeliverysystem.h2.Role;
import com.restaurantdelivery.restaurantdeliverysystem.h2.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.restaurantdelivery.restaurantdeliverysystem.Repositories.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // Додаємо PasswordEncoder для шифрування паролів

    public void registerUser(String username, String password, Role role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Шифруємо пароль
        user.setRole(role);
        user.setActive(true);
        userRepository.save(user); // Зберігаємо користувача з зашифрованим паролем
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void changeUserRole(Long id, Role newRole) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        user.setRole(newRole);
        userRepository.save(user);
    }

    public void blockUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user);
    }

    public User login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) { // Перевірка паролю
            return user.orElse(null); // Якщо пароль правильний
        }
        return null; // Якщо користувач не знайдений або пароль неправильний
    }
}
