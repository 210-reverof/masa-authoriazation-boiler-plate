package com.boilerplate.common.passport.dto;

public record Passport(
        UserInfo userInfo,
        String userInfoIntegrity) {}