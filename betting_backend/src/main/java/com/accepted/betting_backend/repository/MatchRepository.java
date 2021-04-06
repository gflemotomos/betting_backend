package com.accepted.betting_backend.repository;

import com.accepted.betting_backend.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {

}
