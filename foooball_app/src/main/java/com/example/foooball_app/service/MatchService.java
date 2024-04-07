package com.example.foooball_app.service;

import com.example.foooball_app.entity.Match;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.repository.MatchRepository;
import com.example.foooball_app.request.MatchCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public Match createMatchService(MatchCreateRequest req){
        Match match = new Match();
        match.setMatchDate(req.getMatchDate());
        match.setStadium(req.getStadium());
        match.setResult(req.getResult());
        match.setTournamentId(req.getTournament_id());
        match.setHomeTeamId(req.getHome_team_id());
        match.setAwayTeamId(req.getAway_team_id());

//        List<Match> matches = new ArrayList<Match>();
//        matches.add(match);

//        Tournament tournament = new Tournament();
//        tournament.setMatches(matches);
//        match.setTournament(tournament);

        return matchRepository.save(match);
    }

    public List<Match> getMatches(){
        return matchRepository.findAll();
    }
}
