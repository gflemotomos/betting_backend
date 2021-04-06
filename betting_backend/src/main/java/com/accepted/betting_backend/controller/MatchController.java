package com.accepted.betting_backend.controller;

import com.accepted.betting_backend.domain.Match;
import com.accepted.betting_backend.exception.NotFoundException;
import com.accepted.betting_backend.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
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

}
