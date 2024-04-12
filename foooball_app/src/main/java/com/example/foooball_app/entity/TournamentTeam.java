 package com.example.foooball_app.entity;
 import jakarta.persistence.*;

 @Entity
 @Table(name = "tournament_teams")
 public class TournamentTeam {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

     @ManyToOne
     @JoinColumn(name = "tournament_id")
     private Tournament tournament;
     @ManyToOne
     @JoinColumn(name = "team_id")
     private Team team;

     // Getters and Setters (omitted for brevity)

     public TournamentTeam() {}

     public TournamentTeam(Tournament tournament, Team team) {
         this.tournament = tournament;
         this.team = team;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public Tournament getTournament(){
         return tournament;
     }

     public void setTournament(Tournament tournament){
         this.tournament = tournament;
     }

     public Team getTeam() {
         return team;
     }

     public void setTeam(Team teams) {
         this.team = team;
     }
 }
