package com.example.postservice.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class PostServiceServer extends PostServiceGrpc.PostServiceImplBase {

    private final static Logger log = LoggerFactory.getLogger(PostServiceServer.class);

    @Override
    public void findPostsByUserId(PostRequest request, StreamObserver<PostResponse> responseObserver) {
        log.info(String.format("Request received: %s", request.toString()));

        var userPosts = filterPost(request.getUserId());
        var userPostsResponse = PostResponse.newBuilder().addAllPost(userPosts).build();

        log.info(String.format("Response post: %s", userPostsResponse.toString()));
        responseObserver.onNext(userPostsResponse);
        responseObserver.onCompleted();
    }

    private List<Post> filterPost(int userId) {
        List<Post> posts = Arrays.asList(
                Post.newBuilder().setId(1).setSubject("sub 1").setContent("content 1").setUserId(1).build(),
                Post.newBuilder().setId(2).setSubject("sub 2").setContent("content 2").setUserId(1).build(),
                Post.newBuilder().setId(3).setSubject("sub 3").setContent("content 3").setUserId(2).build(),
                Post.newBuilder().setId(4).setSubject("sub 4").setContent("content 4").setUserId(3).build(),
                Post.newBuilder().setId(5).setSubject("sub 5").setContent("content 5").setUserId(3).build(),
                Post.newBuilder().setId(6).setSubject("sub 6").setContent("content 6").setUserId(2).build(),
                Post.newBuilder().setId(7).setSubject("sub 7").setContent("content 7").setUserId(4).build()
        );
        var filteredPosts = posts.stream().filter(post -> post.getUserId() == userId).collect(Collectors.toList());
        return filteredPosts;
    }
}
