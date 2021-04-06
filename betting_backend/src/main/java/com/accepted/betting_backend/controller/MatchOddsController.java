package com.accepted.betting_backend.controller;

import com.accepted.betting_backend.domain.MatchOdds;
import com.accepted.betting_backend.exception.NotFoundException;
import com.accepted.betting_backend.service.MatchOddsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matchOdds")
public class MatchOddsController {
    MatchOddsService matchOddsService;

    @Autowired
    public MatchOddsController(MatchOddsService matchService) {
        this.matchOddsService = matchService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MatchOdds> searchById(@PathVariable("id") long id) {

        MatchOdds matchOdds = matchOddsService.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found match with id = " + id));

        return new ResponseEntity<>(matchOdds, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MatchOdds> addMatch(@RequestBody MatchOdds matchOdds) {
        matchOddsService.addMatchOdd(matchOdds);
        return ResponseEntity.ok().body(matchOdds);
    }

    @PutMapping
    public ResponseEntity<MatchOdds> updateMatch(@RequestBody MatchOdds matchOdds) {
        matchOddsService.updateMatchOdd(matchOdds);
        return ResponseEntity.ok().body(matchOdds);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteMatch(@PathVariable("id") long id) {
        matchOddsService.deleteMatchOddById(id);
        return ResponseEntity.ok().body(id);
    }
}
