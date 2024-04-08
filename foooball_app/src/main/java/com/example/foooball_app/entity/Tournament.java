package com.example.foooball_app.entity;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tournamentId;



    ////    private List<TournamentTeam> tournamentTeam = new ArrayList<>();
//
    private String tournamentName;
    private Date startDate;
    private Date endDate;

//    private String team;


    // Constructors
//    public Tournament() {}
//
//    public Tournament(int tournamentId, String tournamentName, Date startDate, Date endDate) {
//        this.tournamentId = tournamentId;
//        this.tournamentName = tournamentName;
//        this.startDate = startDate;
//        this.endDate = endDate;
////        this.team = team;
//
//    }

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

//    public String getTeam() {
//        return team;
//    }
//
//    public void setTeam(String team1) {
//        this.team = team;
//    }


//    public List<TournamentTeam> getTournamentTeam() {
//        return tournamentTeam;
//    }

//    public void setTournamentTeam(List<TournamentTeam> tournamentTeam) {
//        this.tournamentTeam = tournamentTeam;
//    }

}
