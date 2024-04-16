package com.example.foooball_app.entity;

import jakarta.persistence.*;

@Entity
public class Ranking_Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rankingTeamId;

    private int point ;

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
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
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
