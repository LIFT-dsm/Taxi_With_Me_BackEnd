package com.example.texiwithme.domain.party.dto;

import com.example.texiwithme.domain.party.model.Party;

import java.util.Date;

public record FullPartyResponse(
        String partyName,
        Date startAt,
        Date endAt,
        String leader,
        String destination
) {
    public static FullPartyResponse of(Party party) {
        return new FullPartyResponse(party.getPartyName(), party.getStartAt(), party.getEndAt(), party.getLeader().getNickname(), party.getDestination());
    }
}
