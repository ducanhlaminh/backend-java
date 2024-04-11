package com.example.foooball_app.service;

import com.example.foooball_app.entity.Player;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.PlayerRepository;
import com.example.foooball_app.repository.TeamRepository;
import com.example.foooball_app.dto.request.PlayerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Player createPlayerService(PlayerRequest req){
        Player player = new Player();
        player.setPlayerName(req.getPlayerName());
        player.setNationality(req.getNationality());
        player.setPosition(req.getPosition());
        player.setDateOfBirth(req.getDateOfBirth());

        Optional<Team> optionalTeam = teamRepository.findById(req.getTeam_id());
        if(optionalTeam.isPresent()){
            player.setTeam(optionalTeam.get());
        }

        return playerRepository. save(player);
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public Player getPlayer(int id){
        return playerRepository.findById(id).orElseThrow(() -> new AppError(ErrorCode.USER_EXISTED));
    }

    public Player updatePlayer(int playerId, PlayerRequest req){
        Player player = getPlayer(playerId);

        player.setPlayerName(req.getPlayerName());
        player.setNationality(req.getNationality());
        player.setPosition(req.getPosition());
        player.setDateOfBirth(req.getDateOfBirth());

        Optional<Team> optionalTeam = teamRepository.findById(req.getTeam_id());
        if(optionalTeam.isPresent()){
            player.setTeam(optionalTeam.get());
        }

        return playerRepository.save(player);
    }

    public void deletePlayer(int playerId){
        playerRepository.deleteById(playerId);
    }
}
