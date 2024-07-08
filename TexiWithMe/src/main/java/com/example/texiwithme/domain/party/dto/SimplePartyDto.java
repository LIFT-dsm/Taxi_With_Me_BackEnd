package com.example.texiwithme.domain.party.dto;

import com.example.texiwithme.domain.party.model.Party;

import java.util.Date;

public record SimplePartyDto(
        Long partyId,
        String partyName,
        Date startAt,
        Date endAt,
        String leader
) {
    public static SimplePartyDto of(Party party) {
        return new SimplePartyDto(party.getPartyId(), party.getPartyName(), party.getStartAt(), party.getEndAt(), party.getLeader().getNickname());
    }
}
