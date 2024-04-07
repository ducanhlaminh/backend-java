package com.example.foooball_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "match_teams")
public class Match_Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int matchTeamId;

    private int matchId;

    private int teamId;

    private String type;


    @OneToOne
    @JoinColumn(name = "match_id", referencedColumnName = "match_id")
    @JsonBackReference
    private Match match;

//    @ManyToOne
//    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
//    @JsonBackReference
//    private Team team;

    public int getMatchTeamId() {
        return matchTeamId;
    }

    public void setMatchTeamId(int matchTeamId) {
        this.matchTeamId = matchTeamId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
}
