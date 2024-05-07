package com.example.texiwithme.domain.user.exception;

import com.example.texiwithme.global.error.exception.BusinessException;
import com.example.texiwithme.global.error.exception.ErrorCode;

public class EnumTypeNotExists extends BusinessException {

    public static final EnumTypeNotExists EXCEPTION = new EnumTypeNotExists();

    public EnumTypeNotExists() { super(ErrorCode.GENDER_TYPE_DOES_NOT_EXISTS); }
}
