package com.example.foooball_app.controller;

import com.example.foooball_app.dto.request.RakingRequest;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.entity.Ranking;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.service.RakingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    ApiResponse getRankings(@RequestParam(required = false) String tournament_id){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(rankingService.getRankings(tournament_id));
        return apiResponse;
    }
}
