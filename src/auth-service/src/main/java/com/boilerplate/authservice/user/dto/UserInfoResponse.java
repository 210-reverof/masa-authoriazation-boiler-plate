package com.boilerplate.authservice.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    public Long id;
    private String email;
    private String nickname;
    private String gender;
    private Integer age;
    private String role;
}
