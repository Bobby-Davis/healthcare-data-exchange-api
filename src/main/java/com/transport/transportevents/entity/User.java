package com.transport.transportevents.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    // unique identifier for the user, generated automatically by the database
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // username of the user, must be unique and cannot be null
    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

    // password of the user, cannot be null
    @Column(name="password", nullable = false)
    private String password;

    // email of the user, must be unique and cannot be null
    @Column(name="email", unique = true, nullable = false)
    private String email;

    // role of the user (e.g., "USER", "ADMIN"), cannot be null
    @Column(name="role", nullable = false)
    private String role;

    // default constructor
    public User() {}

    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
