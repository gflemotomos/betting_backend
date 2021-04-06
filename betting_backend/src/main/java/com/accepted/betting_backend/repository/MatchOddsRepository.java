package com.accepted.betting_backend.repository;

import com.accepted.betting_backend.domain.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long> {
}
