package com.example.projectinstagram.controller;

import com.example.projectinstagram.entities.User;

import com.example.projectinstagram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        try {

            List<User> users = userService.getAllUsers();

            return ResponseEntity.ok(users);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la récupération des tickets.");
        }
    }
    @PostMapping("/new")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

        if (userService.getUserByUserName(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Nom d'utilisateur déjà existant.");
        }

        userService.createUser(user);

        return ResponseEntity.ok("Inscription réussie.");
    }
   /* @PostMapping("/new")
    public ResponseEntity<?> createAd(@RequestBody User user) {
        try {

            User createdUser = userService.createUser(user);
            return ResponseEntity.ok(createdUser);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return ResponseEntity.badRequest().body("Failed to create ad: " + e.getMessage());
        }
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>("Deleted user with id " + userId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
