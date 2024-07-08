package com.example.texiwithme.domain.party.usecase;

import com.example.texiwithme.domain.party.dto.CreatePartyDto;

public interface CreatePartyUseCase {
    void create(CreatePartyDto request);
}
