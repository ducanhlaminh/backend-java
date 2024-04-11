package com.example.foooball_app.request;

import java.util.Date;

public class MatchRequest {
    private Date matchDate;

    private String stadium;

    private String result;

    private int tournament_id;

    private int home_team_id;

    private int away_team_id;


    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(int tournament_id) {
        this.tournament_id = tournament_id;
    }

    public int getHome_team_id() {
        return home_team_id;
    }

    public void setHome_team_id(int home_team_id) {
        this.home_team_id = home_team_id;
    }

    public int getAway_team_id() {
        return away_team_id;
    }

    public void setAway_team_id(int away_team_id) {
        this.away_team_id = away_team_id;
    }
}
