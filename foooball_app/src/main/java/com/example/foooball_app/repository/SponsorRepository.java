package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository extends JpaRepository<Sponsor,Integer> {
    boolean existsBySponsorName( String sponsorName);
}
