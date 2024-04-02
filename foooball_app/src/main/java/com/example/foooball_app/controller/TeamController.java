package com.example.foooball_app.controller;

import com.example.foooball_app.service.TeamService;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.request.TeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;
    @PostMapping("/teams")
    Team createTeam(@RequestBody TeamRequest req){
        return teamService.createReq(req);
    }
    @GetMapping("/teams")
    List<Team> getAll(){
        return teamService.getAll();
    }
}
