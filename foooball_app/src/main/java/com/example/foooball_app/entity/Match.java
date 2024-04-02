package com.example.foooball_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    private Date matchDate;

    private String stadium;

    private String result;


    private int tournament_id;


    private Team homeTeam;


    private Team awayTeam;

    // Getters and setters
}