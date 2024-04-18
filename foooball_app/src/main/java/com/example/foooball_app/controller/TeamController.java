package com.example.foooball_app.controller;
import com.example.foooball_app.dto.request.RequestTeemToTournament;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.entity.*;
import com.example.foooball_app.service.TeamService;
import com.example.foooball_app.dto.request.TeamRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;
    @PostMapping("/teams")
//    @PreAuthorize("hasAnyAuthority('BTV')")
    ApiResponse<Team> createTeam(@RequestBody @Valid TeamRequest req){
        ApiResponse<Team> apiResponse = new ApiResponse<>();
        apiResponse.setResult(teamService.createTeamService(req));
        return apiResponse;
    }

    @GetMapping("/teams")
    @PreAuthorize("hasAnyAuthority('SPONSOR','BTV')")

    ApiResponse<List<Team>> getTeam(@RequestParam(required = false) String country , @RequestParam(required = false)  String teamName   ){
        var authen = SecurityContextHolder.getContext().getAuthentication();
//        log.warn(authen.getName());
//        authen.getAuthorities().forEach(grantedAuthority -> log.warn(grantedAuthority.getAuthority()));
        ApiResponse<List<Team>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(teamService.getTeamWithService(country,teamName));
        return apiResponse;
    }
    @PreAuthorize("hasAnyAuthority('BTV')")

    @GetMapping("/teams/sponsor/{team_id}")
    ApiResponse<Sponsorship> getTeam(@PathVariable int team_id   ){
        ApiResponse<Sponsorship> apiResponse = new ApiResponse<>();
        apiResponse.setResult(teamService.getSponsorOfTeam(team_id));
        return apiResponse;
    }
    @PreAuthorize("hasAnyAuthority('SPONSOR','BTV')")
    @PostMapping("/teams-tournament")
    ApiResponse<Tournament> createTeamToTournament(@RequestBody RequestTeemToTournament data   ){
        ApiResponse<Tournament> apiResponse = new ApiResponse<>();
        apiResponse.setResult(teamService.createTeamToTournament(data));
        return apiResponse;
    }
    @PreAuthorize("hasAnyAuthority('BTV')")
    @PutMapping("/teams/{id}")
    ApiResponse<Team> updateTeam(@PathVariable int id , @RequestBody TeamRequest teamData   ){
        ApiResponse<Team> apiResponse = new ApiResponse<>();
        apiResponse.setResult(teamService.updateTeam(id,teamData));
        return apiResponse;
    }
//    @PreAuthorize("hasAnyAuthority('BTV')")

    @DeleteMapping("/teams/{id}")
    ApiResponse deleteTeam(@PathVariable int id    ){
        ApiResponse apiResponse = new ApiResponse<>();
        if(teamService.deleteTeam(id)){
            apiResponse.setMessage("Xóa đội bóng thành công");
            apiResponse.setCode(1);
        }else{
            apiResponse.setMessage("Xóa đội bóng thất bại");
            apiResponse.setCode(0);
        }

        return apiResponse;
    }
}
