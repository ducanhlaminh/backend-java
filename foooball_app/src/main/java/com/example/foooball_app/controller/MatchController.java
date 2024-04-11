package com.example.foooball_app.controller;

import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.entity.Match;
import com.example.foooball_app.dto.request.MatchRequest;
import com.example.foooball_app.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
