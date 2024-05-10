package com.example.texiwithme.domain.user.dto.request;

public record LoginRequestDto(
        String nickname,
        String password
) {
}
