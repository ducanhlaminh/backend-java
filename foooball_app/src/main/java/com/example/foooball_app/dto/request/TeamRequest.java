package com.example.foooball_app.dto.request;

import jakarta.validation.constraints.Pattern;

public class TeamRequest {
    private int id;
    private String teamName;
    @Pattern(regexp = "^[a-zA-Z\\\\s]+$", message = "Chỉ chấp nhận các ký tự chữ cái")
    private String country;
    private int coach_id;

    public int getCoach_id() {
        return coach_id;
    }

    public void setCoach_id(int coach_id) {
        this.coach_id = coach_id;

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