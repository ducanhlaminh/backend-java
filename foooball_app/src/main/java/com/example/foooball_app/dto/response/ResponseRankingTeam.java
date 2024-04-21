package com.example.foooball_app.dto.response;

public class ResponseRankingTeam {
    private int rankingTeamId;

    private int points ;

    private ResponseTeamNameRank responseTeamNameRank;

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

    public ResponseTeamNameRank getResponseTeamNameRank() {
        return responseTeamNameRank;
    }

    public void setResponseTeamNameRank(ResponseTeamNameRank responseTeamNameRank) {
        this.responseTeamNameRank = responseTeamNameRank;
    }
}
