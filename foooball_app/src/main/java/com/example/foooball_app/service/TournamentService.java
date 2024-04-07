package com.example.foooball_app.service;

import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.entity.TournamentTeam;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.TournamentRepository;
import com.example.foooball_app.repository.TournamentTeamRepository;
import com.example.foooball_app.dto.request.TournamentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentTeamRepository tournamentTeamRepository;

    public List<Tournament> getTournaments(String tournamentName, String location, String startDate, String endDate) {
        List<Tournament> tournaments = tournamentRepository.findAll();
        return filter(tournaments, tournamentName, location, startDate, endDate);
    }

    public Tournament createTournamentService(TournamentRequest req, TournamentTeam tournamentTeamData) {
        if (tournamentRepository.existsByTournamentName(req.getTournamentName())) {
            throw new AppError(ErrorCode.TOURNAMENT_EXISTED);
        }

        List<TournamentTeam> tournamentTeams = new ArrayList<>();
        tournamentTeams.add(tournamentTeamData);

        Tournament tournament = new Tournament();
        tournament.setTournamentName(req.getTournamentName());
        tournament.setStartDate(req.getStartDate());
        tournament.setEndDate(req.getEndDate());
        // Add other tournament fields as needed

        tournament.setTournamentTeam(tournamentTeams);
        tournamentTeamData.setTournament(tournament);
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> filter(List<Tournament> tournaments, String tournamentName, String location, String startDate, String endDate) {
        List<Tournament> filteredTournaments = tournaments.stream()
                .filter(tournament -> (tournamentName == null || tournament.getTournamentName().equalsIgnoreCase(tournamentName)))
                .filter(tournament -> (startDate == null || tournament.getStartDate().toString().contains(startDate))) // Assuming startDate is a date object
                .filter(tournament -> (endDate == null || tournament.getEndDate().toString().contains(endDate))) // Assuming endDate is a date object
                .collect(Collectors.toList());
        return filteredTournaments;
    }

    public Tournament updateTournament(int id, TournamentRequest tournamentData, TournamentTeam tournamentTeamData) {
        Tournament existingTournament = tournamentRepository.findById((long) id).orElseThrow(() -> new AppError(ErrorCode.TOURNAMENT_UNEXISTED));
        existingTournament.setTournamentName(tournamentData.getTournamentName());
        existingTournament.setStartDate(tournamentData.getStartDate());
        existingTournament.setEndDate(tournamentData.getEndDate());

        TournamentTeam existingTournamentTeam = tournamentTeamRepository.findById(tournamentTeamData.getTournamentTeamId()).orElseThrow(() -> new AppError(ErrorCode.TOURNAMENT_UNEXISTED));
        // Update tournamentTeam data if needed

        tournamentTeamRepository.save(existingTournamentTeam);
        return tournamentRepository.save(existingTournament);
    }

    public boolean deleteTournament(int tournamentId, int tournamentTeamId) {
        tournamentRepository.findById((long) tournamentId).orElseThrow(() -> new AppError(ErrorCode.TOURNAMENT_UNEXISTED));
        tournamentTeamRepository.findById(tournamentTeamId).orElseThrow(() -> new AppError(ErrorCode.TOURNAMENT_UNEXISTED));
        tournamentRepository.deleteById((long) tournamentId);
        tournamentTeamRepository.deleteById(tournamentTeamId);
        return true;
    }
}
