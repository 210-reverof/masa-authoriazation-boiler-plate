package com.boilerplate.authservice.user.service;

import com.boilerplate.grpc.lib.HelloReply;
import com.boilerplate.grpc.lib.HelloRequest;
import com.boilerplate.grpc.lib.HelloServiceGrpc;
import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;

import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;
import java.util.Map;

@Service
public class GrpcClientService {

    @GrpcClient("cloud-grpc-server")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    private final DiscoveryClient discoveryClient;

    public GrpcClientService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public String sendMessage(final String name) {
        try {
            printServiceDetails();
            final HelloReply response = this.helloServiceBlockingStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (final StatusRuntimeException e) {
            System.out.println(e.getMessage());
            return "FAILED with " + e.getStatus().getCode();
        }
    }

    public void printServiceDetails() {
        List<String> services = discoveryClient.getServices();

        if (services.isEmpty()) {
            System.out.println("No services found in Eureka.");
        } else {
            System.out.println("Services found in Eureka:");
            for (String service : services) {
                System.out.println("Service: " + service);
                List<ServiceInstance> instances = discoveryClient.getInstances(service);
                for (ServiceInstance instance : instances) {
                    System.out.println("- Instance: " + instance.getInstanceId());
                    System.out.println("  - IP: " + instance.getHost());
                    System.out.println("  - Port: " + instance.getPort());
                    System.out.println("  - gRPC Port: " + getGrpcPort(instance));
                }
            }
        }
    }

    private String getGrpcPort(ServiceInstance instance) {
        final Map<String, String> metadata = instance.getMetadata();

        for (String str : metadata.keySet()) {
            System.out.println("== : " + str);
        }
        return instance.getMetadata().get("gRPC_Port");
    }

}