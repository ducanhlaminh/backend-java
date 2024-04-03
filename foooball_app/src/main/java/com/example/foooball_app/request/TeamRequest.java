package com.example.foooball_app.request;

import jakarta.validation.constraints.Pattern;

public class TeamRequest {

    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Tên chỉ được chứa ký tự chữ cái và số")
    private String teamName;
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Chỉ chấp nhận các ký tự chữ cái")
    private String country;

    public String getTeamName() {
        return teamName;
    }

    public String getCountry() {
        return country;
    }
}
