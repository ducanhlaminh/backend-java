package com.example.foooball_app.dto.request;

import com.example.foooball_app.entity.Team;

import java.util.Date;

public class PlayerRequest {
    private String playerName;

    private String nationality;

    private String position;

    private Date dateOfBirth;

    private int team_id;

    public String getPlayerName() { return playerName; }

    public String getNationality() {
        return nationality;
    }

    public String getPosition() {
        return position;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }
}
