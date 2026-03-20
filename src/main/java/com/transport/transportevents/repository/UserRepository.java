package com.transport.transportevents.repository;

import com.transport.transportevents.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // find user by username
    Optional<User> findByUsername(String username);
    // find user by email
    Optional<User> findByEmail(String email);

    // check if username exists
    boolean existsByUsername(String username);

    // check if email exists
    boolean existsByEmail(String email);

}
