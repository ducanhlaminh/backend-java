package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Sponsor;
import com.example.foooball_app.entity.Sponsorship;
import com.example.foooball_app.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SponsorShipRepository extends JpaRepository<Sponsorship,Integer> {
    List<Sponsorship> findAllByTeamId( int team_id);
}
