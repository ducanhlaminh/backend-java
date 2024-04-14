package com.example.foooball_app.entity;
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

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TournamentTeam> tournamentTeam;
    // Constructors, Getters, and Setters
    // Constructors



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

    public List<TournamentTeam> getTournamentTeam() {
        return tournamentTeam;
    }

    public void setTournamentTeam(List<TournamentTeam> tournamentTeam) {
        this.tournamentTeam = tournamentTeam;
    }
}
