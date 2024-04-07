package com.example.foooball_app.controller;

import com.example.foooball_app.dto.response.ApiResponse;
import java.util.List;

import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.entity.TournamentTeam;
import com.example.foooball_app.service.TournamentService;
import com.example.foooball_app.dto.request.TournamentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    ApiResponse<Tournament> createTournament(@RequestBody TournamentRequest req) {
        ApiResponse<Tournament> apiResponse = new ApiResponse<>();
        TournamentTeam tournamentTeam = new TournamentTeam(); // Assuming request contains team information
        // Set team data on tournamentTeam based on request (e.g., req.getTeamId())
        apiResponse.setResult(tournamentService.createTournamentService(req, tournamentTeam));
        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<Tournament>> getTournaments(@RequestParam(required = false) String tournamentName,
                                                 @RequestParam(required = false) String location,
                                                 @RequestParam(required = false) String startDate,
                                                 @RequestParam(required = false) String endDate) {
        ApiResponse<List<Tournament>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tournamentService.getTournaments(tournamentName, location, startDate, endDate));
        return apiResponse;
    }

    @PutMapping("/{id}")
    ApiResponse<Tournament> updateTournament(@PathVariable int id, @RequestBody TournamentRequest req) {
        ApiResponse<Tournament> apiResponse = new ApiResponse<>();
        TournamentTeam tournamentTeam = new TournamentTeam(); // Assuming request contains updated team information
        // Set team data on tournamentTeam based on request (e.g., req.getTeamId())
        apiResponse.setResult(tournamentService.updateTournament(id, req, tournamentTeam));
        return apiResponse;
    }

    @DeleteMapping("/{id}/{tournamentTeamId}")
    ApiResponse deleteTournament(@PathVariable int tournamentId, @PathVariable int tournamentTeamId) {
        ApiResponse apiResponse = new ApiResponse<>();
        if (tournamentService.deleteTournament(tournamentId, tournamentTeamId)) {
            apiResponse.setMessage("Xóa giải đấu thành công");
            apiResponse.setCode(1);
        } else {
            apiResponse.setMessage("Xóa giải đấu thất bại");
            apiResponse.setCode(0);
        }
        return apiResponse;
    }
}
