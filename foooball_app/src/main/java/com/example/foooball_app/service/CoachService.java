package com.example.foooball_app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import com.example.foooball_app.entity.Coach;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.exception.CoachNotFoundException;
import com.example.foooball_app.repository.CoachRepository;
import com.example.foooball_app.request.CoachRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.logging.Logger;
@Service
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;

    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    public Coach findById(Long id) {
        return coachRepository.findById(id).orElseThrow(() -> new CoachNotFoundException(id));
    }

    public Coach create(Coach coach) {
        return coachRepository.save(coach);
    }

    public Coach update(Long id, Coach coach) {
        Coach updateCoach = coachRepository.findById(id).orElseThrow(() -> new CoachNotFoundException(id));
        updateCoach.setFullName(coach.getFullName());
        updateCoach.setCountry(coach.getCountry());
        updateCoach.setDateOfBirth(coach.getDateOfBirth());
        updateCoach.setTeam(coach.getTeam());
        updateCoach.setYearsOfExperience(coach.getYearsOfExperience());
        return coachRepository.save(updateCoach);
    }

    public void delete(Long id) {
        coachRepository.deleteById(id);
    }

    public List<Coach> filter(String fullName, String country, String team, Integer yearsOfExperience) {
        List<Coach> coaches = new ArrayList<>();
        if (fullName != null) {
            coaches.addAll(coachRepository.findByFullNameContaining(fullName));
        }
        if (country != null) {
            coaches.addAll(coachRepository.findByCountryContaining(country));
        }
        if (team != null) {
            coaches.addAll(coachRepository.findByTeamContaining(team));
        }
        if (yearsOfExperience != null) {
            coaches.addAll(coachRepository.findByYearsOfExperience(yearsOfExperience));
        }
        // Loại bỏ các bản ghi trùng lặp
        Set<Coach> coachSet = new HashSet<>(coaches);
        return new ArrayList<>(coachSet);
    }
}

