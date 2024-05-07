package com.example.texiwithme.domain.user.service;

import com.example.texiwithme.domain.user.dto.request.SignupRequestDto;
import com.example.texiwithme.domain.user.exception.EnumTypeNotExists;
import com.example.texiwithme.domain.user.exception.UserAlreadyExists;
import com.example.texiwithme.domain.user.model.Gender;
import com.example.texiwithme.domain.user.model.User;
import com.example.texiwithme.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void create(SignupRequestDto signupRequestDto) {
        final int studentId = signupRequestDto.studentId();
        final String name = signupRequestDto.name();
        final String gender = signupRequestDto.gender();
        final String nickname = signupRequestDto.nickname();
        final String password = passwordEncoder.encode(signupRequestDto.password());

        // 이미 존재하는 닉네임/학번인가?
        if (userRepository.existsByStudentIdOrNickname(studentId, nickname)) {
            throw UserAlreadyExists.EXCEPTION;
        }

        // Gender Type이 Enum에 있는 값이 아닌가?
        Gender genderType;
        try {
            genderType = Gender.valueOf(gender);
        } catch (Exception e) {
            throw EnumTypeNotExists.EXCEPTION;
        }

        userRepository.save(User.builder()
                        .studentId(studentId)
                        .name(name)
                        .nickname(nickname)
                        .password(password)
                        .gender(genderType)
                        .build());
    }
}
