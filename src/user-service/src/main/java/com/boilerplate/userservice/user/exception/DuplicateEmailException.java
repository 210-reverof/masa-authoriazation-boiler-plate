package com.boilerplate.userservice.user.exception;

import com.boilerplate.userservice.global.error.CustomException;
import com.boilerplate.userservice.global.error.ErrorCode;

public class DuplicateEmailException extends CustomException {

    public DuplicateEmailException(String message) {
        super(ErrorCode.DUPLICATE_EMAIL, message);

    }
}
