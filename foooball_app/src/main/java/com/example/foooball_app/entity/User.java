//package com.example.foooball_app.entity;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "users")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_id")
//    private int userId;
//
//
//    private String username;
//
//
//    private String password;
//    @Column(name = "sponsor_id",insertable=false, updatable=false)
//    private int sponsorId;
//    private String role;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "sponsor_id", referencedColumnName = "sponsor_id")
//    private Sponsor sponsor;
//
//    public int getSponsorId() {
//        return sponsorId;
//    }
//
//    public void setSponsorId(int sponsorId) {
//        this.sponsorId = sponsorId;
//    }
//
//    public Sponsor getSponsor() {
//        return sponsor;
//    }
//
//    public void setSponsor(Sponsor sponsor) {
//        this.sponsor = sponsor;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    // Getters and setters
//}