package com.example.texiwithme.global.security.jwt;

import com.example.texiwithme.global.security.auth.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;
    private final CustomUserDetailsService customUserDetailsService;

    public String generateAccess(String nickname, Long userId) {
        // 만료시간 계산
        long now = (new Date()).getTime();
        Date expiredAt = (new Date(now + jwtProperties.getAccessExpiration()));

        return Jwts.builder()
                .setSubject(nickname)
                .claim("type", "access")
                .claim("user_id", userId)
                .setExpiration(expiredAt)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();
    }

    public String generateRefresh(String nickname, Long user_id) {

        long now = (new Date()).getTime();
        Date expriredAt = (new Date(now + jwtProperties.getRefreshExpiration()));

        return Jwts.builder()
                .setSubject(nickname)
                .claim("user_id", user_id)
                .setExpiration(expriredAt)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.getPrefix())
            && bearerToken.length() > jwtProperties.getPrefix().length() + 1) {
            return bearerToken.substring(8);
        }

        return null;
    }
}
