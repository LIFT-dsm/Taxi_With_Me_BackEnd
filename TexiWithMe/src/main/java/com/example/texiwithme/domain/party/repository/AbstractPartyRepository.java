package com.example.texiwithme.domain.party.repository;

import com.example.texiwithme.domain.party.model.Party;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractPartyRepository implements PartyRepository {
    private final PartyJpaRepository repository;

    @Override
    public Party save(Party party) {
        return repository.save(party);
    }

    @Override
    public void deleteById(Long partyId) {
        repository.deleteByPartyId(partyId);
    }

    @Override
    public Optional<Party> findById(Long partyId) {
        return repository.findById(partyId);
    }

    @Override
    public Page<Party> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
