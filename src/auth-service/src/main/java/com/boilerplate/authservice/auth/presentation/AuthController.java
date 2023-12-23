package com.boilerplate.authservice.auth.presentation;

import com.boilerplate.authservice.auth.application.AuthService;
import com.boilerplate.authservice.auth.dto.request.LoginRequest;
import com.boilerplate.authservice.auth.dto.request.PassportRequest;
import com.boilerplate.authservice.auth.dto.response.LoginResponse;
import com.boilerplate.authservice.auth.dto.response.PassportResponse;
import com.boilerplate.authservice.user.dto.UserInfoResponse;
import com.boilerplate.authservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    ResponseEntity<LoginResponse> checkLogin(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/passport")
    ResponseEntity<PassportResponse> getPassport(@RequestBody PassportRequest passportRequest) {
        return ResponseEntity.ok(authService.getPassport(passportRequest));
    }
}
