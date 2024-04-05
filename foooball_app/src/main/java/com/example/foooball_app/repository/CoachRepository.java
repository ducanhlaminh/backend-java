package com.example.foooball_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.foooball_app.entity.Coach;

import java.util.List;

public interface CoachRepository extends JpaRepository<Coach, Long>{
    List<Coach> findByFullNameContaining(String fullName);

    List<Coach> findByCountryContaining(String country);

    List<Coach> findByTeamContaining(String team);

    List<Coach> findByYearsOfExperience(Integer yearsOfExperience);
}
