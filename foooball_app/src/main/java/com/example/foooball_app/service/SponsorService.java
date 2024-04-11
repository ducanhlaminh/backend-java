package com.example.foooball_app.service;
import com.example.foooball_app.entity.Sponsor;
import com.example.foooball_app.entity.Sponsorship;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.SponsorRepository;
import com.example.foooball_app.repository.SponsorShipRepository;
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

    public List<Sponsor> getSponsorWithService(String sponsorName, String sponsorType , String country){
        List<Sponsor> listSponsor;
        listSponsor = SponsorRepository.findAll();
        System.out.println(listSponsor.toString());
         return filter(listSponsor,sponsorName,sponsorType,country) ;
    }
    public Sponsor createSponsorService(SponsorRequest req, Sponsorship sponsorshipData) {
        if(SponsorRepository.existsBySponsorName(req.getSponsorName())) {
            throw new AppError(ErrorCode.SPONSOR_EXISTED);
        }

        List<Sponsorship> Sponsorship = new ArrayList<Sponsorship>();
        Sponsorship.add(sponsorshipData);

        Sponsor sponsor = new Sponsor();
        sponsor.setSponsorName(req.getSponsorName());
        sponsor.setSponsorType(req.getSponsorType());
        sponsor.setCountry(req.getCountry());



        sponsor.setSponsorship(Sponsorship);
        sponsorshipData.setInforSponsor(sponsor);
        return SponsorRepository.save(sponsor);
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
                existingSponsor.setSponsorName(sponsorData.getSponsorName());
                existingSponsor.setCountry(sponsorData.getCountry());
                existingSponsor.setSponsorType(sponsorData.getSponsorType());
        System.out.println(sponsorshipData.getSponsorshipId());
        Sponsorship existingSponsorship = SponsorShipRepository.findById(sponsorshipData.getSponsorshipId()).orElseThrow(()-> new AppError(ErrorCode.SPONSOR_UNEXISTED));
        existingSponsorship.setTournament_id(sponsorData.getTournamentId());
        existingSponsorship.setSponsorshipAmount(sponsorData.getSponsorshipAmount());
        existingSponsorship.setTeamId(sponsorData.getTeamId());
        existingSponsorship.setStartDate(sponsorData.getStartDate());
        existingSponsorship.setEndDate(sponsorData.getEndDate());

        SponsorShipRepository.save(existingSponsorship);
            return SponsorRepository.save(existingSponsor);
    }
    public boolean deleteSponsor(int id_sponsor,int id_sponsorship  ) {
        SponsorRepository.findById(id_sponsor).orElseThrow(()-> new AppError(ErrorCode.SPONSOR_UNEXISTED));
        SponsorShipRepository.findById(id_sponsorship).orElseThrow(()-> new AppError(ErrorCode.SPONSOR_UNEXISTED));
        SponsorRepository.deleteById(id_sponsor);
        SponsorShipRepository.deleteById(id_sponsorship);
            return true;

    }
}
