package com.example.foooball_app.controller;

import com.example.foooball_app.dto.request.ChangePositionRequest;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.dto.request.CoachRequest;
import com.example.foooball_app.entity.Coach;
import com.example.foooball_app.entity.Player;
import com.example.foooball_app.service.CoachService;
import com.example.foooball_app.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/coaches")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping
    public ApiResponse<Coach> createCoach(@RequestBody CoachRequest coachRequest) {
        ApiResponse<Coach> apiResponse = new ApiResponse<>();
        apiResponse.setResult(coachService.createCoach(coachRequest));
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<Coach>> getCoaches(
            @RequestParam(required = false) String coachName,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String dateOfBirth,
            @RequestParam(required = false) Integer yearsOfExperience) {
        ApiResponse<List<Coach>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(coachService.getCoaches(coachName, country, dateOfBirth, yearsOfExperience));
        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<Coach> updateCoach(@PathVariable Long id, @RequestBody CoachRequest coachRequest) {
        ApiResponse<Coach> apiResponse = new ApiResponse<>();
        apiResponse.setResult(coachService.updateCoach(id, coachRequest));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteCoach(@PathVariable Long id) {
        ApiResponse apiResponse = new ApiResponse<>();
        try {
            if (coachService.deleteCoach(id)) {
                apiResponse.setMessage("Xóa huấn luyện viên thành công");
                apiResponse.setCode(1);
            } else {
                apiResponse.setMessage("Xóa huấn luyện viên thất bại");
                apiResponse.setCode(0);
            }
        } catch (Exception e) {
            // Handle exceptions during deletion (e.g., database errors)
            apiResponse.setMessage("Có lỗi xảy ra khi xóa huấn luyện viên");
            apiResponse.setCode(-1);
            // Log the exception for further investigation
            e.printStackTrace();
        }
        return apiResponse;
    }

    // New method for filtering coaches
//    @GetMapping("/filter")
//    public ApiResponse<List<Coach>> filterCoaches(
//            @RequestParam(required = false) String coachName,
//            @RequestParam(required = false) String country,
//            @RequestParam(required = false) Date dateOfBirth,
//            @RequestParam(required = false) Integer yearsOfExperience) {
//        // Retrieve all coaches using CoachService
//        List<Coach> allCoaches = coachService.findAll();
//
//        // Apply filtering using CoachService's filterCoaches method
//        List<Coach> filteredCoaches = coachService.filterCoaches(allCoaches, coachName, country, String.valueOf(dateOfBirth), yearsOfExperience);
//
//        // Create and return ApiResponse with filtered results
//        ApiResponse<List<Coach>> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(filteredCoaches);
//        return apiResponse;
//    }


//    @Autowired
//    private TeamService teamService;
//
//    @PostMapping("/change-position")
//    public ApiResponse<Player> changePosition(@RequestBody ChangePositionRequest req) {
//        ApiResponse<Player> apiResponse = new ApiResponse<>();
//
//        Player player = playerService.findById(req.getPlayerId());
//        if (player == null) {
//            apiResponse.setCode(0);
//            apiResponse.setMessage("Cầu thủ không tồn tại");
//            return apiResponse;
//        }
//
//        player.setPosition(req.getNewPosition());
//        playerService.save(player);
//
//        apiResponse.setCode(1);
//        apiResponse.setMessage("Cập nhật vị trí cầu thủ thành công");
//        apiResponse.setResult(player);
//
//        return apiResponse;
//    }

}