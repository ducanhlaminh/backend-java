package com.example.foooball_app.controller;

import com.example.foooball_app.dto.request.Match_TeamRequest;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.entity.Match_Teams;
import com.example.foooball_app.service.Match_TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Match_TeamController {
    @Autowired
    Match_TeamService match_teamService;

    @PostMapping("/match_teams")
    ApiResponse<Match_Teams> createMatchTeam(@RequestBody Match_TeamRequest req){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(match_teamService.createMatch_TeamService(req));
        return apiResponse;
    }

    @GetMapping("/match_teams")
    ApiResponse<List<Match_Teams>> getMatchTeams(){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(match_teamService.getMatchTeams());
        return apiResponse;
    }
}
