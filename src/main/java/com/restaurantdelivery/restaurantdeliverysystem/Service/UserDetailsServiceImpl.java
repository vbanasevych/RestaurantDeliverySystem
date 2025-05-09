package com.restaurantdelivery.restaurantdeliverysystem.Service;

import com.restaurantdelivery.restaurantdeliverysystem.Repositories.UserRepository;
import com.restaurantdelivery.restaurantdeliverysystem.h2.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new com.restaurantdelivery.restaurantdeliverysystem.Service.UserDetailsImpl(user);
    }

}
