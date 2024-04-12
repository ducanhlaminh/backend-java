package com.example.foooball_app.service;

import com.example.foooball_app.dto.request.Match_TeamRequest;
import com.example.foooball_app.entity.Match;
import com.example.foooball_app.entity.Match_Teams;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.repository.MatchRepository;
import com.example.foooball_app.repository.Match_TeamRepository;
import com.example.foooball_app.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Match_TeamService {
    @Autowired
    private Match_TeamRepository match_teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Match_Teams createMatch_TeamService(Match_TeamRequest req){
        Match_Teams match_teams = new Match_Teams();
        match_teams.setType(req.getType());

        Optional<Team> optionalTeam = teamRepository.findById(req.getTeam_team_id());
        if(optionalTeam.isPresent()){
            match_teams.setTeam(optionalTeam.get());
        }

        Optional<Match> optionalMatch = matchRepository.findById(req.getMatch_match_id());
        if(optionalMatch.isPresent()){
            match_teams.setMatch(optionalMatch.get());
        }

        return match_teamRepository.save(match_teams);
    }

    public List<Match_Teams> getMatchTeams(){
        return match_teamRepository.findAll();
    }

    public Match_Teams getMatchTeam(int id){
        return match_teamRepository.findById(id).orElseThrow();
    }

    public Match_Teams updateMatchTeam(int id, Match_TeamRequest req){
        Match_Teams match_teams = getMatchTeam(id);
        match_teams.setType(req.getType());

        Optional<Team> optionalTeam = teamRepository.findById(req.getTeam_team_id());
        if(optionalTeam.isPresent()){
            match_teams.setTeam(optionalTeam.get());
        }

        Optional<Match> optionalMatch = matchRepository.findById(req.getMatch_match_id());
        if(optionalMatch.isPresent()){
            match_teams.setMatch(optionalMatch.get());
        }

        return match_teamRepository.save(match_teams);
    }

    public void deleteMatch_Team(int id){
        match_teamRepository.deleteById(id);
    }
}
