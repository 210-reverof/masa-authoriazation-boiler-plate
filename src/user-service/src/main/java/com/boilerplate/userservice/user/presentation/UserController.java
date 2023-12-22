package com.boilerplate.userservice.user.presentation;

import com.boilerplate.common.passport.dto.UserInfo;
import com.boilerplate.common.passport.presentation.AuthUser;
import com.boilerplate.userservice.user.application.UserService;
import com.boilerplate.userservice.user.dto.request.UserJoinRequest;
import com.boilerplate.userservice.user.dto.response.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<Void> join(@RequestBody UserJoinRequest userJoinRequest) {
        userService.join(userJoinRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<UserInfoResponse> getUserInfo(@AuthUser UserInfo userInfo) {
        return ResponseEntity.ok(userService.getInfoById(userInfo.id()));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getInfoById(userId));
    }

}
