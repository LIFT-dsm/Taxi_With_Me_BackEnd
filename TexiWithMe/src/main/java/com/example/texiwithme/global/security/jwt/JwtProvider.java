package com.example.texiwithme.global.security.jwt;

import com.example.texiwithme.global.security.auth.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class JwtProvider implements InitializingBean {
    private final JwtProperties jwtProperties;
    private final CustomUserDetailsService customUserDetailsService;

    private Key key;

    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] KeyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());
        this.key = Keys.hmacShaKeyFor(KeyBytes);
    }

    public String generateAccess(String username, Long user_id) {

        // 만료시간 계산
        long now = (new Date()).getTime();
        Date exprireAt = (new Date(now + jwtProperties.getAccessExpiration()));

        return Jwts.builder()
                .setSubject(username)
                .claim("type", "access")
                .claim("user_id", user_id)
                .setExpiration(exprireAt)
                .signWith(key)
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
                    .setSigningKey(key)
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
