package com.example.projectinstagram.controller;

import com.example.projectinstagram.entities.Comment;
import com.example.projectinstagram.entities.User;
import com.example.projectinstagram.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/all")
    public ResponseEntity<?> getAllComments() {
        try {

            List<Comment> comments = commentService.getAllComment();

            return ResponseEntity.ok(comments);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la récupération des tickets.");
        }
    }
    @PostMapping("/new")
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        try {

            Comment createdComment = commentService.createComment(comment);
            return ResponseEntity.ok(createdComment);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return ResponseEntity.badRequest().body("Failed to create ad: " + e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        try {
            Comment comment = commentService.getCommentById(id);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long commentId) {
        try {
            commentService.deleteComment(commentId);
            return new ResponseEntity<>("Deleted user with id " + commentId, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
