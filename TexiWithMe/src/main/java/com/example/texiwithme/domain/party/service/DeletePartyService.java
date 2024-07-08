package com.example.texiwithme.domain.party.service;

import com.example.texiwithme.domain.party.repository.PartyRepository;
import com.example.texiwithme.domain.party.usecase.DeletePartyUseCase;
import com.example.texiwithme.global.current.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeletePartyService implements DeletePartyUseCase {
    private final PartyRepository partyRepository;
    private final CurrentUser currentUser;

    @Override
    public void delete(Long partyId) {
        var user = currentUser.get();
        var party = partyRepository.findById(partyId)
                .orElseThrow();

        if (!party.getLeader().getUserId().equals(user.getUserId())) {
            throw new RuntimeException();
        }

        partyRepository.deleteById(partyId);
    }
}
