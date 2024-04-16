package com.example.foooball_app.controller;

import com.example.foooball_app.dto.request.Match_TeamRequest;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.entity.Match_Teams;
import com.example.foooball_app.service.Match_TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Match_TeamController {
    @Autowired
    Match_TeamService match_teamService;
    @PreAuthorize("hasAnyAuthority('BTV')")
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
    @PreAuthorize("hasAnyAuthority('SPONSOR','BTV')")

    @GetMapping("/match_teams/{match_teamId}")
    ApiResponse<Match_Teams> getMatchTeam(@PathVariable int match_teamId){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(match_teamService.getMatchTeam(match_teamId));
        return apiResponse;
    }
    @PreAuthorize("hasAnyAuthority('BTV')")
    @PutMapping("/match_teams/{match_teamId}")
    ApiResponse<Match_Teams> updateMatch_Team(@PathVariable int match_teamId, @RequestBody Match_TeamRequest req){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(match_teamService.updateMatchTeam(match_teamId,req));
        return apiResponse;
    }
    @PreAuthorize("hasAnyAuthority('BTV')")
    @DeleteMapping("/match_teams/{match_teamId}")
    ApiResponse<String> deleteMatch_Team(@PathVariable int match_teamId){
        match_teamService.deleteMatch_Team(match_teamId);
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult("Match_Team has been deleted");
        return apiResponse;
    }
}
