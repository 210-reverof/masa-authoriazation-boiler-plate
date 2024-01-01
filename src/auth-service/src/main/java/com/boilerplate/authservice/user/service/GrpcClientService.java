package com.boilerplate.authservice.user.service;

import com.boilerplate.grpc.lib.HelloReply;
import com.boilerplate.grpc.lib.HelloRequest;
import com.boilerplate.grpc.lib.HelloServiceGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @GrpcClient("local-grpc-server")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    public String sendMessage(final String name) {
        try {
            final HelloReply response = this.helloServiceBlockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }

}