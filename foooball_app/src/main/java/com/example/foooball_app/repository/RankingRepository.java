package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RankingRepository extends JpaRepository<Ranking, Integer> {
//    List<Ranking> findByTournament(int tournamentId);
//    Ranking findByTeamIdAndTournamentId(int tournamentId, int teamId);
}
