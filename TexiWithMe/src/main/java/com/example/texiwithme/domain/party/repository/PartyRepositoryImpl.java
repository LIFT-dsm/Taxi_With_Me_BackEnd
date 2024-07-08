package com.example.texiwithme.domain.party.repository;

import com.example.texiwithme.domain.party.model.Party;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public class PartyRepositoryImpl extends AbstractPartyRepository {
    @PersistenceContext
    private EntityManager em;

    public PartyRepositoryImpl(PartyJpaRepository repository) {
        super(repository);
    }

    @Override
    public Stream<Party> search(String keyword) {
        String query = String.format(
                "select p.party_id, p.party_name, p.party_code, p.destination, p.start_at, p.end_at, p.leader " +
                "from party p " +
                "where p.party_name like \'%%%s%%\'", keyword);

        List<Object[]> result = em.createNativeQuery(query).getResultList();

        return result.stream()
                .map(Party::of);
    }
}
