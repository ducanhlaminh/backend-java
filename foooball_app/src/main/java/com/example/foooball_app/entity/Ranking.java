package com.example.foooball_app.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "rankings")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rankingId;

    private int tournament_id;

//    private Team team;

    private int points;

    private int matchesPlayed;

    private int wins;

    private int draws;

    private int losses;

    private int goalsFor;

    private int goalsAgainst;

    // Getters and setters
}
