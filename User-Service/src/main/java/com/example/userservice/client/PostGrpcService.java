package com.example.userservice.client;


import com.example.postservice.server.Post;
import com.example.postservice.server.PostRequest;
import com.example.postservice.server.PostServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostGrpcService {

    @Value("${post.grpc.service.host}")
    private String postGrpcServiceHost;

    @Value("${post.grpc.service.port}")
    private int postGrpcServicePort;

    private final static Logger log = LoggerFactory.getLogger(PostGrpcService.class);

    public List<Post> findPostsByUserId(int userId) {

        log.info(String.format("Request sending user id: %s", userId));

        ManagedChannel channel = ManagedChannelBuilder.forAddress(postGrpcServiceHost, postGrpcServicePort)
                .usePlaintext()
                .build();

        PostServiceGrpc.PostServiceBlockingStub stub = PostServiceGrpc.newBlockingStub(channel);

        var postRequest = PostRequest.newBuilder().setUserId(userId).build();
        var postResponse = stub.findPostsByUserId(postRequest);
        log.info(String.format("Response from post grpc server %s", postResponse.toString()));
        channel.shutdown();
        var postList = postResponse.getPostList();
        return postList;
    }

}
