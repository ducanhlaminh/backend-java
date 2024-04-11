package com.example.foooball_app.service;
import java.util.List;

import com.example.foooball_app.entity.Sponsorship;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.SponsorShipRepository;
import com.example.foooball_app.repository.TeamRepository;
import com.example.foooball_app.dto.request.TeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
@Service
public class TeamService {
    @Autowired
    private TeamRepository TeamRepository;
    @Autowired
    private SponsorShipRepository SponsorShipRepository;
    public List<Team> getTeamWithService(String country , String teamName){
        List<Team> listTeam;
         listTeam = TeamRepository.findAll();
         return filter(listTeam,country,teamName) ;
    }
    public List<Sponsorship> getSponsorOfTeam(int team_id){
        List<Sponsorship> listSponsorOfTeam;
        listSponsorOfTeam = SponsorShipRepository.findAllByTeamId(team_id);
        return listSponsorOfTeam ;
    }
    public Team createTeamService(TeamRequest req) {
        Team team = new Team();
        team.setTeamName(req.getTeamName());
        team.setCountry(req.getCountry());
        team.setCoach_id(req.getCoach_id());


        if(TeamRepository.existsByTeamName(team.getTeamName())) {
            throw new AppError(ErrorCode.USER_EXISTED);
        }
        return TeamRepository.save(team);
    }
    public List<Team> filter(List<Team> teams,String country, String teamName) {
        List<Team> filteredTeams;
        filteredTeams = teams.stream()
                .filter(team -> (country == null || team.getCountry().toLowerCase().equals(country)))
                .filter(team -> (teamName == null || team.getTeamName().toLowerCase().equals(teamName)))
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
            TeamRepository.findById(id).orElseThrow(()-> new AppError(ErrorCode.USER_UNEXISTED));
            TeamRepository.deleteById(id);
            return true;

    }

}
