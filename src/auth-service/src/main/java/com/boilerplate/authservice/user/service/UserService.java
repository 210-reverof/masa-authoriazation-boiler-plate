package com.boilerplate.authservice.user.service;

import com.boilerplate.authservice.auth.dto.request.LoginRequest;
import com.boilerplate.authservice.global.infra.feign.UserServiceClient;
import com.boilerplate.authservice.user.dto.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserServiceClient userServiceClient;

    public UserInfoResponse getUserById(Long id) {
        // TODO: cache 추가하기
        return requestUserInfo(id);
    }

    public Long checkLogin(LoginRequest loginRequest) {
        // TODO: feign 예외처리
        return userServiceClient.checkLogin(loginRequest);
    }

    private UserInfoResponse requestUserInfo(Long id) {
        return userServiceClient.getUserInfo(id);
    }
}
