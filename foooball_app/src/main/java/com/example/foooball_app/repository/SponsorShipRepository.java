package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Sponsor;
import com.example.foooball_app.entity.Sponsorship;
import com.example.foooball_app.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SponsorShipRepository extends JpaRepository<Sponsorship,Integer> {
//    List<Sponsorship> findSponsorshipByF( int team_id);
}

