package com.example.foooball_app.entity;
import java.sql.Time;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;




    private Player player;

    private String cardType;

    private Time time;

    // Getters and setters
}