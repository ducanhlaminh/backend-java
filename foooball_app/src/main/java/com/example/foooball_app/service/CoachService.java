package com.example.foooball_app.service;

import com.example.foooball_app.entity.Coach;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    public List<Coach> getCoaches(String coachName, String country) {
        List<Coach> coaches = coachRepository.findAll();
        return filter(coaches, coachName, country);
    }

    public Coach createCoach(Coach coach) {
        if (coachRepository.existsByCoachName(coach.getCoachName())) {
            throw new AppError(ErrorCode.COACH_EXISTED);
        }
        return coachRepository.save(coach);
    }

    public Coach updateCoach(Coach coach) {
        Optional<Coach> existingCoach = coachRepository.findById(coach.getCoachId());
        if (!existingCoach.isPresent()) {
            throw new AppError(ErrorCode.COACH_UNEXISTED);
        }
        Coach updatedCoach = existingCoach.get();
        updatedCoach.setCoachName(coach.getCoachName());
        updatedCoach.setCountry(coach.getCountry());
        updatedCoach.setDateOfBirth(coach.getDateOfBirth());
        return coachRepository.save(updatedCoach);
    }

    public boolean deleteCoach(int coachId) {
        coachRepository.findById(coachId).orElseThrow(() -> new AppError(ErrorCode.COACH_UNEXISTED));
        coachRepository.deleteById(coachId);
        return true;
    }

    private List<Coach> filter(List<Coach> coaches, String coachName, String country) {
        return coaches.stream()
                .filter(coach -> (coachName == null || coach.getCoachName().equalsIgnoreCase(coachName)))
                .filter(coach -> (country == null || coach.getCountry().equalsIgnoreCase(country)))
                .collect(Collectors.toList());
    }
}
