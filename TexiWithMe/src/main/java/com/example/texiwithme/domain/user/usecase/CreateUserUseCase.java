package com.example.texiwithme.domain.user.usecase;

import com.example.texiwithme.domain.user.dto.request.SignupRequestDto;

public interface CreateUserUseCase {
    void create(SignupRequestDto signupRequestDto);
}
