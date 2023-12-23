package com.boilerplate.authservice.global.config;

import com.boilerplate.common.passport.application.HMacPassportProvider;
import com.boilerplate.common.passport.application.PassportProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDiscoveryClient
public class AppConfig {
    @Value("${passport.algorithm}")
    String HMacAlgo;

    @Value("${passport.key}")
    String secretKey;

    @Bean
    public PassportProvider tokenProvider() {
        return new HMacPassportProvider(HMacAlgo, secretKey, new ObjectMapper());
    }

}
