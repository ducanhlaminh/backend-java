package com.example.foooball_app.controller;

import com.example.foooball_app.entity.Player;
import com.example.foooball_app.request.PlayerCreateRequest;
import com.example.foooball_app.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/players")
    Player createPlayer(@RequestBody PlayerCreateRequest req){
        return playerService.createPlayerService(req);
    }
}
