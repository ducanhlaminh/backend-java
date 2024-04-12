package com.example.foooball_app.controller;

import com.example.foooball_app.dto.request.TournamentRequest;
import com.example.foooball_app.dto.response.ApiResponse;
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
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private TournamentRepository tournamentRepository;
    private TeamRepository teamRepository;
//
//    @PostMapping("/tournaments")
//    public ApiResponse<Tournament> createTournament(@RequestBody TournamentRequest request) {
//        ApiResponse<Tournament> apiResponse = new ApiResponse<>();
//        Tournament tournament = new Tournament();
//        tournament.setTournamentName(request.getTournamentName());
//        tournament.setStartDate(request.getStartDate());
//        tournament.setEndDate(request.getEndDate());
//        apiResponse.setResult(tournamentService.createTournament(tournament));
//        return apiResponse;
//    }

    @GetMapping("/tournaments")
    public ApiResponse<List<Tournament>> getTournaments(@RequestParam(required = false) String tournamentName,
                                                        @RequestParam(required = false) Date startDate,
                                                        @RequestParam(required = false) Date endDate) {
        ApiResponse<List<Tournament>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(tournamentService.getTournaments(tournamentName, startDate, endDate));
        return apiResponse;
    }

//    @PutMapping("/tournaments/{id}")
//    public ApiResponse<Tournament> updateTournament(@PathVariable int id, @RequestBody TournamentRequest request) {
//        ApiResponse<Tournament> apiResponse = new ApiResponse<>();
//        Tournament tournament = new Tournament();
//        tournament.setTournamentId(id);
//        tournament.setTournamentName(request.getTournamentName());
//        tournament.setStartDate(request.getStartDate());
//        tournament.setEndDate(request.getEndDate());
//        apiResponse.setResult(tournamentService.updateTournament(tournament));
//        return apiResponse;
//    }

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
//    @PostMapping("/tournaments/{tournamentId}/teams/{teamId}")
//    public ApiResponse<TournamentTeam> addTeamToTournament(@PathVariable int tournamentId, @PathVariable int teamId) {
//        ApiResponse<TournamentTeam> apiResponse = new ApiResponse<>();
//        Optional<Tournament> existingTournament = tournamentRepository.findById(tournamentId);
//        Optional<Team> existingTeam = teamRepository.findById(teamId);
//        if (!existingTournament.isPresent()) {
//            throw new AppError(ErrorCode.TOURNAMENT_UNEXISTED);
//        }
//        if (!existingTeam.isPresent()) {
//            throw new AppError(ErrorCode.TEAM_UNEXISTED);
//        }
//        TournamentTeam tournamentTeam = tournamentService.addTeamToTournament(existingTournament.get(), existingTeam.get());
//        apiResponse.setResult(tournamentTeam);
//        return apiResponse;
//    }
//
//    @DeleteMapping("/tournaments/{tournamentId}/teams/{teamId}")
//    public ApiResponse deleteTeamFromTournament(@PathVariable int tournamentId, @PathVariable int teamId) {
//        ApiResponse apiResponse = new ApiResponse<>();
//        tournamentService.removeTeamFromTournament(tournamentId, teamId);
//        apiResponse.setMessage("Đã xóa đội khỏi giải đấu");
//        apiResponse.setCode(1);
//        return apiResponse;
//    }
}
