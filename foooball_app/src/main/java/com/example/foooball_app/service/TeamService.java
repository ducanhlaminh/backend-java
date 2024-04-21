package com.example.foooball_app.service;
import java.util.ArrayList;
import java.util.List;

import com.example.foooball_app.entity.*;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.*;

import com.example.foooball_app.dto.request.TeamRequest;
import com.example.foooball_app.dto.request.RequestTeemToTournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
@Service
public class TeamService {
    @Autowired
    private TeamRepository TeamRepository;
    @Autowired
    private CoachRepository CoachRepository;
    @Autowired
    private SponsorShipRepository SponsorShipRepository;
    @Autowired
    private TournamentTeamRepository TournamentTeamRepository;
    @Autowired
    private TournamentRepository TournamentRepository;
    @Autowired
    private RankingRepository RankingRepository;
    @Autowired
    private RankingTeamRepository RankingTeamRepository;

    public List<Team> getTeamWithService(String country , String teamName){
        List<Team> listTeam;
        listTeam = TeamRepository.findAll();
        return filter(listTeam,country,teamName) ;
    }
    public Sponsorship getSponsorOfTeam(int team_id){
        Sponsorship listSponsorOfTeam;
        listSponsorOfTeam = SponsorShipRepository.findById(team_id).orElseThrow(()-> new AppError(ErrorCode.USER_EXISTED));
        return listSponsorOfTeam ;
    }

    public Tournament createTeamToTournament(RequestTeemToTournament req) {
        TournamentTeam tournamentTeamCheck = TournamentTeamRepository.findByTournamentTournamentIdAndTeamsTeamId(req.getTournament_id(), req.getTeam_id());
        if(tournamentTeamCheck != null){
            throw new AppError(ErrorCode.TOURNAMENT_TEAM_EXISTED);
        }
        Tournament tournament = TournamentRepository.findById(req.getTournament_id()).orElseThrow();
        Team team = TeamRepository.findById(req.getTeam_id()).orElseThrow();

        TournamentTeam tournamentTeam = new TournamentTeam();

        tournamentTeam.setTeams(team);
        tournamentTeam.setTournament(tournament);
        TournamentTeamRepository.save(tournamentTeam);

        Ranking ranking = RankingRepository.findByTournamentTournamentId(tournament.getTournamentId());

//
        Ranking_Team rankingTeam = new Ranking_Team();
        rankingTeam.setTeam(team);
        rankingTeam.setRanking(ranking);
        ranking.getRankingTeams().add(rankingTeam);

        RankingRepository.save(ranking);
        RankingTeamRepository.save(rankingTeam);
        return tournament;
    }



    public Team createTeamService(TeamRequest req) {

        if(TeamRepository.existsByTeamName(req.getTeamName())) {
            throw new AppError(ErrorCode.USER_EXISTED);
        }
        Team team = new Team();
        team.setTeamName(req.getTeamName());
        team.setCountry(req.getCountry());
        return TeamRepository.save(team);
    }
    public List<Team> filter(List<Team> teams,String country, String teamName) {
        List<Team> filteredTeams;
        filteredTeams = teams.stream()
                .filter(team -> (country == null || team.getCountry().toLowerCase().equals(country)))
                .filter(team -> (teamName == null || team.getTeamName().toLowerCase().contains(teamName)))
                .collect(Collectors.toList());

        return filteredTeams;
    }
    public Team updateTeam(int id ,TeamRequest teamData ) {
        Team existingTeam = TeamRepository.findById(id).orElseThrow(()-> new AppError(ErrorCode.USER_UNEXISTED));
        if(teamData.getTeamName()!=null) {
            existingTeam.setTeamName(teamData.getTeamName());
        }
        if(teamData.getCountry()!=null) {
            existingTeam.setCountry(teamData.getCountry());
        }
        return TeamRepository.save(existingTeam);
    }
    public boolean deleteTeam(int id  ) {

        Team team =TeamRepository.findById(id).orElseThrow(()-> new AppError(ErrorCode.USER_UNEXISTED));
        TeamRepository.deleteById(team.getTeamId());
        return true;

    }

}
