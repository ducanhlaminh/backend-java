package com.example.foooball_app.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "sponsorships")
public class Sponsorship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sponsorshipId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sponsor_id" ,referencedColumnName = "sponsor_id")
    @JsonBackReference
    private Sponsor sponsor;
    @OneToMany(mappedBy = "sponsorships" , cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Team> teams;

    private int tournament_id;

    private Date startDate;

    private Date endDate;

    private int sponsorshipAmount;

    // Getters and setters


    public int getSponsorshipId() {
        return sponsorshipId;
    }

    public void setSponsorshipId(int sponsorshipId) {
        this.sponsorshipId = sponsorshipId;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public int getTournament_id() {
        return tournament_id;
    }

    public void setTournament_id(int tournament_id) {
        this.tournament_id = tournament_id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getSponsorshipAmount() {
        return sponsorshipAmount;
    }

    public void setSponsorshipAmount(int sponsorshipAmount) {
        this.sponsorshipAmount = sponsorshipAmount;
    }
}
