package com.example.foooball_app.controller;

import com.example.foooball_app.entity.Player;
import com.example.foooball_app.request.PlayerCreateRequest;
import com.example.foooball_app.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/players")
    Player createPlayer(@RequestBody PlayerCreateRequest req){
        return playerService.createPlayerService(req);
    }

    @GetMapping("/players")
    List<Player> getPlayers(){
        return playerService.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    Player getPlayer(@PathVariable("playerId") int playerId){
        return playerService.getPlayer(playerId);
    }
}
