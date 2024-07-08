package com.example.texiwithme.domain.party.repository;

import com.example.texiwithme.domain.party.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyJpaRepository extends JpaRepository<Party, Long> {
    void deleteByPartyId(Long partyId);

}
