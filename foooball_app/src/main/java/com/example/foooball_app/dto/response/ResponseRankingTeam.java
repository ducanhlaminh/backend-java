package com.example.foooball_app.dto.response;

public class ResponseRankingTeam {
    private int rankingTeamId;

    private int points ;

    private String teamName;

    public int getRankingTeamId() {
        return rankingTeamId;
    }

    public void setRankingTeamId(int rankingTeamId) {
        this.rankingTeamId = rankingTeamId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
