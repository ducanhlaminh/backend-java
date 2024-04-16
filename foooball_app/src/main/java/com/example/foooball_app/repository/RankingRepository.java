package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Ranking;
import com.example.foooball_app.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RankingRepository extends JpaRepository<Ranking, Integer> {
//    Ranking findByTournamentTournamentIdAndTeamTeamId(final int tournamentId, final int teamId);

    void deleteByTournament(Tournament tournament);
}
