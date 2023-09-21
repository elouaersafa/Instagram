package com.example.projectinstagram.repositories;

import com.example.projectinstagram.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);

    Boolean existsByUserName(String userName);
    Boolean existByEmail(String email);


}
