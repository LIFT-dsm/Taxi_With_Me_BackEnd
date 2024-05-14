package com.example.texiwithme.global.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
        String header,
        String prefix,
        String secret,
        Long accessExpiration,
        Long refreshExpiration
) {
}
