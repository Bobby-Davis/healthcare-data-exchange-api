package com.transport.transportevents.service;

import com.transport.transportevents.entity.User;
import com.transport.transportevents.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // gives acces to database actions for users
    private final UserRepository userRepository;

    // used to hash (secure) passwords before storing them in the database
    private final PasswordEncoder passwordEncoder;

    // Spring automatically provides these when the app runs
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to register(create) a new user account
    public User registerUser(User user) {

        // Check if username or email already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        // check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        // hash the password before saving the user to the database
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // give user a default role of "USER" when they register
        user.setRole("USER");

        // Save the user to the database
        return userRepository.save(user);
    }
}
