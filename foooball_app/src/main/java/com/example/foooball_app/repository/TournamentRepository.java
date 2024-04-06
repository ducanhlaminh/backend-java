package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    boolean existsByTournamentName(String tournamentName);
}
