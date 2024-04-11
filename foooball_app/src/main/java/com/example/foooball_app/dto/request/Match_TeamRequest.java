package com.example.foooball_app.dto.request;

public class Match_TeamRequest {
    private String type;

    private int match_match_id;

    private int team_team_id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMatch_match_id() {
        return match_match_id;
    }

    public void setMatch_match_id(int match_match_id) {
        this.match_match_id = match_match_id;
    }

    public int getTeam_team_id() {
        return team_team_id;
    }

    public void setTeam_team_id(int team_team_id) {
        this.team_team_id = team_team_id;
    }
}
