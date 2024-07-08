package com.example.texiwithme.domain.party.service;

import com.example.texiwithme.domain.party.dto.CreatePartyDto;
import com.example.texiwithme.domain.party.model.Party;
import com.example.texiwithme.domain.party.repository.PartyRepository;
import com.example.texiwithme.domain.party.usecase.CreatePartyUseCase;
import com.example.texiwithme.global.current.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreatePartyService implements CreatePartyUseCase {
    private final PartyRepository partyRepository;
    private final CurrentUser currentUser;

    @Override
    public void create(CreatePartyDto request) {
        partyRepository.save(
                Party.fromCreatePartyDto(request, getRandomCode(), currentUser.get())
        );
    }

    private String getRandomCode() {
        return UUID.randomUUID().toString().substring(1, 6);
    }
}
