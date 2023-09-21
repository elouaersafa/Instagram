package com.example.projectinstagram.services;

import com.example.projectinstagram.entities.User;
import com.example.projectinstagram.repositories.CommentRepository;
import com.example.projectinstagram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User getUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
    public User findByUsernameById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();}
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }



}
