package com.example.texiwithme.domain.user.controller;

import com.example.texiwithme.domain.user.dto.request.LoginRequestDto;
import com.example.texiwithme.domain.user.dto.request.SignupRequestDto;
import com.example.texiwithme.domain.user.dto.respond.LoginRespondDto;
import com.example.texiwithme.domain.user.usecase.CreateUserUseCase;
import com.example.texiwithme.domain.user.usecase.DeleteUserUseCase;
import com.example.texiwithme.domain.user.usecase.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final LoginUseCase loginUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @PostMapping("/user/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup (@RequestBody SignupRequestDto signupRequestDto) {
        createUserUseCase.create(signupRequestDto);
    }

    @PostMapping("/user/login")
    public LoginRespondDto login (@RequestBody LoginRequestDto loginRequestDto) {
        return loginUseCase.login(loginRequestDto);
    }

    @DeleteMapping("/user")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAcc (Authentication authentication) {
        deleteUserUseCase.deleteUser(authentication);
    }
}
