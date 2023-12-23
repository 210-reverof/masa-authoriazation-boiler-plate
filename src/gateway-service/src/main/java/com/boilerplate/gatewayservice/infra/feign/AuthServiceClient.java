package com.boilerplate.gatewayservice.infra.feign;

import com.boilerplate.gatewayservice.dto.request.PassportRequest;
import com.boilerplate.gatewayservice.dto.response.PassportResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AUTH-SERVICE")
public interface AuthServiceClient {

    @PostMapping("/auth/passport")
    PassportResponse getPassport(@RequestBody PassportRequest passportRequest);
}
