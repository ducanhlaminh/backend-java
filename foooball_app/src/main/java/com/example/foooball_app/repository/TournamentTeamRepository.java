package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Team;
import com.example.foooball_app.entity.Tournament;
import com.example.foooball_app.entity.TournamentTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentTeamRepository extends JpaRepository<TournamentTeam, Integer> {
//    Optional<TournamentTeam> findByTournamentIdAndTeamId(int tournamentId, int teamId);

    // List<TournamentTeam> findByTournament(Tournament tournament);
    // List<TournamentTeam> findByTournament(Team team);
}
