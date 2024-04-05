package com.example.foooball_app.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
@Table(name = "sponsorships")
public class Sponsorship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sponsorshipId;

    private Sponsor sponsor;

//    private Team team;

    private int tournament_id;

    private Date startDate;

    private Date endDate;

    private double sponsorshipAmount;

    // Getters and setters
}
