package com.example.texiwithme.domain.party.dto;

import java.util.Date;

public record CreatePartyDto(
        String partyName,
        Date startDate,
        Date endDate,
        String destination
) {
}
