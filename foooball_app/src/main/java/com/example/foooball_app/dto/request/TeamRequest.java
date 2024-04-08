package com.example.foooball_app.dto.request;

import jakarta.validation.constraints.Pattern;

public class TeamRequest {
    private int id;
    private String teamName;
    @Pattern(regexp = "^[a-zA-Z\\\\s]+$", message = "Chỉ chấp nhận các ký tự chữ cái")
    private String country;
    private int coachId;

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