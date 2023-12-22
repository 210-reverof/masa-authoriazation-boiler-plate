package com.boilerplate.userservice.user.application;

import com.boilerplate.userservice.global.error.ErrorCode;
import com.boilerplate.userservice.user.dto.request.UserEmailRequest;
import com.boilerplate.userservice.user.dto.request.UserJoinRequest;
import com.boilerplate.userservice.user.dto.response.UserInfoResponse;
import com.boilerplate.userservice.user.exception.DuplicateEmailException;
import com.boilerplate.userservice.user.exception.NotFoundUserException;
import com.boilerplate.userservice.user.persistence.UserRepository;
import com.boilerplate.userservice.user.persistence.domain.Gender;
import com.boilerplate.userservice.user.persistence.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void join(UserJoinRequest userJoinRequest) {
        User user = convertToUser(userJoinRequest);

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException("중복된 이메일");
        }

        userRepository.save(user);
    }

    private User convertToUser(UserJoinRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Gender gender = Gender.valueOf(request.getGender());
        return new User(request.getEmail(), encodedPassword, request.getNickname(), gender, request.getAge());
    }

    public UserInfoResponse getInfoById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundUserException("없는 회원 id" + userId));
        return new UserInfoResponse(user);
    }

    public UserInfoResponse getInfoByEmail(UserEmailRequest userEmailRequest) {
        User user = userRepository.findByEmail(userEmailRequest.email()).orElseThrow(() -> new NotFoundUserException("없는 회원 email" + userEmailRequest.email()));
        return new UserInfoResponse(user);
    }
}
