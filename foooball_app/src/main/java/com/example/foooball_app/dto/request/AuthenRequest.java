package com.example.foooball_app.dto.request;

import com.example.foooball_app.entity.Sponsor;

public class AuthenRequest {
    private int userId;


    private String username;


    private String password;


    private String role;
    private String sponsorName;
    private String sponsorType;
    private String country;

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
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

    //    private Sponsor sponsor;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public Sponsor getSponsor() {
//        return sponsor;
//    }
//
//    public void setSponsor(Sponsor sponsor) {
//        this.sponsor = sponsor;
//    }
}
