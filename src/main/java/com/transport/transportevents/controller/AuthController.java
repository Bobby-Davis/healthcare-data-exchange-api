package com.transport.transportevents.controller;

import com.transport.transportevents.entity.User;
import com.transport.transportevents.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // AuthService is injected to handle the business logic of user registration
    private final AuthService authService;

    // Automatically gives AuthController access to AuthService when the app runs
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // handles POST requests to /api/auth/register to create a new user account
    // takes JSON data in the request body and converts it to a User object
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            // send the user data to the service to handle logic (validation, hashing password, saving to database)
            authService.registerUser(user);
            //return a 201 Created status with a success message in the response body
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (IllegalArgumentException e) {
            // if there is an error (like username or email already exists), return a 400 Bad Request status with the error message in the response body
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        try {
            // send the username and password to the service to handle logic (verifying credentials)
            authService.loginUser(user.getUsername(), user.getPassword());
            // if login is successful, return a 200 OK status with a success message in the response body (will change to return a JWT token in the future)
            return ResponseEntity.ok("Login successful");
        
        } catch (IllegalArgumentException e) {
            // if there is an error (like invalid username or password), return a 401 Unauthorized status with the error message in the response body
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    
}
