package com.example.texiwithme.domain.user.exception;

import com.example.texiwithme.global.error.exception.BusinessException;
import com.example.texiwithme.global.error.exception.ErrorCode;

public class PasswordNotMatches extends BusinessException {
    public static final PasswordNotMatches EXCEPTION = new PasswordNotMatches();

    public PasswordNotMatches() {
        super(ErrorCode.PASSWORD_NOT_MATCHES);
    }
}
