package com.example.foooball_app.controller;
import com.example.foooball_app.dto.response.ApiResponse;
import java.util.List;
import com.example.foooball_app.service.SponsorService;
import com.example.foooball_app.entity.Sponsor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.foooball_app.dto.request.SponsorRequest;


@Slf4j
@RestController
public class SponsorController {
    @Autowired
    private SponsorService SponsorService;
    @PostMapping("/sponsors")
    ApiResponse<Sponsor> createSponsor(@RequestBody SponsorRequest req){
        ApiResponse<Sponsor> apiResponse = new ApiResponse<>();
        apiResponse.setResult(SponsorService.createSponsorService(req));
        return apiResponse;
    }
    @GetMapping("/sponsors")
    ApiResponse<List<Sponsor>> getSponsor(@RequestParam(required = false) String sponsorName , @RequestParam(required = false)  String sponsorType, @RequestParam(required = false)  String country   ){
        ApiResponse<List<Sponsor>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(SponsorService.getSponsorWithService(sponsorName,sponsorType,country));
        return apiResponse;
    }
    @PutMapping("/sponsors/{id}")
    ApiResponse<Sponsor> updateSponsor(@PathVariable int id , @RequestBody SponsorRequest sponsorData   ){
        ApiResponse<Sponsor> apiResponse = new ApiResponse<>();
        apiResponse.setResult(SponsorService.updateSponsor(id,sponsorData));
        return apiResponse;
    }
    @DeleteMapping("/sponsors/{id}")
    ApiResponse deleteSponsor(@PathVariable int id    ){
        ApiResponse apiResponse = new ApiResponse<>();
        if(SponsorService.deleteSponsor(id)){
            apiResponse.setMessage("Xóa đội bóng thành công");
            apiResponse.setCode(1);
        }else{
            apiResponse.setMessage("Xóa đội bóng thất bại");
            apiResponse.setCode(0);
        }

        return apiResponse;
    }
}
