 package com.example.foooball_app.entity;
 import jakarta.persistence.*;

 @Entity
 @Table(name = "tournament_teams")
 public class TournamentTeam {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;



     @ManyToOne
     @JoinColumn(name = "team_id")
     private Team teams;

     // Getters and Setters (omitted for brevity)

     public TournamentTeam() {}

//     public TournamentTeam(Tournament tournament, Team teams) {
//         this.tournament = tournament;
//         this.teams = teams;
//     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

//     public Tournament getTournament(){
//         return tournament;
//     }

//     public void setTournament(Tournament tournament){
//         this.tournament = tournament;
//     }

     public Team getTeams() {
         return teams;
     }

     public void setTeams(Team teams) {
         this.teams = teams;
     }
 }
