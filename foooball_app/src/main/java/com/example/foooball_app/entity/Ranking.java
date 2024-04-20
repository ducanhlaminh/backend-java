package com.example.foooball_app.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "rankings")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ranking_id")
    private int rankingId;

    @OneToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @OneToMany(mappedBy = "ranking")
    private List<Ranking_Team> rankingTeams;


    // Getters and setters

    public int getRankingId() {
        return rankingId;
    }

    public void setRankingId(int rankingId) {
        this.rankingId = rankingId;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public List<Ranking_Team> getRankingTeams() {
        return rankingTeams;
    }

    public void setRankingTeams(List<Ranking_Team> rankingTeams) {
        this.rankingTeams = rankingTeams;
    }

    public void addRankingTeam(Ranking_Team rankingTeam){
        this.rankingTeams.add(rankingTeam);
    }
}

