package com.example.foooball_app.entity;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "coachs")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coachId;

    private String coachName;

    private String country;

    private Date dateOfBirth;

//    private  Team teamId;

    private Integer yearsOfExperience;

    // Getters and setters

    public Long  getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
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

//    public String getTeam() {
//        return team;
//    }
//
//    public void setTeam(String team) {
//        this.team = team;
//    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
