package com.example.texiwithme.domain.party.model;

import com.example.texiwithme.domain.party.dto.CreatePartyDto;
import com.example.texiwithme.domain.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@Entity
@AllArgsConstructor
public class Party {
    @Id
    @Column(name = "party_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partyId;

    @Column(name = "party_name", length = 100)
    private String partyName;

    @Column(name = "party_code", length = 6, unique = true)
    private String partyCode;

    private String destination;

    @Column(name = "start_at")
    private Date startAt;

    @Column(name = "end_at")
    private Date endAt;

    @JoinColumn(name = "leader_id")
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false,
            targetEntity = User.class)
    private User leader;

    protected Party() {}

    private Party(String partyName, String partyCode, String destination, Date startAt, Date endAt, User leader) {
        this.partyName = partyName;
        this.partyCode = partyCode;
        this.destination = destination;
        this.startAt = startAt;
        this.endAt = endAt;
        this.leader = leader;
    }

    public static Party of(Object[] o) {
        return new Party(
                (Long) o[0], // partyId
                (String) o[1], // partyName
                (String) o[2], // partyCode
                (String) o[3], // destination
                (Date) o[4], // startAt
                (Date) o[5], // endAt
                (User) o[6] // leader
        );
    }

    public static Party fromCreatePartyDto(CreatePartyDto req, String code, User leader) {
        return new Party(
                req.partyName(),
                code,
                req.destination(),
                req.startDate(),
                req.endDate(),
                leader
        );
    }
}
