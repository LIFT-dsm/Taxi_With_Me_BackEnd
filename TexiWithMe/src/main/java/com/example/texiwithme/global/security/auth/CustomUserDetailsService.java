package com.example.texiwithme.global.security.auth;

import com.example.texiwithme.domain.user.model.User;
import com.example.texiwithme.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nickname) {
        User user = userRepository.findByNickname(nickname).orElseThrow();

        return new CustomUserDetails(user.getNickname());
    }
}
