package com.example.texiwithme.domain.user.dto.request;

public record SignupRequestDto(
    int studentId,
    String name,
    String nickname,
    String password,
    String gender
) {
}
