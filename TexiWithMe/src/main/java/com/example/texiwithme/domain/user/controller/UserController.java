package com.example.texiwithme.domain.user.controller;

import com.example.texiwithme.domain.user.dto.request.SignupRequestDto;
import com.example.texiwithme.domain.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Controller
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/user/signup")
    public ResponseEntity<Object> signup (@RequestBody SignupRequestDto signupRequestDto) {
        userService.createUser(signupRequestDto);

        return ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .build();
    }
}
