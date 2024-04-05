package com.example.foooball_app.controller;


import com.example.foooball_app.service.CoachService;
import com.example.foooball_app.entity.Coach;
import com.example.foooball_app.request.CoachRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/coaches")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.findAll();
    }

    @GetMapping("/{id}")
    public Coach getCoachById(@PathVariable Long id) {
        return coachService.findById(id);
    }

    @PostMapping
    public Coach createCoach(@RequestBody Coach coach) {
        return coachService.create(coach);
    }

    @PutMapping("/{id}")
    public Coach updateCoach(@PathVariable Long id, @RequestBody Coach coach) {
        return coachService.update(id, coach);
    }

    @DeleteMapping("/{id}")
    public void deleteCoach(@PathVariable Long id) {
        coachService.delete(id);
    }

    @GetMapping("/filter")
    public List<Coach> filterCoaches(
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String team,
            @RequestParam(required = false) Integer yearsOfExperience
    ) {
        return coachService.filter(fullName, country, team, yearsOfExperience);
    }
}
