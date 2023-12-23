package com.boilerplate.authservice.auth.application;

public interface TokenProvider {
    String generateAccessToken(Long payload);
    String generateRefreshToken(Long payload);
    String generateAccessToken(String payload);
    String generateRefreshToken(String payload);
    String getPayload(String token);
    void validateToken(String token);
}