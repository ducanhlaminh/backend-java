package com.example.foooball_app.controller;

import com.example.foooball_app.dto.response.ResponsePlayer;
import com.example.foooball_app.entity.Player;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.dto.request.PlayerRequest;
import com.example.foooball_app.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<ResponsePlayer> responsePlayers = new ArrayList<>();
        List<Player> result = playerService.getPlayers();

        for (Player player : result) {
            ResponsePlayer responsePlayer = new ResponsePlayer();
            responsePlayer.setPlayerId(player.getPlayerId());
            responsePlayer.setPlayerName(player.getPlayerName());
            responsePlayer.setNationality(player.getNationality());
            responsePlayer.setPosition(player.getPosition());
            responsePlayer.setDateOfBirth(player.getDateOfBirth());
            responsePlayer.setTeamId(player.getTeam().getTeamId());
            responsePlayer.setTeamName(player.getTeam().getTeamName());

            responsePlayers.add(responsePlayer);
        }

        apiResponse.setResult(responsePlayers);
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
