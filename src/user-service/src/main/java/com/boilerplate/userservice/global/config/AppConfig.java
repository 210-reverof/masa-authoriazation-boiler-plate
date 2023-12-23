package com.boilerplate.userservice.global.config;

import com.boilerplate.common.passport.application.HMacPassportProvider;
import com.boilerplate.common.passport.application.PassportProvider;
import com.boilerplate.common.passport.presentation.AuthUserArgumentResolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableDiscoveryClient
@EnableJpaAuditing
public class AppConfig {
    @Value("${passport.algorithm}")
    String HMacAlgo;

    @Value("${passport.key}")
    String secretKey;

    @Bean
    public PassportProvider passportProvider() {
        return new HMacPassportProvider(HMacAlgo, secretKey, new ObjectMapper());
    }

    @Bean
    AuthUserArgumentResolver authUserArgumentResolver() {
        return new AuthUserArgumentResolver(passportProvider());
    }
}
