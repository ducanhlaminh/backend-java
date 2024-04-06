package com.example.foooball_app.service;

import com.example.foooball_app.dto.request.TournamentRequest;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public List<Tournament> getTournaments(String tournamentName, String startDate, String endDate) {
        List<Tournament> tournaments = tournamentRepository.findAll();
        return filterTournaments(tournaments, tournamentName, startDate, endDate);
    }

    public Tournament createTournament(TournamentRequest request) {
        if (tournamentRepository.existsByTournamentName(request.getTournamentName())) {
            throw new AppError(ErrorCode.TOURNAMENT_EXISTED);
        }
        Tournament tournament = new Tournament();
        tournament.setTournamentName(request.getTournamentName());
        tournament.setStartDate(request.getStartDate());
        tournament.setEndDate(request.getEndDate());
        return tournamentRepository.save(tournament);
    }

    public Tournament updateTournament(Long id, TournamentRequest request) {
        Optional<Tournament> existingTournament = tournamentRepository.findById(id);
        if (!existingTournament.isPresent()) {
            throw new AppError(ErrorCode.TOURNAMENT_UNEXISTED);
        }
        Tournament tournament = existingTournament.get();
        if (request.getTournamentName() != null) {
            tournament.setTournamentName(request.getTournamentName());
        }
        if (request.getStartDate() != null) {
            tournament.setStartDate(request.getStartDate());
        }
        if (request.getEndDate() != null) {
            tournament.setEndDate(request.getEndDate());
        }
        return tournamentRepository.save(tournament);
    }

    public boolean deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
        return true;
    }

    private List<Tournament> filterTournaments(List<Tournament> tournaments, String tournamentName, String startDate, String endDate) {
        return tournaments.stream()
                .filter(tournament -> (tournamentName == null || tournament.getTournamentName().equalsIgnoreCase(tournamentName)))
                .filter(tournament -> (startDate == null || tournament.getStartDate().equals(startDate)))
                .filter(tournament -> (endDate == null || tournament.getEndDate().equals(endDate)))
                .collect(Collectors.toList());
    }
}
