package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByTournamentNameContaining(String tournamentName);

    List<Tournament> findByStartDateContaining(String startDate);

    List<Tournament> findByEndDateContaining(String endDate);

    List<Tournament> findByTeamContaining(String team);

}
