package com.example.postservice.controller;

import com.example.postservice.model.Post;
import com.example.postservice.model.PostResponseWithUser;
import com.example.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/{postId}/users")
    public PostResponseWithUser findPostByIdWithUser(@PathVariable int postId) {
        return postService.findPostByIdWithUser(postId);
    }

}
