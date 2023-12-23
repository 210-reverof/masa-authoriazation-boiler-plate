package com.boilerplate.common.passport.dto;

public record Passport(
        UserInfo authUser,
        String authUserIntegrity) {}