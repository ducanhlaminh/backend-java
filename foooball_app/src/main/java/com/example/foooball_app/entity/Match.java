//package com.example.foooball_app.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//
//import java.util.Date;
//@Entity
//@Table(name = "matches")
//public class Match {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "match_id")
//    private int matchId;
//
//    private Date matchDate;
//
//    private String stadium;
//
//    private String result;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "tournament_id", referencedColumnName = "tournament_id")
//    private Tournament tournament;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "home_team_id", referencedColumnName = "team_id")
//    private Team homeTeam;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "away_team_id", referencedColumnName = "team_id")
//    private Team awayTeam;
//
//    @Column(name = "home_team_id", insertable=false, updatable=false)
//    private int homeTeamId;
//
//    @Column(name = "away_team_id", insertable=false, updatable=false)
//    private int awayTeamId;
//
//    @Column(name = "tournament_id", insertable=false, updatable=false)
//    private int tournamentId;
//
//    public int getMatchId() {
//        return matchId;
//    }
//
//    public void setMatchId(int matchId) {
//        this.matchId = matchId;
//    }
//
//    public Date getMatchDate() {
//        return matchDate;
//    }
//
//    public void setMatchDate(Date matchDate) {
//        this.matchDate = matchDate;
//    }
//
//    public String getStadium() {
//        return stadium;
//    }
//
//    public void setStadium(String stadium) {
//        this.stadium = stadium;
//    }
//
//    public String getResult() {
//        return result;
//    }
//
//    public void setResult(String result) {
//        this.result = result;
//    }
//
//    public Tournament getTournament() {
//        return tournament;
//    }
//
//    public void setTournament(Tournament tournament) {
//        this.tournament = tournament;
//    }
//
//    public Team getHomeTeam() {
//        return homeTeam;
//    }
//
//    public void setHomeTeam(Team homeTeam) {
//        this.homeTeam = homeTeam;
//    }
//
//    public Team getAwayTeam() {
//        return awayTeam;
//    }
//
//    public void setAwayTeam(Team awayTeam) {
//        this.awayTeam = awayTeam;
//    }
//
//    public int getHomeTeamId() {
//        return homeTeamId;
//    }
//
//    public void setHomeTeamId(int homeTeamId) {
//        this.homeTeamId = homeTeamId;
//    }
//
//    public int getAwayTeamId() {
//        return awayTeamId;
//    }
//
//    public void setAwayTeamId(int awayTeamId) {
//        this.awayTeamId = awayTeamId;
//    }
//
//    public int getTournamentId() {
//        return tournamentId;
//    }
//
//    public void setTournamentId(int tournamentId) {
//        this.tournamentId = tournamentId;
//    }
//}