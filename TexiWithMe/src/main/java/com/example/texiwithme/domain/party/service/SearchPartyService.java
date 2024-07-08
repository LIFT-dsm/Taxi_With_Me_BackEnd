package com.example.texiwithme.domain.party.service;

import com.example.texiwithme.domain.party.dto.SimplePartyDto;
import com.example.texiwithme.domain.party.repository.PartyRepository;
import com.example.texiwithme.domain.party.usecase.SearchPartyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchPartyService implements SearchPartyUseCase {
    private final PartyRepository partyRepository;

    @Override
    public List<SimplePartyDto> search(String keyword) {
        return partyRepository.search(keyword)
                .map(SimplePartyDto::of)
                .toList();
    }
}
