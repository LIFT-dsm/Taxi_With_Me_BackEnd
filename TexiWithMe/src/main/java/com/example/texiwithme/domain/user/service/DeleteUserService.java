package com.example.texiwithme.domain.user.service;

import org.springframework.security.core.Authentication;

public interface DeleteUserService {
    void deleteUser (Authentication authentication);
}
