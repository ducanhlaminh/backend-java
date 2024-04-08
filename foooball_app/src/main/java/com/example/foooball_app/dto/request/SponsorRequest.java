//package com.example.foooball_app.dto.request;
//
//import com.example.foooball_app.entity.Sponsorship;
//import com.example.foooball_app.entity.Team;
//import com.example.foooball_app.entity.Tournament;
//import jakarta.validation.constraints.Pattern;
//
//import java.util.Date;
//
//public class SponsorRequest {
//    private int id;
//    private String sponsorName;
//    private String sponsorType;
//    private String country;
//    private int teamId;
//    private int tournamentId;
//    private Date startDate;
//    private Date endDate;
//    private Sponsorship sponsorship;
//    private int sponsorshipAmount;
//    private int sponsorshipId;
//
//    public int getSponsorshipId() {
//        return sponsorshipId;
//    }
//
//    public void setSponsorshipId(int sponsorshipId) {
//        this.sponsorshipId = sponsorshipId;
//    }
//
//    public Sponsorship getSponsorship() {
//        return sponsorship;
//    }
//
//    public void setSponsorship(Sponsorship sponsorship) {
//        this.sponsorship = sponsorship;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }
//
//    public int getSponsorshipAmount() {
//        return sponsorshipAmount;
//    }
//
//    public void setSponsorshipAmount(int sponsorshipAmount) {
//        this.sponsorshipAmount = sponsorshipAmount;
//    }
//
//    public int getTeamId() {
//        return teamId;
//    }
//
//    public void setTeamId(int teamId) {
//        this.teamId = teamId;
//    }
//
//    public int getTournamentId() {
//        return tournamentId;
//    }
//
//    public void setTournamentId(int tournamentId) {
//        this.tournamentId = tournamentId;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getSponsorName() {
//        return sponsorName;
//    }
//
//    public void setSponsorName(String sponsorName) {
//        this.sponsorName = sponsorName;
//    }
//
//    public String getSponsorType() {
//        return sponsorType;
//    }
//
//    public void setSponsorType(String sponsorType) {
//        this.sponsorType = sponsorType;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//}