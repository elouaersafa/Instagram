package com.example.projectinstagram.services;

import com.example.projectinstagram.entities.Comment;
import com.example.projectinstagram.entities.Post;
import com.example.projectinstagram.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
