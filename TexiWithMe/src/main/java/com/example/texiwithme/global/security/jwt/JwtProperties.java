package com.example.texiwithme.global.security.jwt;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    private String prefix;
    private String header;
    private String secret;
    private Long accessExpiration;
    private Long refreshExpiration;

}
