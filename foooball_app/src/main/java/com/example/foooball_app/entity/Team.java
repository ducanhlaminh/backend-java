package com.example.foooball_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String team_id;
    private String team_name;
    public String getId() {
        return team_id;
    }


    public String getTeam() {
        return team_name;
    }

    public void setId(String id) {
        this.team_id = id;
    }
    public void setTeam(String team) {
        this.team_name = team;
    }
}
