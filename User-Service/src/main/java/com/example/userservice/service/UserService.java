package com.example.userservice.service;

import com.example.userservice.client.PostGrpcService;
import com.example.userservice.model.Post;
import com.example.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final PostGrpcService postGrpcService;

    @Autowired
    public UserService(PostGrpcService postGrpcService) {
        this.postGrpcService = postGrpcService;
    }

    public User findUserByIdWithPosts(int userId) {
        var userPosts = postGrpcService.findPostsByUserId(userId);

        List<Post> posts = new ArrayList<>();
        userPosts.forEach(post -> posts.add(new Post(post.getId(), post.getSubject(), post.getContent(), post.getUserId())));

        var user = new User(1, "mert", posts);
        return user;
    }
}
