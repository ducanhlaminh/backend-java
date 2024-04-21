package com.example.foooball_app.controller;

import com.example.foooball_app.dto.request.RakingRequest;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.dto.response.ResponseRanking;
import com.example.foooball_app.dto.response.ResponseRankingTeam;
import com.example.foooball_app.dto.response.ResponseTeamNameRank;
import com.example.foooball_app.entity.Ranking;
import com.example.foooball_app.entity.Ranking_Team;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.service.RakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RankingController {
    @Autowired
    private RakingService rankingService;

    @PostMapping("/rankings")
    ApiResponse<Ranking> createRaking(@RequestBody RakingRequest req){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(rankingService.createRanking(req));
        return apiResponse;
    }

    @GetMapping("/rankings/")
    ApiResponse<Ranking> getRankings(@RequestParam(required = false) String tournament_id){
        ApiResponse apiResponse = new ApiResponse<>();

        ResponseRanking responseRanking = new ResponseRanking();
        Ranking result = rankingService.getRankings(tournament_id);

        responseRanking.setRankingId(result.getRankingId());
        responseRanking.setTournamentId(result.getTournament().getTournamentId());
        responseRanking.setTournamentName(result.getTournament().getTournamentName());

        List<ResponseRankingTeam> responseRankingTeams = new ArrayList<>();
        for(Ranking_Team rankingTeam : result.getRankingTeams()){
            ResponseTeamNameRank responseTeamNameRank = new ResponseTeamNameRank();
            responseTeamNameRank.setTeamName(rankingTeam.getTeam().getTeamName());

            ResponseRankingTeam responseRankingTeam = new ResponseRankingTeam();
            responseRankingTeam.setRankingTeamId(rankingTeam.getRankingTeamId());
            responseRankingTeam.setResponseTeamNameRank(responseTeamNameRank);
            responseRankingTeam.setPoints(rankingTeam.getPoint());

            responseRankingTeams.add(responseRankingTeam);
        }
        responseRankingTeams.sort((team1, team2) -> Integer.compare(team2.getPoints(), team1.getPoints()));
        responseRanking.setResponseRankingTeams(responseRankingTeams);


        apiResponse.setResult(responseRanking);
        return apiResponse;
    }

//    @GetMapping("/rankings")
//    ApiResponse<Ranking> updateRanking(@RequestBody RakingRequest req){
//        ApiResponse apiResponse = new ApiResponse<>();
//        apiResponse.setResult(rankingService.updateRanking(req));
//        return apiResponse;
//    }
}
