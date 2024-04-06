package com.example.foooball_app.request;

import javax.xml.crypto.Data;
import java.sql.Date;

public class TournamentRequest {
    private String tournamentName;

    private Date startDate;

    private Date endDate;

//    private String team;


    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
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

//    public String getTeam() {
//        return team;
//    }
//
//    public void setTeam(String team) {
//        this.team = team;
//    }
}
