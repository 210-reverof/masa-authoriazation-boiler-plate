package com.boilerplate.gatewayservice.application;

import com.boilerplate.gatewayservice.dto.TokenValidationResult;
import com.boilerplate.gatewayservice.dto.request.PassportRequest;
import com.boilerplate.gatewayservice.dto.response.PassportResponse;
import com.boilerplate.gatewayservice.infra.feign.AuthServiceClient;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthenticationProvider {
    private final AuthServiceClient authServiceClient;

    public Mono<Authentication> create(TokenValidationResult tokenValidationResult) {
        Claims claims = tokenValidationResult.claims();
        Long id = Long.parseLong(claims.getSubject());
        PassportResponse response = authServiceClient.getPassport(new PassportRequest(id));

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(response.getRole()));
        return Mono.justOrEmpty(new UsernamePasswordAuthenticationToken(response.getPassport(), null, authorities));
    }

}