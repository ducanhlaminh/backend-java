<<<<<<< HEAD
package com.example.foooball_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.sql.Date;
@Entity
@Table(name = "tournament_teams")
public class TournamentTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournament_id")
    private int tournamentTeamId;

    @Column(name = "team_id")
    private int teamId;
//    @ManyToOne
//    @JoinColumn(name = "tournament_id", referencedColumnName = "tournament_id")
//    @JsonBackReference
    private Tournament tournament;

//    @ManyToOne
//    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
//    @JsonBackReference
//    private Team team;

    // Getters and setters

    public int getTournamentTeamId() {
        return tournamentTeamId;
    }

    public void setTournamentTeamId(int tournamentTeamId) {
        this.tournamentTeamId = tournamentTeamId;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
=======
package com.example.foooball_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "tournament_teams")
public class TournamentTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tournamentTeamId;

    @ManyToOne
    @JoinColumn(name = "tournament_id", referencedColumnName = "tournament_id")
    @JsonBackReference
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    @JsonBackReference
    private Team team;

    // Getters and setters

    public int getTournamentTeamId() {
        return tournamentTeamId;
    }

    public void setTournamentTeamId(int tournamentTeamId) {
        this.tournamentTeamId = tournamentTeamId;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
>>>>>>> af9d94641fd062ce08cf4020196d90695601d54c
}