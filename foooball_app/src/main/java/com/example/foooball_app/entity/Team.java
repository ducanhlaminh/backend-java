package com.example.foooball_app.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

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

//    @OneToMany(mappedBy = "tournament")
//    @JsonManagedReference
//    private List<Tournament> tournament;

    @OneToMany(mappedBy="team")
    private Set<Player> players;

    // Getters and setters
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id")
    @JsonManagedReference
    private Coach coach;

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }





//    public Set<Player> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(Set<Player> players) {
//        this.players = players;
//    }

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
}