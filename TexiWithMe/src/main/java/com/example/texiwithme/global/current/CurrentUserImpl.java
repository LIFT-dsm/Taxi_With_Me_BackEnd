package com.example.texiwithme.global.current;

import com.example.texiwithme.domain.user.exception.UserNotExists;
import com.example.texiwithme.domain.user.model.User;
import com.example.texiwithme.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentUserImpl implements CurrentUser {
    private final UserRepository userRepository;

    @Override
    public User get() {
        var name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByNickname(name)
                .orElseThrow(() -> UserNotExists.EXCEPTION);
    }
}
