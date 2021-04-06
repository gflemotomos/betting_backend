package com.accepted.betting_backend.service;

import com.accepted.betting_backend.domain.MatchOdds;
import com.accepted.betting_backend.exception.NotFoundException;
import com.accepted.betting_backend.repository.MatchOddsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchOddsServiceImpl implements MatchOddsService {

    MatchOddsRepository matchOddsRepository;

    @Autowired
    public MatchOddsServiceImpl(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    @Override
    public Optional<MatchOdds> findById(Long id) {
        return Optional.ofNullable(matchOddsRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found match with id = " + id)));
    }

    @Override
    public void addMatchOdd(MatchOdds matchOdds) {
        matchOddsRepository.save(matchOdds);
    }

    @Override
    public void deleteMatchOddById(Long id) {
        if (matchOddsRepository.existsById(id)) {
            matchOddsRepository.deleteById(id);
        } else {
            throw new NotFoundException("Not found match with id = " + id);
        }
    }

    @Override
    public void updateMatchOdd(MatchOdds matchOdds) {
        if (matchOddsRepository.existsById(matchOdds.getId())) {
            matchOddsRepository.save(matchOdds);
        } else {
            throw new NotFoundException("Not found match with id = " + matchOdds.getId());
        }
    }
}
