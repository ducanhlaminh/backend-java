
package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.Optional;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

    boolean existsByTournamentName(String tournamentName);

     boolean existsByStartDateAfter(Date startDate);
     boolean existsByEndDateBefore(Date endDate);

    // Optional<Tournament> findById(Integer tournamentId);
}

