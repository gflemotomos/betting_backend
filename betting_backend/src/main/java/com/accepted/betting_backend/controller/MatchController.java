package com.accepted.betting_backend.controller;

import com.accepted.betting_backend.domain.Match;
import com.accepted.betting_backend.domain.MatchOdds;
import com.accepted.betting_backend.exception.NotFoundException;
import com.accepted.betting_backend.service.MatchOddsService;
import com.accepted.betting_backend.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    private final MatchOddsService matchOddsService;

    @Autowired
    public MatchController(MatchService matchService, MatchOddsService matchOddsService) {
        this.matchService = matchService;
        this.matchOddsService = matchOddsService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Match> searchById(@PathVariable("id") long id) {

        Match match = matchService.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found match with id = " + id));

        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Match> addMatch(@RequestBody Match match) {
        matchService.addMatch(match);
        return ResponseEntity.ok().body(match);
    }

    @PutMapping
    public ResponseEntity<Match> updateMatch(@RequestBody Match match) {
        matchService.updateMatch(match);
        return ResponseEntity.ok().body(match);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteMatch(@PathVariable("id") long id) {
        matchService.deleteMatchById(id);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping(value = "/odds/{id}")
    public ResponseEntity<MatchOdds> searchOddsById(@PathVariable("id") long id) {

        MatchOdds matchOdds = matchOddsService.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found match with id = " + id));

        return new ResponseEntity<>(matchOdds, HttpStatus.OK);
    }

    @PostMapping(value = "/odds")
    public ResponseEntity<MatchOdds> addOdds(@RequestBody MatchOdds matchOdds) {
        matchOddsService.addMatchOdd(matchOdds);
        return ResponseEntity.ok().body(matchOdds);
    }

    @PutMapping(value = "odds")
    public ResponseEntity<MatchOdds> updateOdds(@RequestBody MatchOdds matchOdds) {
        matchOddsService.updateMatchOdd(matchOdds);
        return ResponseEntity.ok().body(matchOdds);
    }


    @DeleteMapping(value = "/odds/{id}")
    public ResponseEntity<Long> deleteOdds(@PathVariable("id") long id) {
        matchOddsService.deleteMatchOddById(id);
        return ResponseEntity.ok().body(id);
    }

}
