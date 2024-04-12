package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, Long> {

    boolean existsByCoachName(String coachName);
    boolean existsByCountry(String country);
    boolean existsByYearsOfExperience(Integer yearsOfExperience);


<<<<<<< HEAD
}
=======
}
>>>>>>> af9d94641fd062ce08cf4020196d90695601d54c