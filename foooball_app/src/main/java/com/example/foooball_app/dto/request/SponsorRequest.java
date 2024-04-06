package com.example.foooball_app.dto.request;

import com.example.foooball_app.entity.Team;
import com.example.foooball_app.entity.Tournament;
import jakarta.validation.constraints.Pattern;

public class SponsorRequest {
    private int id;
    private String sponsorName;
    @Pattern(regexp = "^[a-zA-Z\\\\s]+$", message = "Chỉ chấp nhận các ký tự chữ cái")
    private String sponsorType;
    private String country;
    private Team team;
    private Tournament tournament;

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Team getTeam() {
        return team;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
