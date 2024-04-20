package com.example.foooball_app.dto.response;

import com.example.foooball_app.entity.Ranking_Team;

import java.util.Date;
import java.util.List;

public class ResponseRanking {
    private int rankingId;

    private int tournamentId;

    private String tournamentName;

    private List<Ranking_Team> rankingTeams;

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


    public int getRankingId() {
        return rankingId;
    }

    public void setRankingId(int rankingId) {
        this.rankingId = rankingId;
    }

    public List<Ranking_Team> getRankingTeams() {
        return rankingTeams;
    }

    public void setRankingTeams(List<Ranking_Team> rankingTeams) {
        this.rankingTeams = rankingTeams;
    }
}
