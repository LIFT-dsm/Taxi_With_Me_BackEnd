package com.example.texiwithme.domain.party.usecase;

import com.example.texiwithme.domain.party.dto.SimplePartyDto;

import java.util.List;

public interface SearchPartyUseCase {
    List<SimplePartyDto> search(String keyword);
}
