package com.accepted.betting_backend.service;

import com.accepted.betting_backend.domain.Match;

import java.util.Optional;

public interface MatchService {

    Optional<Match> findById(Long id);

    void addMatch(Match match);

    void deleteMatchById(Long id);

    void updateMatch(Match match);
}
