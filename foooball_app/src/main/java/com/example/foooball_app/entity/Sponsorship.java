package com.example.foooball_app.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "sponsorships")
public class Sponsorship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sponsorship_id")
    private int sponsorshipId;


    @Column(name = "team_id")
    private int teamId;

    private int tournament_id;

    private Date startDate;

    private Date endDate;

    private int sponsorshipAmount;
    @ManyToOne
    @JoinColumn(name="sponsor_id", nullable=false)
    @JsonBackReference
    private Sponsor inforSponsor;
    // Getters and setters


    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Sponsor getInforSponsor() {
        return inforSponsor;
    }

    public void setInforSponsor(Sponsor inforSponsor) {
        this.inforSponsor = inforSponsor;
    }

    public int getSponsorshipId() {
        return sponsorshipId;
    }

    public void setSponsorshipId(int sponsorshipId) {
        this.sponsorshipId = sponsorshipId;
    }

//    public Sponsor getSponsor() {
//        return sponsor;
//    }
//
//    public void setSponsor(Sponsor sponsor) {
//        this.sponsor = sponsor;
//    }
//
//    public Set<Team> getTeams() {
//        return teams;
//    }
//
//    public void setTeams(Set<Team> teams) {
//        this.teams = teams;
//    }

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

    public int getSponsorshipAmount() {
        return sponsorshipAmount;
    }

    public void setSponsorshipAmount(int sponsorshipAmount) {
        this.sponsorshipAmount = sponsorshipAmount;
    }

}
