package com.example.foooball_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Ranking_Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rankingTeamId;

    private int points ;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "ranking_id")
    private Ranking ranking;

    public int getRankingTeamId() {
        return rankingTeamId;
    }

    public void setRankingTeamId(int rankingTeamId) {
        this.rankingTeamId = rankingTeamId;
    }

    public int getPoint() {
        return points;
    }

    public void setPoint(int point) {
        this.points = point;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
