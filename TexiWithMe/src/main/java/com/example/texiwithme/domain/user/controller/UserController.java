package com.example.texiwithme.domain.user.controller;

import com.example.texiwithme.domain.user.dto.request.LoginRequestDto;
import com.example.texiwithme.domain.user.dto.request.SignupRequestDto;
import com.example.texiwithme.domain.user.dto.respond.LoginRespondDto;
import com.example.texiwithme.domain.user.service.CreateUserService;
import com.example.texiwithme.domain.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CreateUserService createUserService;
    private  final LoginService loginService;

    @PostMapping("/user/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup (@RequestBody SignupRequestDto signupRequestDto) {
        createUserService.create(signupRequestDto);
    }

    @PostMapping("/user/login")
    public LoginRespondDto login (@RequestBody LoginRequestDto loginRequestDto) {
        return loginService.login(loginRequestDto);
    }
}
