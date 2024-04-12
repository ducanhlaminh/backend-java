package com.example.foooball_app.controller;

import com.example.foooball_app.dto.request.CoachRequest;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.entity.Coach;
import com.example.foooball_app.service.CoachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping("/coaches")
    public ApiResponse<Coach> createCoach(@RequestBody CoachRequest request) {
        ApiResponse<Coach> apiResponse = new ApiResponse<>();
        Coach coach = new Coach();
        coach.setCoachName(request.getCoachName());
        coach.setCountry(request.getCountry());
        coach.setDateOfBirth(request.getDateOfBirth());
        apiResponse.setResult(coachService.createCoach(coach));
        return apiResponse;
    }

    @GetMapping("/coaches")
    public ApiResponse<List<Coach>> getCoaches(@RequestParam(required = false) String coachName,
                                                @RequestParam(required = false) String country) {
        ApiResponse<List<Coach>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(coachService.getCoaches(coachName, country));
        return apiResponse;
    }

    @PutMapping("/coaches/{id}")
    public ApiResponse<Coach> updateCoach(@PathVariable int id, @RequestBody CoachRequest request) {
        ApiResponse<Coach> apiResponse = new ApiResponse<>();
        Coach coach = new Coach();
        coach.setCoachId(id);
        coach.setCoachName(request.getCoachName());
        coach.setCountry(request.getCountry());
        coach.setDateOfBirth(request.getDateOfBirth());
        apiResponse.setResult(coachService.updateCoach(coach));
        return apiResponse;
    }

    @DeleteMapping("/coaches/{id}")
    public ApiResponse deleteCoach(@PathVariable int id) {
        ApiResponse apiResponse = new ApiResponse<>();
        if (coachService.deleteCoach(id)) {
            apiResponse.setMessage("Xóa huấn luyện viên thành công");
            apiResponse.setCode(1);
        } else {
            apiResponse.setMessage("Xóa huấn luyện viên thất bại");
            apiResponse.setCode(0);
        }
        return apiResponse;
    }
}
