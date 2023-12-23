package com.boilerplate.userservice.user.dto.response;

import com.boilerplate.userservice.user.persistence.domain.Gender;
import com.boilerplate.userservice.user.persistence.domain.Role;
import com.boilerplate.userservice.user.persistence.domain.User;
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
    private Gender gender;
    private Integer age;
    private Role role;

    public UserInfoResponse(User user) {
        this(user.getId(), user.getEmail(), user.getNickname(), user.getGender(), user.getAge(), user.getRole());
    }
}
