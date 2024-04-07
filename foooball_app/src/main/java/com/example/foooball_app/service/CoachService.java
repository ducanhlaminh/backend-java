package com.example.foooball_app.service;

import com.example.foooball_app.dto.request.CoachRequest;
import com.example.foooball_app.entity.Coach;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    public List<Coach> getCoaches(String coachName, String country, String dateOfBirth, Integer yearsOfExperience) {
        List<Coach> coaches = coachRepository.findAll();
        return filterCoaches(coaches, coachName, country, dateOfBirth, yearsOfExperience);
    }

    public Coach createCoach(CoachRequest coachRequest) {
        if (coachRepository.existsByCoachName(coachRequest.getCoachName())) {
            throw new AppError(ErrorCode.COACH_EXISTED);
        }
        Coach coach = new Coach();
        coach.setCoachName(coachRequest.getCoachName());
        coach.setCountry(coachRequest.getCountry());
        coach.setDateOfBirth(coachRequest.getDateOfBirth());
        coach.setYearsOfExperience(coachRequest.getYearsOfExperience());
        return coachRepository.save(coach);
    }

    public Coach updateCoach(Long id, CoachRequest coachRequest) {
        Optional<Coach> existingCoach = coachRepository.findById(id);
        if (!existingCoach.isPresent()) {
            throw new AppError(ErrorCode.COACH_UNEXISTED);
        }
        Coach coach = existingCoach.get();
        if (coachRequest.getCoachName() != null) {
            coach.setCoachName(coachRequest.getCoachName());
        }
        if (coachRequest.getCountry() != null) {
            coach.setCountry(coachRequest.getCountry());
        }
        if (coachRequest.getDateOfBirth() != null) {
            coach.setDateOfBirth(coachRequest.getDateOfBirth());
        }
        if (coachRequest.getYearsOfExperience() != null) {
            coach.setYearsOfExperience(coachRequest.getYearsOfExperience());
        }
        return coachRepository.save(coach);
    }

    public boolean deleteCoach(Long id) {
        coachRepository.deleteById(id);
        return true;
    }

    public List<Coach> filterCoaches(List<Coach> coaches, String coachName, String country, String dateOfBirth, Integer yearsOfExperience) {
        List<Coach> filteredCoaches;
        filteredCoaches = coaches.stream()
                .filter(coach -> (coachName == null || coach.getCoachName().equalsIgnoreCase(coachName)))
                .filter(coach -> (country == null || coach.getCountry().equalsIgnoreCase(country)))
                .filter(coach -> (dateOfBirth == null || coach.getDateOfBirth().equals(dateOfBirth)))
                .filter(coach -> (yearsOfExperience == null || coach.getYearsOfExperience().equals(yearsOfExperience)))
                .collect(Collectors.toList());
        return filteredCoaches;
    }

    //    public Player changePlayerPosition(Long playerId, Integer newPosition) {
//        Player player = playerRepository.findById(playerId).orElseThrow(() -> new RuntimeException("Cầu thủ không tồn tại"));
//        player.setPosition(newPosition);
//        return playerRepository.save(player);
//    }
}
