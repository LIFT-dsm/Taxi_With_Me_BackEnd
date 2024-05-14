package com.example.texiwithme.global.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
        String prefix,
        String header,
        String secret,
        Long accessExpiration,
        Long refreshExpiration
) {
}
