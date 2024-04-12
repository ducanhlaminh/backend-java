package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoachRepository extends JpaRepository<Coach, Integer> {

    boolean existsByCoachName(String coachName);
    boolean existsByCountry(String country);
    boolean existsByYearsOfExperience(Integer yearsOfExperience);


}
