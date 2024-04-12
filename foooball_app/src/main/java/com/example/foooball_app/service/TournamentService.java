package com.example.foooball_app.service;

import com.example.foooball_app.dto.request.TournamentRequest;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.entity.TournamentTeam;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.TeamRepository;
import com.example.foooball_app.repository.TournamentRepository;
//import com.example.foooball_app.repository.TournamentTeamRepository;
import com.example.foooball_app.repository.TournamentTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentTeamRepository tournamentTeamRepository;

    @Autowired
    private TeamRepository teamRepository;

    public List<Tournament> getTournaments(String tournamentName, Date startDate, Date endDate) {
        List<Tournament> tournaments = tournamentRepository.findAll();
        return filter(tournaments, tournamentName, startDate, endDate);
    }

    public Tournament createTournament(Tournament tournament) {
        if (tournamentRepository.existsByTournamentName(tournament.getTournamentName())) {
            throw new AppError(ErrorCode.TOURNAMENT_EXISTED);
        }
        return tournamentRepository.save(tournament);
    }

    public Tournament updateTournament(Tournament tournament) {
        Optional<Tournament> existingTournament = tournamentRepository.findById(tournament.getTournamentId());
        if (!existingTournament.isPresent()) {
            throw new AppError(ErrorCode.TOURNAMENT_UNEXISTED);
        }
        Tournament updatedTournament = existingTournament.get();
        updatedTournament.setTournamentName(tournament.getTournamentName());
        updatedTournament.setStartDate(tournament.getStartDate());
        updatedTournament.setEndDate(tournament.getEndDate());
        return tournamentRepository.save(updatedTournament);
    }

    public boolean deleteTournament(int tournamentId) {
        tournamentRepository.findById(tournamentId).orElseThrow(() -> new AppError(ErrorCode.TOURNAMENT_UNEXISTED));
        tournamentRepository.deleteById(tournamentId);
        return true;
    }

    private List<Tournament> filter(List<Tournament> tournaments, String tournamentName, Date startDate, Date endDate) {
        return tournaments.stream()
                .filter(t -> (tournamentName == null || t.getTournamentName().equalsIgnoreCase(tournamentName)))
                .filter(t -> (startDate == null || t.getStartDate().before(new Date(System.currentTimeMillis() + (endDate == null ? 0 : endDate.getTime())))))
                .filter(t -> (endDate == null || t.getEndDate().after(new Date(System.currentTimeMillis() + (startDate == null ? 0 : startDate.getTime())))))
                .collect(Collectors.toList());
    }

    // public TournamentTeam addTeamToTournament(Tournament tournament, Team team) {
    //     TournamentTeam tournamentTeam = new TournamentTeam(tournament, team);
    //     return tournamentTeamRepository.save(tournamentTeam);
    // }

    // public void removeTeamFromTournament(int tournamentId, int teamId) {
    //     Optional<TournamentTeam> existingTournamentTeam = tournamentTeamRepository.findByTournamentIdAndTeamId(tournamentId, teamId);
    //     if (!existingTournamentTeam.isPresent()) {
    //         throw new AppError(ErrorCode.TOURNAMENT_TEAM_UNEXISTED);
    //     }
    //     tournamentTeamRepository.deleteById(existingTournamentTeam.get().getId());
    // }
}
