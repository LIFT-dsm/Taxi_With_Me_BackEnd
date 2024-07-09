package com.example.texiwithme.domain.user.usecase;

import com.example.texiwithme.domain.user.dto.request.LoginRequestDto;
import com.example.texiwithme.domain.user.dto.respond.LoginRespondDto;

public interface LoginUseCase {
    LoginRespondDto login(LoginRequestDto loginRequestDto);
}
