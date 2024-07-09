package com.example.texiwithme.domain.user.service;

import com.example.texiwithme.domain.user.exception.UserNotExists;
import com.example.texiwithme.domain.user.model.User;
import com.example.texiwithme.domain.user.repository.UserRepository;
import com.example.texiwithme.domain.user.usecase.DeleteUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserServiceImpl implements DeleteUserUseCase {

    private final UserRepository userRepository;

    @Override
    public void deleteUser(Authentication authentication) {
        User user = userRepository.findByNickname(authentication.getName()).orElseThrow(
                () -> UserNotExists.EXCEPTION
        );

        userRepository.deleteById(user.getUserId());
    }
}
