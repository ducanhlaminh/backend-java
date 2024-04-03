package com.example.foooball_app.entity;
import java.util.Date;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "coachs")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coachId;

    private String fullName;

    private Date dateOfBirth;

    private String country;

    // Getters and setters
}
