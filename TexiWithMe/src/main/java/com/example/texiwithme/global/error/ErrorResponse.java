package com.example.texiwithme.global.error;

import com.example.texiwithme.global.error.exception.ErrorCode;

import java.time.LocalDateTime;

public record ErrorResponse(
        int statusCode,
        String statusMessage,
        String description,
        LocalDateTime timeStamp
) {
    public static ErrorResponse of (ErrorCode errorCode, String description) {
        return new ErrorResponse(errorCode.getStatusCode(), errorCode.getMessage(), description, LocalDateTime.now());
    }
}
