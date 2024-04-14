package com.example.foooball_app.dto.request;

import jakarta.validation.constraints.Pattern;

public class RequestTeemToTournament {
    private int team_id;
    private int tournament_id;

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(int tournament_id) {
        this.tournament_id = tournament_id;
    }
}