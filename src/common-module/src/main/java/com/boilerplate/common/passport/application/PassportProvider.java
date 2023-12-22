package com.boilerplate.common.passport.application;

import com.boilerplate.common.passport.dto.AuthUser;

public interface PassportProvider {
    String generatePassport(AuthUser memberInfo);
    AuthUser getMemberInfo(String message);
    boolean validatePassport(String message);
}