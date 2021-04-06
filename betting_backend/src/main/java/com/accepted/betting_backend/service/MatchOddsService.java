package com.accepted.betting_backend.service;

import com.accepted.betting_backend.domain.MatchOdds;

import java.util.Optional;

public interface MatchOddsService {

    Optional<MatchOdds> findById(Long id);

    void addMatchOdd(MatchOdds matchOdds);

    void deleteMatchOddById(Long id);

    void updateMatchOdd(MatchOdds matchOdds);
}
