package com.example.texiwithme.domain.user.service;

import com.example.texiwithme.domain.user.dto.request.LoginRequestDto;
import com.example.texiwithme.domain.user.dto.respond.LoginRespondDto;

public interface LoginService {
    LoginRespondDto login(LoginRequestDto loginRequestDto);
}
