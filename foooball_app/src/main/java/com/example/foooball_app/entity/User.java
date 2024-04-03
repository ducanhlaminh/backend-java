package com.example.foooball_app.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int userId;


    private String username;


    private String password;


    private String role;


    private Sponsor sponsor;

    // Getters and setters
}
