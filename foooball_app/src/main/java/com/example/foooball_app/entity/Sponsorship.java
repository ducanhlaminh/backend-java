package com.example.foooball_app.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private int sponsorshipId;


    private Date startDate;

    private Date endDate;

    private int sponsorshipAmount;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties("tournamentTeam")
    private Team teamInfor;

    @ManyToOne
    @JoinColumn(name="sponsor_id", nullable=false)
    private Sponsor inforSponsor;
    // Getters and setters


    public Team getTeamInfor() {
        return teamInfor;
    }

    public void setTeamInfor(Team teamInfor) {
        this.teamInfor = teamInfor;
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
