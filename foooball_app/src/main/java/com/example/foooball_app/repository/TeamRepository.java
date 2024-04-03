package com.example.foooball_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.foooball_app.entity.Team;
@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
    boolean existsByTeamName(String teamName);
}
