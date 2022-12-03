package com.example.postservice.service;

import com.example.postservice.client.UserGrpcService;
import com.example.postservice.model.Post;
import com.example.postservice.model.PostResponseWithUser;
import com.example.postservice.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private final UserGrpcService userGrpcService;

    @Autowired
    public PostService(UserGrpcService userGrpcService) {
        this.userGrpcService = userGrpcService;
    }

    public PostResponseWithUser findPostByIdWithUser(int postId) {
        var post = filterPost(postId);
        var userResponse = userGrpcService.findUserById(post.getUserId());

        UserResponse user = new UserResponse(userResponse.getId(), userResponse.getName());
        var postResponseWithUser = new PostResponseWithUser(post.getId(), post.getSubject(), post.getContent(), user);
        return postResponseWithUser;
    }

    private Post filterPost(int postId) {
        List<Post> posts = Arrays.asList(
                new Post(1, "sub 1", "content 1", 1),
                new Post(2, "sub 2", "content 2", 1),
                new Post(3, "sub 3", "content 3", 2),
                new Post(4, "sub 4", "content 4", 3),
                new Post(5, "sub 5", "content 1", 3),
                new Post(6, "sub 6", "content 6", 2),
                new Post(7, "sub 7", "content 7", 4)
        );
        var filteredPost = posts.stream().filter(post -> post.getId() == postId).findFirst();
        return filteredPost.get();
    }

}
