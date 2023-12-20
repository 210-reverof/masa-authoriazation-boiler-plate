package com.boilerplate.userservice.global.error;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;

    public CustomException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
