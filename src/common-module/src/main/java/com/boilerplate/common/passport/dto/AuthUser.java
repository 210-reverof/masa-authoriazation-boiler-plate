package com.boilerplate.common.passport.dto;

public record AuthUser(
    Long id,
    String email,
    String name,
    String gender,
    Integer age,
    String role
) {}
