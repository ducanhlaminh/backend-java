package com.example.foooball_app.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sponsorId;

    private String sponsorName;

    private String sponsorType;

    private String country;

    // Getters and setters
}
