package com.example.foooball_app.dto.request;

public class TournamentTeamRequest {
    private int tournamentId;
    private int teamId;
    private boolean addTeam; // set to true for adding a team, false for removing

    // constructor, getters, and setters

    public TournamentTeamRequest(int tournamentId, int teamId, boolean addTeam) {
        this.tournamentId = tournamentId;
        this.teamId = teamId;
        this.addTeam = addTeam;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public boolean isAddTeam() {
        return addTeam;
    }

    public void setAddTeam(boolean addTeam) {
        this.addTeam = addTeam;
    }
}
