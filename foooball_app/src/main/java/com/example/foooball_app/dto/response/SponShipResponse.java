package com.example.foooball_app.dto.response;

import java.util.Date;

public class SponShipResponse {
    private int sponsorshipId;
    private Date startDate;
    private Date endDate;
    private int sponsorshipAmount;

    public int getSponsorshipId() {
        return sponsorshipId;
    }

    public void setSponsorshipId(int sponsorshipId) {
        this.sponsorshipId = sponsorshipId;
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
