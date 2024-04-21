package com.example.foooball_app.service;

import com.example.foooball_app.dto.request.CreateMatchRequest;
import com.example.foooball_app.dto.request.updateTeamWinRequest;
import com.example.foooball_app.entity.*;
import com.example.foooball_app.repository.*;
import com.example.foooball_app.dto.request.MatchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private Match_TeamRepository match_teamRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private RankingRepository RankingRepository;
    @Autowired
    private RankingTeamRepository RankingTeamRepository;
    public Match_Teams createMatchService(CreateMatchRequest req){
        Match match = new Match();
        List<Match_Teams> match_teams = new ArrayList<>();
        Optional<Tournament> optionalTournament = tournamentRepository.findById(req.getTournament_id());
        match.setMatchDate(req.getMatchDate());
        match.setStadium(req.getStadium());
        if(optionalTournament.isPresent()){
            match.setTournament(optionalTournament.get());
        }
        Match_Teams match_team_home = new Match_Teams();
        match_team_home.setType("Home");
        Optional<Team> optionalTeamHome = teamRepository.findById(req.getHomeTeam());
        if(optionalTeamHome.isPresent()){
            match_team_home.setTeam(optionalTeamHome.get());
        }

        match_teams.add(match_team_home);


        Match_Teams match_team_away = new Match_Teams();
        match_team_away.setType("Away");
        Optional<Team> optionalTeamAway = teamRepository.findById(req.getAwayTeam());
        if(optionalTeamAway.isPresent()){
            match_team_away.setTeam(optionalTeamAway.get());
        }

        match_teams.add(match_team_away);

        match.setMatch_teams(match_teams);
        match_team_away.setMatch(match);
        match_team_home.setMatch(match);
        matchRepository.save(match);
        match_teamRepository.save(match_team_away);
        return match_teamRepository.save(match_team_home);
    }

    public List<Match> getMatches(){
        return matchRepository.findAll();
    }

    public Match getMatch(int id){
        return matchRepository.findById(id).orElseThrow();
    }

    public Match updateMatch(int matchId, updateTeamWinRequest req){
        Match match = getMatch(matchId);
//        match.setMatchDate(req.getMatchDate());
//        match.setStadium(req.getStadium());
        Optional<Team> optionalTeam = teamRepository.findById(req.getTeanIdWin());
        if(optionalTeam.isPresent()){
            Ranking ranking = RankingRepository.findByTournamentTournamentId(match.getTournament().getTournamentId());

            System.out.println(match.getTeamWin());
//            for (Ranking_Team rankingTeam : ranking.getRankingTeams()){
//                if(rankingTeam.getRankingTeamId() == req.getTeanIdWin()){
//
//                    rankingTeam.setPoint(rankingTeam.getPoint()+3);
//                    RankingTeamRepository.save(rankingTeam);
//                }
//            }

            match.setTeamWin(optionalTeam.get());
        }
//        Optional<Tournament> optionalTournament = tournamentRepository.findById(req.getTournament_id());
//        if(optionalTournament.isPresent()){
//            match.setTournament(optionalTournament.get());
//        }


        return matchRepository.save(match);

    }

    public void deleteMatch(int id){
        matchRepository.deleteById(id);
    }
}
