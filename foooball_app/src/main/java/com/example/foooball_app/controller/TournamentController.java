package com.example.foooball_app.controller;

import com.example.foooball_app.dto.request.TournamentRequest;
import com.example.foooball_app.dto.request.TournamentTeamRequest;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.dto.response.ResponseTournament;
import com.example.foooball_app.dto.response.ResponseTournamentTeams;
import com.example.foooball_app.entity.Ranking;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.entity.TournamentTeam;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.TeamRepository;
import com.example.foooball_app.repository.TournamentRepository;
import com.example.foooball_app.service.TournamentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/tournaments")
    public ApiResponse<Ranking> createTournament(@RequestBody TournamentRequest request) {
        ApiResponse<Ranking> apiResponse = new ApiResponse<>();
        Tournament tournament = new Tournament();
        tournament.setTournamentName(request.getTournamentName());
        tournament.setStartDate(request.getStartDate());
        tournament.setEndDate(request.getEndDate());
        apiResponse.setResult(tournamentService.createTournament(tournament));
        return apiResponse;
    }

    @GetMapping("/tournament-teams/{tournamentId}")
    public ApiResponse<Tournament> getTournamentTeams(@PathVariable int tournamentId) {
        ApiResponse apiResponse = new ApiResponse<>();
        Tournament result = tournamentService.getTournamentTeams(tournamentId);
        ResponseTournamentTeams responseTournaments = new ResponseTournamentTeams();
        responseTournaments.setTournamentId(tournamentId);
        for (TournamentTeam tournamentTeam : result.getTournamentTeam()){
            responseTournaments.setTeams(tournamentTeam.getTeams().getTeamId(),tournamentTeam.getTeams().getTeamName());
        }


        apiResponse.setResult(responseTournaments);
        return apiResponse;
    }

    @DeleteMapping("/tournament-teams/{tournamentId}/{teamId}")
    public ApiResponse<Tournament> deleteTournamentTeams(@PathVariable int tournamentId,@PathVariable int teamId) {
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setMessage(tournamentService.deleteTournamentTeams(teamId,tournamentId));
        System.out.println(tournamentId);
        System.out.println(teamId);
        return apiResponse;
    }

    @GetMapping("/tournaments")
    public ApiResponse<List<Tournament>> getTournaments(@RequestParam(required = false) String tournamentName,
                                                        @RequestParam(required = false) Date startDate,
                                                        @RequestParam(required = false) Date endDate) {
        ApiResponse apiResponse = new ApiResponse<>();
//        apiResponse.setResult(tournamentService.getTournaments(tournamentName, startDate, endDate));

        List<ResponseTournament> responseTournaments = new ArrayList<>();
        List<Tournament> result = tournamentService.getTournaments(tournamentName, startDate, endDate);

        for(Tournament tournament : result){
            ResponseTournament responseTournament = new ResponseTournament();
            responseTournament.setTournamentId(tournament.getTournamentId());
            responseTournament.setTournamentName(tournament.getTournamentName());
            responseTournament.setStartDate(tournament.getStartDate());
            responseTournament.setEndDate(tournament.getEndDate());
            responseTournament.setNumOfTeam(tournament.getTournamentTeam().size());

            responseTournaments.add(responseTournament);
        }
        apiResponse.setResult(responseTournaments);
        return apiResponse;
    }

    @PutMapping("/tournaments/{id}")
    public ApiResponse<Tournament> updateTournament(@PathVariable int id, @RequestBody TournamentRequest request) {
        ApiResponse<Tournament> apiResponse = new ApiResponse<>();
        Tournament tournament = new Tournament();
        tournament.setTournamentId(id);
        tournament.setTournamentName(request.getTournamentName());
        tournament.setStartDate(request.getStartDate());
        tournament.setEndDate(request.getEndDate());
        apiResponse.setResult(tournamentService.updateTournament(tournament));
        return apiResponse;
    }

    @DeleteMapping("/tournaments/{id}")
    public ApiResponse deleteTournament(@PathVariable int id) {
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
//    @PostMapping("/tournaments/{id}/teams")
//    public ApiResponse<Tournament> addTeamsToTournament(@PathVariable int id, @RequestBody List<TournamentTeamRequest> tournamentTeamRequests) {
//        ApiResponse<Tournament> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(tournamentService.addTeamsToTournament(id, tournamentTeamRequests));
//        return apiResponse;
//    }
//
//    @PostMapping("/tournaments/{tournamentId}/teams/{teamId}")
//    public ApiResponse<Tournament> removeTeamFromTournament(@PathVariable int tournamentId, @PathVariable int teamId) {
//        ApiResponse<Tournament> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(tournamentService.removeTeamFromTournament(tournamentId, teamId));
//        return apiResponse;
//    }
}
