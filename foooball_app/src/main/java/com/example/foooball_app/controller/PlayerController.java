package com.example.foooball_app.controller;

import com.example.foooball_app.entity.Player;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.request.PlayerRequest;
import com.example.foooball_app.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/players")
    ApiResponse<Player> createPlayer(@RequestBody PlayerRequest req){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(playerService.createPlayerService(req));
        return apiResponse;
    }

    @GetMapping("/players")
    ApiResponse<List<Player>> getPlayers(){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(playerService.getPlayers());
        return apiResponse;
    }

    @GetMapping("/players/{playerId}")
    ApiResponse<Player> getPlayer(@PathVariable("playerId") int playerId){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(playerService.getPlayer(playerId));
        return apiResponse;
    }

    @PutMapping("/players/{playerId}")
    ApiResponse<Player> updatePlayer(@PathVariable("playerId") int playerId, @RequestBody PlayerRequest req){
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult(playerService.updatePlayer(playerId, req));
        return apiResponse;
    }

    @DeleteMapping("/players/{playerId}")
    ApiResponse<String> deletePlayer(@PathVariable("playerId") int playerId){
        playerService.deletePlayer(playerId);
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setResult("Player has been deleted");
        return apiResponse;
    }
}
