package com.boilerplate.common.passport.dto;

public record UserInfo(
    Long id,
    String email,
    String name,
    String gender,
    Integer age,
    String role
) {}
