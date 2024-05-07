package com.example.texiwithme.domain.user.service;

import com.example.texiwithme.domain.user.dto.request.SignupRequestDto;

public interface CreateUserService {
    void create(SignupRequestDto signupRequestDto);
}
