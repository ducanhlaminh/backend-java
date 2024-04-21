package com.example.foooball_app.dto.request;

import java.util.Date;

public class CreateMatchRequest {
    private int tournament_id;
    private String stadium;
    private int teamIdWin;
    private Date matchDate;
    private int homeTeam ;
    private int awayTeam;

    public int getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(int tournament_id) {
        this.tournament_id = tournament_id;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public int getTeamIdWin() {
        return teamIdWin;
    }

    public void setTeamIdWin(int teamIdWin) {
        this.teamIdWin = teamIdWin;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public int getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }
}
