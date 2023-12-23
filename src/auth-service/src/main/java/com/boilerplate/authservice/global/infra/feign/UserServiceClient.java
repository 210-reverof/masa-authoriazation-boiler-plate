package com.boilerplate.authservice.global.infra.feign;

import com.boilerplate.authservice.user.dto.UserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserServiceClient {

    // TODO: UserInfoResponse 공통 모듈로 옮기기
    @GetMapping("/user/{userId}")
    UserInfoResponse getUserInfo(@PathVariable("userId") Long userId);
}
