package com.example.texiwithme.domain.party.service;

import com.example.texiwithme.domain.party.dto.FullPartyResponse;
import com.example.texiwithme.domain.party.dto.SimplePartyDto;
import com.example.texiwithme.domain.party.repository.PartyRepository;
import com.example.texiwithme.domain.party.usecase.FindPartyUseCase;
import com.example.texiwithme.global.util.PagingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindPartyService implements FindPartyUseCase {
    private final PartyRepository partyRepository;

    @Override
    public PagingResult<SimplePartyDto> findAll(Integer page) {
        var result = partyRepository.findAll(PageRequest.of(page, 15));
        var data = result.get()
                .map(SimplePartyDto::of)
                .toList();

        return new PagingResult<>(data, data.size(),  result.getTotalPages() <= page + 1);
    }

    @Override
    public FullPartyResponse findOne(Long partyId) {
        return partyRepository.findById(partyId)
                .map(FullPartyResponse::of)
                .orElseThrow();
    }
}
