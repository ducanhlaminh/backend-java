package com.example.foooball_app.controller;

import com.example.foooball_app.service.TournamentService;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.request.TournamentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.findAll();
    }

    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable Long id) {
        return tournamentService.findById(id);
    }

    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.create(tournament);
    }

    @PutMapping("/{id}")
    public Tournament updateTournament(@PathVariable Long id, @RequestBody Tournament tournament) {
        return tournamentService.update(id, tournament);
    }

    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) {
        tournamentService.delete(id);
    }

    @GetMapping("/filter")
    public List<Tournament> filterTournaments(
            @RequestParam(required = false) String tournamentName,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String team
    ) {
        return tournamentService.filter(tournamentName, startDate, endDate, team);
    }
}
