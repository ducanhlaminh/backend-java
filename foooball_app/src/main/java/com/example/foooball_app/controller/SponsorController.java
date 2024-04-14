package com.example.foooball_app.controller;
import com.example.foooball_app.dto.response.ApiResponse;
import java.util.List;

import com.example.foooball_app.entity.Sponsorship;
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
        Sponsorship sponsorship = new Sponsorship();
        sponsorship.setSponsorshipAmount(req.getSponsorshipAmount());
        sponsorship.setEndDate(req.getEndDate());
        sponsorship.setStartDate(req.getStartDate());
        apiResponse.setResult(SponsorService.createSponsorService(req,sponsorship));
        return apiResponse;
    }

    @GetMapping("/sponsors")
    ApiResponse<List<Sponsor>> getSponsor(@RequestParam(required = false) String sponsorName , @RequestParam(required = false)  String sponsorType, @RequestParam(required = false)  String country   ){
        ApiResponse<List<Sponsor>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(SponsorService.getSponsorWithService(sponsorName,sponsorType,country));
        return apiResponse;
    }

    @PutMapping("/sponsors/{id}")
    ApiResponse<Sponsor> updateSponsor(@PathVariable int id , @RequestBody SponsorRequest req   ){
        ApiResponse<Sponsor> apiResponse = new ApiResponse<>();
        Sponsorship sponsorship = new Sponsorship();
        sponsorship.setSponsorshipAmount(req.getSponsorshipAmount());
        sponsorship.setEndDate(req.getEndDate());
        sponsorship.setStartDate(req.getStartDate());
        sponsorship.setSponsorshipId(req.getSponsorshipId());
        System.out.println(req.getSponsorshipId());
        apiResponse.setResult(SponsorService.updateSponsor(id,req,sponsorship));
        return apiResponse;
    }
    @DeleteMapping("/sponsors/{id_sponsor}/{id_sponsorship}")
    ApiResponse deleteSponsor(@PathVariable int id_sponsor, @PathVariable int id_sponsorship    ){
        ApiResponse apiResponse = new ApiResponse<>();
        if(SponsorService.deleteSponsor(id_sponsor,id_sponsorship)){
            apiResponse.setMessage("Xóa đội bóng thành công");
            apiResponse.setCode(1);
        }else{
            apiResponse.setMessage("Xóa đội bóng thất bại");
            apiResponse.setCode(0);
        }

        return apiResponse;
    }
}
