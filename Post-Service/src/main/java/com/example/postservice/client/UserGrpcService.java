package com.example.postservice.client;

import com.example.userservice.server.UserRequest;
import com.example.userservice.server.UserResponse;
import com.example.userservice.server.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserGrpcService {

    @Value("${user.grpc.service.host}")
    private String userGrpcServiceHost;

    @Value("${user.grpc.service.port}")
    private int userGrpcServicePort;

    private final static Logger log = LoggerFactory.getLogger(UserGrpcService.class);

    public UserResponse findUserById(int userId) {
        log.info(String.format("Request sending user id: %s", userId));

        ManagedChannel channel = ManagedChannelBuilder.forAddress(userGrpcServiceHost, userGrpcServicePort)
                .usePlaintext()
                .build();

        UserServiceGrpc.UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);

        var userRequest = UserRequest.newBuilder().setUserId(userId).build();
        var userResponse = stub.findUserById(userRequest);
        log.info(String.format("Response from user grpc server %s", userResponse.toString()));
        channel.shutdown();
        return userResponse;
    }
}
