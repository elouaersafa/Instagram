package com.example.projectinstagram.dto;

import com.example.projectinstagram.entities.Comment;
import com.example.projectinstagram.entities.Post;
import jakarta.persistence.*;

import java.util.List;

public class UserDto {

    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String photo;

    private List<Post> posts;

    private List<Comment> comments ;

    public UserDto() {
    }

    public UserDto(String userName, String firstName, String lastName, String password, String photo, List<Post> posts, List<Comment> comments) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.photo = photo;
        this.posts = posts;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
