package com.example.foooball_app.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int team_id;

    private String teamName;

    private String country;

    @OneToOne (mappedBy = "homeTeam")
    @JsonBackReference
    private Match match1;

    @OneToOne (mappedBy = "awayTeam")
    @JsonBackReference
    private Match match2;
    // Getters and setters

    public int getTeamId() {
        return team_id;
    }

    public void setTeamId(int teamId) {
        this.team_id = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Match getMatch1() {
        return match1;
    }

    public void setMatch1(Match match1) {
        this.match1 = match1;
    }

    public Match getMatch2() {
        return match2;
    }

    public void setMatch2(Match match2) {
        this.match2 = match2;
    }
}
