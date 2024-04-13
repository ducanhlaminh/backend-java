package com.example.foooball_app.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import java.util.List;

import java.util.Set;
import java.util.List;


@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int teamId;


    private String teamName;

    private String country;

    @OneToMany(mappedBy = "teams")
    @JsonManagedReference
    private List<TournamentTeam> tournamentTeam;

    // Getters and setters
    @OneToOne
    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id")
    @JsonManagedReference
    private Coach coach;

    @OneToMany(mappedBy = "team")
    @JsonBackReference
    private List<Match_Teams> teams;

    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private List<Player> players;

    public List<TournamentTeam> getTournamentTeam() {
        return tournamentTeam;
    }

    public void setTournamentTeam(List<TournamentTeam> tournamentTeam) {
        this.tournamentTeam = tournamentTeam;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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



    public List<Match_Teams> getTeams() {
        return teams;
    }

    public void setTeams(List<Match_Teams> teams) {
        this.teams = teams;
    }
}
