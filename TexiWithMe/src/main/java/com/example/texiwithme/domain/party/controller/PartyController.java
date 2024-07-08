package com.example.texiwithme.domain.party.controller;

import com.example.texiwithme.domain.party.dto.CreatePartyDto;
import com.example.texiwithme.domain.party.dto.FullPartyResponse;
import com.example.texiwithme.domain.party.dto.SimplePartyDto;
import com.example.texiwithme.domain.party.usecase.CreatePartyUseCase;
import com.example.texiwithme.domain.party.usecase.DeletePartyUseCase;
import com.example.texiwithme.domain.party.usecase.FindPartyUseCase;
import com.example.texiwithme.domain.party.usecase.SearchPartyUseCase;
import com.example.texiwithme.global.security.jwt.JwtProperties;
import com.example.texiwithme.global.util.PagingResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/party")
public class PartyController {
    private final CreatePartyUseCase createPartyUseCase;
    private final FindPartyUseCase findPartyUseCase;
    private final SearchPartyUseCase searchPartyUseCase;
    private final DeletePartyUseCase deletePartyUseCase;

    @PostMapping
    public void create(@RequestBody CreatePartyDto createPartyDto) {
        createPartyUseCase.create(createPartyDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deletePartyUseCase.delete(id);
    }

    @GetMapping("/{id}")
    public FullPartyResponse getOne(@PathVariable Long id) {
        return findPartyUseCase.findOne(id);
    }

    @GetMapping("/search")
    public List<SimplePartyDto> search(@RequestParam String keyword) {
        return searchPartyUseCase.search(keyword);
    }

    @GetMapping
    public PagingResult<SimplePartyDto> findAll(@RequestParam Integer page) {
        return findPartyUseCase.findAll(page);
    }
}
