package com.boilerplate.userservice.user.exception;

import com.boilerplate.userservice.global.error.CustomException;
import com.boilerplate.userservice.global.error.ErrorCode;

public class InvalidLoginException extends CustomException {

    public InvalidLoginException(String message) {
        super(ErrorCode.INVALID_LOGIN, message);

    }
}
