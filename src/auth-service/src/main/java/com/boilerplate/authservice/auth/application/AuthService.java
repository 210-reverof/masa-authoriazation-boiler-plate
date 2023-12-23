package com.boilerplate.authservice.auth.application;


import com.boilerplate.authservice.auth.dto.request.LoginRequest;
import com.boilerplate.authservice.auth.dto.response.LoginResponse;
import com.boilerplate.authservice.auth.persistence.RefreshTokenRepository;
import com.boilerplate.authservice.auth.persistence.domain.RefreshToken;
import com.boilerplate.authservice.user.dto.UserInfoResponse;
import com.boilerplate.authservice.user.service.UserService;
import com.boilerplate.common.passport.dto.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final TokenProvider tokenProvider;

    public LoginResponse login(LoginRequest loginRequest) {
        Long userId = userService.checkLogin(loginRequest);
        UserInfoResponse userInfo = userService.getUserById(userId);

        String accessToken = tokenProvider.generateAccessToken(userInfo.getId());
        String refreshToken = tokenProvider.generateRefreshToken(userInfo.getId());
        refreshTokenRepository.save(new RefreshToken(refreshToken, userInfo.getId()));

        return new LoginResponse(accessToken, refreshToken, userInfo.getRole(), userInfo.getId());
    }

}
