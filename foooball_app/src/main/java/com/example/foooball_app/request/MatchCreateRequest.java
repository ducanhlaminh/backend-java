package com.example.foooball_app.request;

import com.example.foooball_app.entity.Team;
import com.example.foooball_app.entity.Tournament;

import java.util.Date;

public class MatchCreateRequest {
    private Date matchDate;

    private String stadium;

    private String result;

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
