package com.boilerplate.userservice.user.exception;

import com.boilerplate.userservice.global.error.CustomException;
import com.boilerplate.userservice.global.error.ErrorCode;

public class NotFoundUserException extends CustomException {

    public NotFoundUserException(String message) {
        super(ErrorCode.DUPLICATE_EMAIL, message);

    }
}
