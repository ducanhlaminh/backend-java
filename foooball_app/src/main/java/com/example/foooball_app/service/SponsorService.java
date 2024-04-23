package com.example.foooball_app.service;
import com.example.foooball_app.dto.request.TeamRequest;
import com.example.foooball_app.entity.Sponsor;
import com.example.foooball_app.entity.Sponsorship;
import com.example.foooball_app.entity.Team;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.SponsorRepository;
import com.example.foooball_app.repository.SponsorShipRepository;
import com.example.foooball_app.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.example.foooball_app.dto.request.SponsorRequest;

@Service
public class SponsorService {
    @Autowired
    private SponsorRepository SponsorRepository;
    @Autowired
    private SponsorShipRepository SponsorShipRepository;
    @Autowired
    private TeamRepository TeamRepository;

    public List<Sponsor> getSponsorWithService(String sponsorName, String sponsorType , String country){
        List<Sponsor> listSponsor;
        listSponsor = SponsorRepository.findAll();
        System.out.println(listSponsor.toString());
         return filter(listSponsor,sponsorName,sponsorType,country) ;
    }
    public List<Sponsorship> getSponsorShipWithService(){
        List<Sponsorship> list = SponsorShipRepository.findAll();
        return list ;
    }
    public Sponsorship createSponsorService(SponsorRequest req) {
        Sponsor sponsor = SponsorRepository.findById(req.getSponsorId()).orElseThrow();
            Team team = TeamRepository.findById(req.getTeamId()).orElseThrow();
            Sponsorship sponsorship = new Sponsorship();
            sponsorship.setSponsorshipAmount(req.getSponsorshipAmount());
            sponsorship.setEndDate(req.getEndDate());
            sponsorship.setStartDate(req.getStartDate());
            sponsorship.setTeamInfor(team);

            sponsorship.setInforSponsor(sponsor);
        return SponsorShipRepository.save(sponsorship);
    }
    public List<Sponsor> filter(List<Sponsor> sponsors,String sponsorName, String sponsorType , String country ) {
        List<Sponsor> filteredSponsors;
        filteredSponsors = sponsors.stream()
                .filter(sponsor -> (sponsorName == null || sponsor.getSponsorName().equalsIgnoreCase(sponsorName)))
                .filter(sponsor -> (sponsorType == null || sponsor.getSponsorType().equalsIgnoreCase(sponsorType)))
                .filter(sponsor -> (country == null || sponsor.getCountry().toLowerCase().equals(country)))
                .collect(Collectors.toList());
        return filteredSponsors;
    }
    public Sponsor updateSponsor(int id ,SponsorRequest sponsorData , Sponsorship sponsorshipData ) {
        Sponsor existingSponsor = SponsorRepository.findById(id).orElseThrow(()-> new AppError(ErrorCode.SPONSOR_UNEXISTED));
//                existingSponsor.setSponsorName(sponsorData.getSponsorName());
//                existingSponsor.setCountry(sponsorData.getCountry());
//                existingSponsor.setSponsorType(sponsorData.getSponsorType());
        System.out.println(sponsorshipData.getSponsorshipId());
        Sponsorship existingSponsorship = SponsorShipRepository.findById(sponsorshipData.getSponsorshipId()).orElseThrow(()-> new AppError(ErrorCode.SPONSOR_UNEXISTED));
//        existingSponsorship.setSponsorshipAmount(sponsorData.getSponsorshipAmount());
//        existingSponsorship.setStartDate(sponsorData.getStartDate());
//        existingSponsorship.setEndDate(sponsorData.getEndDate());

        SponsorShipRepository.save(existingSponsorship);
            return SponsorRepository.save(existingSponsor);
    }
    public boolean deleteSponsor(int id_sponsor , int id_sponsorShip  ) {
            Sponsor sponsor = SponsorRepository.findById(id_sponsor).orElseThrow(()-> new AppError(ErrorCode.SPONSOR_UNEXISTED));
            List<Sponsorship> listSponsorShip = sponsor.getSponsorship();
                SponsorShipRepository.deleteById(id_sponsorShip);

            return  true;

    }
}
