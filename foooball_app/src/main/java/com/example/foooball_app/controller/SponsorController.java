package com.example.foooball_app.controller;
import com.example.foooball_app.dto.response.ApiResponse;
import java.util.List;

import com.example.foooball_app.entity.Sponsorship;
import com.example.foooball_app.service.SponsorService;
import com.example.foooball_app.entity.Sponsor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.foooball_app.dto.request.SponsorRequest;


@Slf4j
@RestController
public class SponsorController {
    @Autowired
    private SponsorService SponsorService;
    @PreAuthorize("hasAnyAuthority('SPONSOR','BTV')")
    @PostMapping("/sponsors")
    ApiResponse<Sponsorship> createSponsor(@RequestBody SponsorRequest req){
        ApiResponse<Sponsorship> apiResponse = new ApiResponse<>();

        apiResponse.setResult(SponsorService.createSponsorService(req));
        return apiResponse;
    }
    @PreAuthorize("hasAnyAuthority('SPONSOR','BTV')")
    @GetMapping("/sponsors")
    ApiResponse<List<Sponsor>> getSponsor(@RequestParam(required = false) String sponsorName , @RequestParam(required = false)  String sponsorType, @RequestParam(required = false)  String country   ){
        ApiResponse<List<Sponsor>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(SponsorService.getSponsorWithService(sponsorName,sponsorType,country));
        return apiResponse;
    }
    @PreAuthorize("hasAnyAuthority('SPONSOR','BTV')")
    @GetMapping("/sponsorships")
    ApiResponse<List<Sponsorship>> getSponsorShip(@RequestParam(required = false) String sponsorName , @RequestParam(required = false)  String sponsorType, @RequestParam(required = false)  String country   ){
        ApiResponse<List<Sponsorship>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(SponsorService.getSponsorShipWithService());
        return apiResponse;
    }
    @PreAuthorize("hasAnyAuthority('SPONSOR','BTV')")
    @PutMapping("/sponsors/{id}")
    ApiResponse<Sponsor> updateSponsor(@PathVariable int id , @RequestBody SponsorRequest req   ){
        ApiResponse<Sponsor> apiResponse = new ApiResponse<>();
        Sponsorship sponsorship = new Sponsorship();
//        sponsorship.setSponsorshipAmount(req.getSponsorshipAmount());
//        sponsorship.setEndDate(req.getEndDate());
//        sponsorship.setStartDate(req.getStartDate());
//        sponsorship.setSponsorshipId(req.getSponsorshipId());
//        System.out.println(req.getSponsorshipId());
        apiResponse.setResult(SponsorService.updateSponsor(id,req,sponsorship));
        return apiResponse;
    }
    @DeleteMapping("/sponsors/{id_sponsor}/{id_sponsorShip}")
    ApiResponse deleteSponsor(@PathVariable int id_sponsor ,@PathVariable int id_sponsorShip  ){
        ApiResponse apiResponse = new ApiResponse<>();
        if(SponsorService.deleteSponsor(id_sponsor,id_sponsorShip)){
            apiResponse.setMessage("Xóa đội bóng thành công");
            apiResponse.setCode(1);
        }else{
            apiResponse.setMessage("Xóa đội bóng thất bại");
            apiResponse.setCode(0);
        }
        return apiResponse;
    }
}
