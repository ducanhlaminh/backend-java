package com.example.foooball_app.dto.request;

import jakarta.validation.constraints.Pattern;

public class TeamRequest {
    private int id;
    private String teamName;
    @Pattern(regexp = "^[a-zA-Z\\\\s]+$", message = "Chỉ chấp nhận các ký tự chữ cái")
    private String country;
    private int coachId;

    public void setId(int id) {
        this.id = id;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }
}