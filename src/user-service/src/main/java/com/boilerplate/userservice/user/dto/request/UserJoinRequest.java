package com.boilerplate.userservice.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserJoinRequest {
    private String email;
    private String password;
    private String nickname;
    private String gender;
    private Integer age;
}
