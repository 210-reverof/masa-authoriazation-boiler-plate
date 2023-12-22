package com.boilerplate.common.passport.dto;

public record Passport(
        AuthUser authUser,
        String authUserIntegrity) {}