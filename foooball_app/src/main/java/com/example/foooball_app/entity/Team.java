package com.example.foooball_app.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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


    @OneToMany(mappedBy = "team")
    @JsonBackReference
    private List<Match_Teams> teams;

    @OneToMany(mappedBy = "team")
    @JsonBackReference
    private List<Player> players;

    @OneToMany(mappedBy = "team")
    @JsonBackReference
    private List<Ranking> rankings;


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
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Match_Teams> getTeams() {
        return teams;
    }

    public void setTeams(List<Match_Teams> teams) {
        this.teams = teams;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public void setRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }
}
