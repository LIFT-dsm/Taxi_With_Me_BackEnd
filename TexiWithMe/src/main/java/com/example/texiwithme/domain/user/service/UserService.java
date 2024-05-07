package com.example.texiwithme.domain.user.service;

import com.example.texiwithme.domain.user.dto.request.SignupRequestDto;

public interface UserService {
    void createUser(SignupRequestDto signupRequestDto);
}
