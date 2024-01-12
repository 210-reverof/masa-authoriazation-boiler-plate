package com.boilerplate.userservice.global.config;

import com.boilerplate.userservice.user.application.PasswordEncoder;
import com.boilerplate.userservice.user.application.SHA256PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder sha256PasswordEncoder() {
        return new SHA256PasswordEncoder();
    }
}
