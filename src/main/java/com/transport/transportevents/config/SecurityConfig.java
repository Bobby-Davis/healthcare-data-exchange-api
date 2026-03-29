package com.transport.transportevents.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    // Tells Springs to use BCrypt for password hashing
    @Bean
    public PasswordEncoder passwordEncoder() {
        
        return new BCryptPasswordEncoder();
    }

    // sets up the security rules for the app
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF protection since we're using stateless REST APIs
            // If this isnt disabled POST request can fail because Spring expects a CSRF token that we aren't providing in our API requests
            .csrf(csrf -> csrf.disable())

            // allow auth routes to be accessed without authentication (like registration and login)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()

                // everyone else must be authenticated to access other endpoints
                .anyRequest().authenticated() 
            );

        return http.build();
    }
}
