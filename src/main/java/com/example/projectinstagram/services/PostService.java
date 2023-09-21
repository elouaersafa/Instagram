package com.example.projectinstagram.services;

import com.example.projectinstagram.entities.Post;
import com.example.projectinstagram.entities.User;
import com.example.projectinstagram.repositories.PostRepository;
import com.example.projectinstagram.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;




    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
