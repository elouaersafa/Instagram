package com.example.projectinstagram;

import com.example.projectinstagram.entities.Comment;
import com.example.projectinstagram.entities.User;
import com.example.projectinstagram.repositories.CommentRepository;
import com.example.projectinstagram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectInstagramApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;


        public static void main (String[]args){
        SpringApplication.run(ProjectInstagramApplication.class, args);
    }
        @Override
        public void run (String...args) throws Exception {
        User user1 = new User();
        user1.setFirstName("safa");
        user1.setPassword("mdp");
        userRepository.save(user1);
        Comment comment1 = new Comment();
        comment1.setComment("commentaire");
        comment1.setUser(user1);

        //commentRepository.save(comment1);
    }
    }
