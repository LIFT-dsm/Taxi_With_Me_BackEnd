package com.example.texiwithme.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // user
    USER_ALREADY_EXISTS(409, "이미 같은 닉네임 또는 학번의 유저가 존재합니다."),
    GENDER_TYPE_DOES_NOT_EXISTS(409, "성별 타입이 존재하지 않습니다."),

    // general
    BAD_REQUEST(400, "잘못된 요청입니다"),
    INTERNAL_SERVER_ERROR(500, "server error");

    private final int statusCode;
    private final String message;
}
