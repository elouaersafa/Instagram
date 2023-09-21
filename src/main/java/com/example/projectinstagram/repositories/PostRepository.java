package com.example.projectinstagram.repositories;

import com.example.projectinstagram.entities.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long> {
}
