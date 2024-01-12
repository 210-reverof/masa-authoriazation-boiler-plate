package com.boilerplate.authservice.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginResponse {
    private String accessToken;
    private String refreshToken;
    private String role;
    private Long memberId;
}
