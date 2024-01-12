package com.boilerplate.userservice.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "U-0000" ),
    DUPLICATE_EMAIL(400, "U-0001"),
    NOT_FOUND_USER(400, "U-0002"),
    INVALID_LOGIN(400, "U-0003");

    private final int status;
    private final String code;
}
