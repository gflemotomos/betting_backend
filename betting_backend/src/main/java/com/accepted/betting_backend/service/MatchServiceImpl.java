package com.accepted.betting_backend.service;

import com.accepted.betting_backend.domain.Match;
import com.accepted.betting_backend.exception.NotFoundException;
import com.accepted.betting_backend.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    MatchRepository matchRepository;

    @Autowired
    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Optional<Match> findById(Long id) throws NotFoundException {
        return Optional.ofNullable(matchRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found match with id = " + id)));
    }

    @Override
    public void addMatch(Match match) {
        matchRepository.save(match);
    }

    @Override
    public void deleteMatchById(Long id) throws NotFoundException {
        if (matchRepository.existsById(id)) {
            matchRepository.deleteById(id);
        } else {
            throw new NotFoundException("Not found match with id = " + id);
        }

    }

    @Override
    public void updateMatch(Match match) throws NotFoundException {
        if (matchRepository.existsById(match.getId())) {
            matchRepository.save(match);
        } else {
            throw new NotFoundException("Not found match with id = " + match.getId());
        }

    }
}
