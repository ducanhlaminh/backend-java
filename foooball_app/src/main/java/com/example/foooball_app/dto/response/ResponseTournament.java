package com.example.foooball_app.dto.response;

import java.util.Date;

public class ResponseTournament {
    private int tournamentId;

    private String tournamentName;

    private Date startDate;

    private Date endDate;

    private int numOfTeam;

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getNumOfTeam() {
        return numOfTeam;
    }

    public void setNumOfTeam(int numOfTeam) {
        this.numOfTeam = numOfTeam;
    }
}
