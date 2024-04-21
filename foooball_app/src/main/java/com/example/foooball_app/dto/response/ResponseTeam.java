package com.example.foooball_app.dto.response;

import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.entity.TournamentTeam;

import java.util.ArrayList;
import java.util.List;

class TournamentItem {
    private int tournamentId;

    private String tournamentName;

    public TournamentItem(int tournamentId, String tournamentName) {
        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }
}

class Coach {
    private int coachId;
    private String coachName;

    public Coach(int coachId, String coachName) {
        this.coachId = coachId;
        this.coachName = coachName;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
public class ResponseTeam {
    private int teamId;


    private String teamName;

    private String country;
    private Coach coach;
    private int numberOfPlayers;
    private List<TournamentItem> tournament = new ArrayList<>();

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public List<TournamentItem> getTournament() {
        return tournament;
    }

    public void setTournament(TournamentTeam tournamentTeam) {
        Tournament tournament = tournamentTeam.getTournament();
        TournamentItem tournamentItem = new TournamentItem(tournament.getTournamentId(), tournament.getTournamentName());
        this.tournament.add(tournamentItem);
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public Coach getCoach() {
        return coach;
    }

    public void setCoach(int coachId, String coachName) {
        this.coach = new Coach(coachId,coachName);
    }


}
