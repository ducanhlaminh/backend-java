package com.example.foooball_app.controller;

import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.entity.Match;
import com.example.foooball_app.dto.request.MatchRequest;
import com.example.foooball_app.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {
    @Autowired
    private MatchService matchService;

    @PostMapping("/matches")
    ApiResponse<Match> createMatch(@RequestBody MatchRequest req){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(matchService.createMatchService(req));
        return apiResponse;
    }

    @GetMapping("/matches")
    ApiResponse<List<Match>> getMatches(){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(matchService.getMatches());
        return apiResponse;
    }

    @GetMapping("/matches/{match_id}")
    ApiResponse<Match> getMatch(@PathVariable int match_id){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(matchService.getMatch(match_id));
        return apiResponse;
    }

    @PutMapping("/matches/{match_id}")
    ApiResponse<Match> updateMatch(@PathVariable int match_id, @RequestBody MatchRequest req) {
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(matchService.updateMatch(match_id,req));
        return apiResponse;
    }

    @DeleteMapping("/matches/{match_id}")
    ApiResponse<String> deleteMatch(@PathVariable int match_id){
        matchService.deleteMatch(match_id);
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult("Match has been deleted");
        return apiResponse;
    }
}
