package com.example.foooball_app.controller;

import com.example.foooball_app.entity.Match;
import com.example.foooball_app.request.MatchCreateRequest;
import com.example.foooball_app.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MatchController {
    @Autowired
    private MatchService matchService;

    @PostMapping("/matchs")
    Match createMatch(@RequestBody MatchCreateRequest req){
        return matchService.createMatchService(req);
    }
}
