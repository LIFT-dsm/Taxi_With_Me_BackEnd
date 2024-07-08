package com.example.texiwithme.domain.party.repository;

import com.example.texiwithme.domain.party.model.Party;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface PartyRepository {
    Party save(Party party);
    void deleteById(Long partyId);
    Optional<Party> findById(Long partyId);
    Page<Party> findAll(Pageable pageable);
    Stream<Party> search(String keyword);

}
