package com.example.userservice.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class UserServiceServer extends UserServiceGrpc.UserServiceImplBase {

    private final static Logger log = LoggerFactory.getLogger(UserServiceServer.class);

    @Override
    public void findUserById(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        log.info(String.format("Request received: %s", request.toString()));

        var userId = request.getUserId();
        var userResponse = UserResponse.newBuilder().setId(userId).setName("mert").build();

        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }
}
