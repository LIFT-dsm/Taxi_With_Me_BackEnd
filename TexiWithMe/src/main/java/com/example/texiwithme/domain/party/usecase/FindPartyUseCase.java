package com.example.texiwithme.domain.party.usecase;

import com.example.texiwithme.domain.party.dto.FullPartyResponse;
import com.example.texiwithme.domain.party.dto.SimplePartyDto;
import com.example.texiwithme.global.util.PagingResult;

public interface FindPartyUseCase {
    PagingResult<SimplePartyDto> findAll(Integer page);
    FullPartyResponse findOne(Long partyId);
}
