package com.example.texiwithme.global.error;

import com.example.texiwithme.global.error.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String statusMessage;
    private String description;
    private LocalDateTime timeStamp;

    // 기본적인 에러 Json 형식
    public static ErrorResponse of (ErrorCode errorCode, String description) {
        return ErrorResponse.builder()
                .statusCode(errorCode.getStatusCode())
                .statusMessage(errorCode.getMessage())
                .description(description)
                .timeStamp(LocalDateTime.now())
                .build();
    }

}
