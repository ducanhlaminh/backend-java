package com.example.foooball_app.dto.response;

import java.util.ArrayList;
import java.util.List;

class Team {
    private int teamId;
    private String teamName;

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Team(int teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }
}

public class ResponseTournamentTeams {
    private int tournamentId;
    private List<Team> teams = new ArrayList<>();

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(int teamId , String teamName) {
        Team team = new Team(teamId,teamName);
        this.teams.add(team);
    }
}
