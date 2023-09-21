package com.example.projectinstagram.repositories;

import com.example.projectinstagram.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
