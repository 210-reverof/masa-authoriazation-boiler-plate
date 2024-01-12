package com.boilerplate.gatewayservice.dto;

import io.jsonwebtoken.Claims;

public record TokenValidationResult(Claims claims, String token) {
}