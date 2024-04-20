package com.example.foooball_app.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private int tournamentId;

    private String tournamentName;

    private Date startDate;

    private Date endDate;


    @OneToMany(mappedBy = "tournament")
    private List<Match> matches;

    @OneToMany(mappedBy = "tournament")
    private List<TournamentTeam> tournamentTeam;

    @OneToOne(mappedBy = "tournament", cascade = CascadeType.ALL)

    private Ranking ranking;


    // Constructors, Getters, and Setters
    // Constructors


    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public List<TournamentTeam> getTournamentTeam() {
        return tournamentTeam;
    }

    public void setTournamentTeam(List<TournamentTeam> tournamentTeam) {
        this.tournamentTeam = tournamentTeam;
    }

    // Getters and Setters
    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matchs) {
        this.matches = matchs;
    }



}
