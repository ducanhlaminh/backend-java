package com.example.foooball_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private int matchId;

    private Date matchDate;

    private String stadium;

    @ManyToOne
    @JoinColumn(name = "team_id_win")
    private Team teamWin;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @OneToMany(mappedBy="match")

    private List<Match_Teams> match_teams;

    public Team getTeamWin() {
        return teamWin;
    }

    public void setTeamWin(Team teamWin) {
        this.teamWin = teamWin;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

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


    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public List<Match_Teams> getMatch_teams() {
        return match_teams;
    }

    public void setMatch_teams(List<Match_Teams> match_teams) {
        this.match_teams = match_teams;
    }
}