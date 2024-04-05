package com.example.foooball_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.foooball_app.entity.Team;
import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
    boolean existsByTeamName(String teamName);
    Optional<List<Team>> findAllByCountryAndTeamNameAndTeamId(String country, String teamName , int team_id);



    Optional<List<Team>> findAllByCountryAndTeamName( String country, String teamName);
}
