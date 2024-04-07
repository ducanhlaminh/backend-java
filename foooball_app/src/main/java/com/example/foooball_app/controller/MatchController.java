package com.example.foooball_app.controller;

import com.example.foooball_app.entity.Match;
import com.example.foooball_app.request.MatchCreateRequest;
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
    Match createMatch(@RequestBody MatchCreateRequest req){
        return matchService.createMatchService(req);
    }

    @GetMapping("/matches")
    List<Match> getMatches(){
        return matchService.getMatches();
    }
}
