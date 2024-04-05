package com.example.foooball_app.repository;

import com.example.foooball_app.entity.Sponsor;
import com.example.foooball_app.entity.Sponsorship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorShipRepository extends JpaRepository<Sponsorship,Integer> {
}
