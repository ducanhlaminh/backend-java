package com.example.foooball_app.repository;

import com.example.foooball_app.entity.TournamentTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentTeamRepository extends JpaRepository<TournamentTeam, Integer> {

    List<TournamentTeam> findAllByTournamentId(int tournamentId);

    List<TournamentTeam> findAllByTeamId(int teamId);

    Optional<TournamentTeam> findByTournamentIdAndTeamId(int tournamentId, int teamId);
}
