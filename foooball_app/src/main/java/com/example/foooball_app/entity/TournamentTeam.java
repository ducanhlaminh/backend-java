 package com.example.foooball_app.entity;
 import com.fasterxml.jackson.annotation.JsonBackReference;
 import com.fasterxml.jackson.annotation.JsonManagedReference;
 import jakarta.persistence.*;

 @Entity
 @Table(name = "tournament_teams")
 public class TournamentTeam {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;


     @ManyToOne
     @JoinColumn(name = "team_id")
     @JsonBackReference
     private Team teams;

     @ManyToOne
     @JoinColumn(name = "tournament_id")
     @JsonManagedReference
     private Tournament tournament;
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
