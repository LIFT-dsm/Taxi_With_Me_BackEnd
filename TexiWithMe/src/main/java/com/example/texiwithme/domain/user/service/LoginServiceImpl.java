package com.example.texiwithme.domain.user.service;

import com.example.texiwithme.domain.user.dto.request.LoginRequestDto;
import com.example.texiwithme.domain.user.dto.respond.LoginRespondDto;
import com.example.texiwithme.domain.user.exception.PasswordNotMatches;
import com.example.texiwithme.domain.user.exception.UserNotExists;
import com.example.texiwithme.domain.user.model.User;
import com.example.texiwithme.domain.user.repository.UserRepository;
import com.example.texiwithme.domain.user.usecase.LoginUseCase;
import com.example.texiwithme.global.security.jwt.JwtProperties;
import com.example.texiwithme.global.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProperties jwtProperties;
    private final JwtProvider jwtProvider;

    @Override
    public LoginRespondDto login(LoginRequestDto loginRequestDto) {
        String nickname = loginRequestDto.nickname();
        String password = loginRequestDto.password();

        User user = userRepository.findByNickname(nickname).orElseThrow(() -> UserNotExists.EXCEPTION);

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw PasswordNotMatches.EXCEPTION;
        }

        String access_token = jwtProvider.generateAccess(nickname, user.getUserId());
        String refresh_token = jwtProvider.generateRefresh(nickname, user.getUserId());

        Long now = (new Date()).getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String access_expired_At = dateFormat.format(new Date(now + jwtProperties.accessExpiration()));
        String refresh_expired_At = dateFormat.format(new Date(now + jwtProperties.refreshExpiration()));

        return new LoginRespondDto(access_token, refresh_token, access_expired_At, refresh_expired_At);
    }
}
