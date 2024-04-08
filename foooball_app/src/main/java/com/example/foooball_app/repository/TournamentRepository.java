package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
>>>>>>> af9d94641fd062ce08cf4020196d90695601d54c

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    boolean existsByTournamentName(String tournamentName);
<<<<<<< HEAD


}
=======
}
>>>>>>> af9d94641fd062ce08cf4020196d90695601d54c
