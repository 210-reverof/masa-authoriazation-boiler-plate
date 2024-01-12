package com.boilerplate.userservice.global.config;

import jakarta.annotation.PostConstruct;
import net.devh.boot.grpc.common.util.GrpcUtils;
import net.devh.boot.grpc.server.config.GrpcServerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties
public class TmpConfig {

    @Qualifier("eurekaRegistration")
    @Autowired(required = false)
    private EurekaRegistration eurekaRegistration;

    @Autowired
    private GrpcServerProperties grpcProperties;

    @PostConstruct
    public void init() {
        final int port = grpcProperties.getPort();
        eurekaRegistration.getInstanceConfig().getMetadataMap()
                .put(GrpcUtils.CLOUD_DISCOVERY_METADATA_PORT, Integer.toString(port));
    }

}

