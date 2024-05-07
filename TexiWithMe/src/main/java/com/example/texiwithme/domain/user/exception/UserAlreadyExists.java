package com.example.texiwithme.domain.user.exception;

import com.example.texiwithme.global.error.exception.BusinessException;
import com.example.texiwithme.global.error.exception.ErrorCode;

public class UserAlreadyExists extends BusinessException {

    public static final UserAlreadyExists EXCEPTION = new UserAlreadyExists();

    public UserAlreadyExists() { super(ErrorCode.USER_ALREADY_EXISTS); }
}
