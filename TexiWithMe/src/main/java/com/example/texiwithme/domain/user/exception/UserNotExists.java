package com.example.texiwithme.domain.user.exception;

import com.example.texiwithme.global.error.exception.BusinessException;
import com.example.texiwithme.global.error.exception.ErrorCode;

import java.util.function.Supplier;

public class UserNotExists extends BusinessException {

    public static final UserNotExists EXCEPTION = new UserNotExists();

    public UserNotExists() { super(ErrorCode.USER_NOT_EXISTS); }
}
