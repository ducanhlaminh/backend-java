package com.example.foooball_app.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sponsors")
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sponsor_id")
    private int sponsorId;

    @OneToMany(mappedBy="inforSponsor",cascade = CascadeType.ALL)
    private List<Sponsorship> sponsorship = new ArrayList<>();;

    private String sponsorName;

    private String sponsorType;

    private String country;

    public List<Sponsorship> getSponsorship() {
        return sponsorship;
    }

    public void setSponsorship(List<Sponsorship> sponsorship) {
        this.sponsorship = sponsorship;
    }


// Getters and setters

    public int getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(int sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getSponsorType() {
        return sponsorType;
    }

    public void setSponsorType(String sponsorType) {
        this.sponsorType = sponsorType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
