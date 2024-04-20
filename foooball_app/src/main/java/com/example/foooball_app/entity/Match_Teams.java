package com.example.foooball_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "match_teams")
public class Match_Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_team_id")
    private int matchTeamId;

    private String type;

    @ManyToOne
    @JoinColumn(name = "team_team_id" )
    private Team team;

    @ManyToOne
    @JoinColumn(name = "match_match_id")
    private Match match;

    public int getMatchTeamId() {
        return matchTeamId;
    }

    public void setMatchTeamId(int matchTeamId) {
        this.matchTeamId = matchTeamId;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
