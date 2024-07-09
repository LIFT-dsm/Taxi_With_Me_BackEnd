package com.example.texiwithme.domain.user.usecase;

import org.springframework.security.core.Authentication;

public interface DeleteUserUseCase {
    void deleteUser (Authentication authentication);
}
