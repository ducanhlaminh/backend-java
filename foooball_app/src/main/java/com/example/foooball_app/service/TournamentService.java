package com.example.foooball_app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.exception.TournamentNotFoundException;
import com.example.foooball_app.repository.TournamentRepository;
import com.example.foooball_app.request.TournamentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    public Tournament findById(Long id) {
        return tournamentRepository.findById(id).orElseThrow(() -> new TournamentNotFoundException(id));
    }

    public Tournament create(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Tournament update(Long id, Tournament tournament) {
        Tournament updateTournament = tournamentRepository.findById(id).orElseThrow(() -> new TournamentNotFoundException(id));
        updateTournament.setTournamentName(tournament.getTournamentName());
        updateTournament.setStartDate(tournament.getStartDate());
        updateTournament.setEndDate(tournament.getEndDate());
        updateTournament.setTeam(tournament.getTeam());
        return tournamentRepository.save(updateTournament);
    }

    public void delete(Long id) {
        tournamentRepository.deleteById(id);
    }

    public List<Tournament> filter(String tournamentName, String startDate, String endDate, String team) {
        List<Tournament> tournaments = new ArrayList<>();
        if (tournamentName != null) {
            tournaments.addAll(tournamentRepository.findByTournamentNameContaining(tournamentName));
        }
        if (startDate != null) {
            tournaments.addAll(tournamentRepository.findByStartDateContaining(startDate));
        }
        if (endDate != null) {
            tournaments.addAll(tournamentRepository.findByEndDateContaining(endDate));
        }
        if (team != null) {
            tournaments.addAll(tournamentRepository.findByTeamContaining(team));
        }
        // Loại bỏ các bản ghi trùng lặp
        Set<Tournament> tournamentSet = new HashSet<>(tournaments);
        return new ArrayList<>(tournamentSet);
    }
}
