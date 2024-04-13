package com.example.foooball_app.service;

import com.example.foooball_app.dto.request.RakingRequest;
import com.example.foooball_app.entity.Ranking;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.RankingRepository;
import com.example.foooball_app.repository.TeamRepository;
import com.example.foooball_app.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RakingService {
    @Autowired
    private RankingRepository rankingRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Ranking createRanking(RakingRequest req){
        Ranking ranking = new Ranking();
        ranking.setPoints(req.getPoints());

        Optional<Team> optionalTeam = teamRepository.findById(req.getTeam_id());
        if(optionalTeam.isPresent()){
            ranking.setTeam(optionalTeam.get());
        }

        Optional<Tournament> optionalTournament = tournamentRepository.findById(req.getTournament_id());
        if(optionalTournament.isPresent()){
            ranking.setTournament(optionalTournament.get());
        }

        return rankingRepository.save(ranking);
    }

    public List<Tournament> getRankings(String tournament_id){
        if(tournament_id == null){
            return tournamentRepository.findAll();
        }
        else{
            Tournament tournament = tournamentRepository.findById(Integer.valueOf(tournament_id)).orElseThrow();
            List<Tournament> tournaments = new ArrayList<>();
            tournaments.add(tournament);
            return tournaments;
        }
    }

    public Ranking updateRanking(RakingRequest req){
        Ranking ranking = rankingRepository.findByTournamentTournamentIdAndTeamTeamId(req.getTournament_id(), req.getTeam_id());
        ranking.setPoints(ranking.getPoints() + req.getPoints());
        return rankingRepository.save(ranking);
    }
}
