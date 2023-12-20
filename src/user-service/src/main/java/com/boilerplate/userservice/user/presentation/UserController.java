package com.boilerplate.userservice.user.presentation;

import com.boilerplate.userservice.user.application.UserService;
import com.boilerplate.userservice.user.dto.request.UserJoinRequest;
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

}
