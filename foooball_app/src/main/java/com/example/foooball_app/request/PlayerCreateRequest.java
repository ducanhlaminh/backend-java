package com.example.foooball_app.request;

import com.example.foooball_app.entity.Team;

import java.util.Date;

public class PlayerCreateRequest {
    private String playerName;

    private String nationality;

    private String position;

    private Date dateOfBirth;

    private Team team;

    public String getPlayerName() {
        return playerName;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPosition() {
        return position;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Team getTeam() {
        return team;
    }
}
