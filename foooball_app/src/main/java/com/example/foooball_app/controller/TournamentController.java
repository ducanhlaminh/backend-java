package com.example.foooball_app.controller;

import com.example.foooball_app.dto.request.TournamentRequest;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.service.TournamentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    public ApiResponse<Tournament> createTournament(@RequestBody TournamentRequest request) {
        ApiResponse<Tournament> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tournamentService.createTournament(request));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<Tournament>> getTournaments(
            @RequestParam(required = false) String tournamentName,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) {
        ApiResponse<List<Tournament>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tournamentService.getTournaments(tournamentName, startDate, endDate));
        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<Tournament> updateTournament(@PathVariable Long id, @RequestBody TournamentRequest request) {
        ApiResponse<Tournament> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tournamentService.updateTournament(id, request));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteTournament(@PathVariable Long id) {
        ApiResponse apiResponse = new ApiResponse<>();
        if (tournamentService.deleteTournament(id)) {
            apiResponse.setMessage("Xóa giải đấu thành công");
            apiResponse.setCode(1);
        } else {
            apiResponse.setMessage("Xóa giải đấu thất bại");
            apiResponse.setCode(0);
        }
        return apiResponse;
    }
}
