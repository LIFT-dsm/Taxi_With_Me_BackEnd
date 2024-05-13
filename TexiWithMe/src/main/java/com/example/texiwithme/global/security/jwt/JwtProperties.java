package com.example.texiwithme.global.security.jwt;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private final String prefix;
    private final String header;
    private final String secret;
    private final Long accessExpiration;
    private final Long refreshExpiration;

}
