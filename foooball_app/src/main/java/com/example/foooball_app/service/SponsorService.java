package com.example.foooball_app.service;
import com.example.foooball_app.entity.Sponsor;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.example.foooball_app.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.example.foooball_app.dto.request.SponsorRequest;

@Service
public class SponsorService {
    @Autowired
    private SponsorRepository SponsorRepository;

    public List<Sponsor> getSponsorWithService(String sponsorName, String sponsorType , String country){
        List<Sponsor> listSponsor;
        listSponsor = SponsorRepository.findAll();
         return filter(listSponsor,sponsorName,sponsorType,country) ;
    }
    public Sponsor createSponsorService(SponsorRequest req) {
        if(SponsorRepository.existsBySponsorName(req.getSponsorName())) {
            throw new AppError(ErrorCode.SPONSOR_EXISTED);
        }
        Sponsor sponsor = new Sponsor();
        sponsor.setSponsorName(req.getSponsorName());
        sponsor.setSponsorType(req.getSponsorType());
        sponsor.setCountry(req.getCountry());
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
    public Sponsor updateSponsor(int id ,SponsorRequest sponsorData ) {
        Sponsor existingSponsor = SponsorRepository.findById(id).orElseThrow(()-> new AppError(ErrorCode.SPONSOR_UNEXISTED));
            if(sponsorData.getSponsorName()!=null) {
                existingSponsor.setSponsorName(sponsorData.getSponsorName());
            }
            if(sponsorData.getCountry()!=null) {
                existingSponsor.setCountry(sponsorData.getCountry());
           }
        if(sponsorData.getCountry()!=null) {
            existingSponsor.setSponsorType(sponsorData.getSponsorType());
        }
            return SponsorRepository.save(existingSponsor);
    }
    public boolean deleteSponsor(int id  ) {
        SponsorRepository.findById(id).orElseThrow(()-> new AppError(ErrorCode.SPONSOR_UNEXISTED));
        SponsorRepository.deleteById(id);
            return true;

    }
}
