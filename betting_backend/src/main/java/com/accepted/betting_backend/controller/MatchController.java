package com.accepted.betting_backend.controller;

import com.accepted.betting_backend.domain.Match;
import com.accepted.betting_backend.domain.MatchOdds;
import com.accepted.betting_backend.exception.NotFoundException;
import com.accepted.betting_backend.service.MatchOddsService;
import com.accepted.betting_backend.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Get a match by its id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Match> searchById(@PathVariable("id") long id) {

        Match match = matchService.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found match with id = " + id));

        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @Operation(summary = "Add new match to the schedule")
    @PostMapping
    public ResponseEntity<Match> addMatch(@RequestBody Match match) {
        matchService.addMatch(match);
        return ResponseEntity.ok().body(match);
    }

    @Operation(summary = "Update match info data")
    @PutMapping
    public ResponseEntity<Match> updateMatch(@RequestBody Match match) {
        matchService.updateMatch(match);
        return ResponseEntity.ok().body(match);
    }


    @Operation(summary = "Delete a match by its id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteMatch(@PathVariable("id") long id) {
        matchService.deleteMatchById(id);
        return ResponseEntity.ok().body(id);
    }

    @Operation(summary = "search an odd by its id")
    @GetMapping(value = "/odds/{id}")
    public ResponseEntity<MatchOdds> searchOddsById(@PathVariable("id") long id) {

        MatchOdds matchOdds = matchOddsService.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found match with id = " + id));

        return new ResponseEntity<>(matchOdds, HttpStatus.OK);
    }

    @Operation(summary = "Add an odd to a match")
    @PostMapping(value = "/odds")
    public ResponseEntity<MatchOdds> addOdds(@RequestBody MatchOdds matchOdds) {
        matchOddsService.addMatchOdd(matchOdds);
        return ResponseEntity.ok().body(matchOdds);
    }

    @Operation(summary = "Update odds info")
    @PutMapping(value = "odds")
    public ResponseEntity<MatchOdds> updateOdds(@RequestBody MatchOdds matchOdds) {
        matchOddsService.updateMatchOdd(matchOdds);
        return ResponseEntity.ok().body(matchOdds);
    }


    @Operation(summary = "Delete an odd by its id")
    @DeleteMapping(value = "/odds/{id}")
    public ResponseEntity<Long> deleteOdds(@PathVariable("id") long id) {
        matchOddsService.deleteMatchOddById(id);
        return ResponseEntity.ok().body(id);
    }

}
