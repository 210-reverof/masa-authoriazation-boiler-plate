package com.boilerplate.common.passport.application;

import com.boilerplate.common.passport.dto.UserInfo;

public interface PassportProvider {
    String generatePassport(UserInfo memberInfo);
    UserInfo getMemberInfo(String message);
    boolean validatePassport(String message);
}