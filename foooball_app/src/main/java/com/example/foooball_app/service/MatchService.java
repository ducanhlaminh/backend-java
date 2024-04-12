package com.example.foooball_app.service;

import com.example.foooball_app.entity.Match;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.repository.MatchRepository;
import com.example.foooball_app.repository.TeamRepository;
import com.example.foooball_app.repository.TournamentRepository;
import com.example.foooball_app.dto.request.MatchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Match createMatchService(MatchRequest req){
        Match match = new Match();
        match.setMatchDate(req.getMatchDate());
        match.setStadium(req.getStadium());
        match.setResult(req.getResult());

        Optional<Tournament> optionalTournament = tournamentRepository.findById(req.getTournament_id());
        if(optionalTournament.isPresent()){
            match.setTournament(optionalTournament.get());
        }

        return matchRepository.save(match);
    }

    public List<Match> getMatches(){
        return matchRepository.findAll();
    }

    public Match getMatch(int id){
        return matchRepository.findById(id).orElseThrow();
    }

    public Match updateMatch(int matchId, MatchRequest req){
        Match match = getMatch(matchId);
        match.setMatchDate(req.getMatchDate());
        match.setStadium(req.getStadium());
        match.setResult(req.getResult());

        Optional<Tournament> optionalTournament = tournamentRepository.findById(req.getTournament_id());
        if(optionalTournament.isPresent()){
            match.setTournament(optionalTournament.get());
        }

        return matchRepository.save(match);

    }

    public void deleteMatch(int id){
        matchRepository.deleteById(id);
    }
}
