package com.boilerplate.gatewayservice.application;

import com.boilerplate.gatewayservice.dto.TokenValidationResult;
import com.boilerplate.gatewayservice.exception.InvalidTokenException;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenService {
    private final Key key;

    public JwtTokenService(@Value("${jwt.key}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Mono<TokenValidationResult> validateToken(String token) {
        try {
            Claims claims = getClaimsJws(token);

            if (claims.getExpiration().before(new Date())) {
                throw new RuntimeException("JWT token is expired!");
            }

            TokenValidationResult tokenValidationResult = new TokenValidationResult(claims, token);

            return Mono.just(tokenValidationResult)
                    .onErrorResume(ex -> Mono.error(new InvalidTokenException("잘못된 토큰")));

        } catch (JwtException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new InvalidTokenException("잘못된 토큰");
        }

    }

    private Claims getClaimsJws(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}