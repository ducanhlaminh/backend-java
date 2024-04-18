package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Ranking;
import com.example.foooball_app.entity.Ranking_Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingTeamRepository extends JpaRepository<Ranking_Team, Integer> {
    Ranking_Team findByTeamTeamId(int team_id);
}
