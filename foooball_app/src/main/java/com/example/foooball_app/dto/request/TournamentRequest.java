 package com.example.foooball_app.dto.request;
 import java.util.Set;
 import java.util.Date;
 import com.example.foooball_app.entity.*;
 public class TournamentRequest {
     private String tournamentName;

     private Date startDate;

     private Date endDate;
    
     private Set<TournamentTeam> tournamentTeam;

     // Getters and Setters
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

     public Set<TournamentTeam> getTournamentTeam() {
         return tournamentTeam;
     }

     public void setTournamentTeam(Set<TournamentTeam> tournamentTeam) {
         this.tournamentTeam = tournamentTeam;
     }

 }
