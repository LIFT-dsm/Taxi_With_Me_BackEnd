package com.example.texiwithme.domain.user.dto.respond;

import java.util.Date;

public record LoginRespondDto(
        String access_token,
        String refresh_token,
        String access_expire_at,
        String refresh_expire_at
) {
}
