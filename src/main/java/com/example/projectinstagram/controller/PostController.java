package com.example.projectinstagram.controller;

import com.example.projectinstagram.entities.Post;
import com.example.projectinstagram.entities.User;
import com.example.projectinstagram.services.PostService;
import com.example.projectinstagram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping("/all")
    public ResponseEntity<?> getAllPosts() {
        try {

            List<Post> posts = postService.getAllPosts();

            return ResponseEntity.ok(posts);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la récupération des tickets.");
        }
    }

    @PostMapping("/new")
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        try {

            Post createdPost = postService.createPost(post);
            return ResponseEntity.ok(createdPost);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return ResponseEntity.badRequest().body("Failed to create ad: " + e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            Post post = postService.getPostById(id);
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long postId) {
        try {
            postService.deletePost(postId);
            return new ResponseEntity<>("Deleted Post with id " + postId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
