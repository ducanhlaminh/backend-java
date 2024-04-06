package com.example.foooball_app.dto.request;

import java.sql.Date;

public class CoachRequest {
    private String coachName;

    private String country;

    private Date dateOfBirth;

//    private  Team team;

    private Integer yearsOfExperience;

    // Getters and setters

    public String getCoachName() {
        return coachName;
    }

    public void setCoạchName(String coachName) {
        this.coachName = coachName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

}
