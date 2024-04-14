package com.example.foooball_app.dto.request;

import com.example.foooball_app.entity.Sponsorship;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.entity.Tournament;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public class SponsorRequest {
//    private int id;
    private int sponsorId;
    private String sponsorType;
    private String country;
    private int sponsorshipAmount;
    private Date startDate;
    private Date endDate;
    private int teamId;

    public int getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(int sponsorId) {
        this.sponsorId = sponsorId;
    }

    public int getSponsorshipAmount() {
        return sponsorshipAmount;
    }

    public void setSponsorshipAmount(int sponsorshipAmount) {
        this.sponsorshipAmount = sponsorshipAmount;
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

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
    public String getSponsorType() {
        return sponsorType;
    }

    public void setSponsorType(String sponsorType) {
        this.sponsorType = sponsorType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public Sponsorship getSponsorship() {
//        return sponsorship;
//    }
//
//    public void setSponsorship(Sponsorship sponsorship) {
//        this.sponsorship = sponsorship;
//    }
}
