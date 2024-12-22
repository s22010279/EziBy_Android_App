package com.eziby.eziby_android_app.Models;

public class CustomerPointRedeem {
    private int redeemedId;
    private int customerId;
    private int pointsRedeemed;
    private String redeemedDate; // Using String for date
    private String updatedDate;  // Using String for date

    // Getters and Setters
    public int getRedeemedId() {
        return redeemedId;
    }

    public void setRedeemedId(int redeemedId) {
        this.redeemedId = redeemedId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPointsRedeemed() {
        return pointsRedeemed;
    }

    public void setPointsRedeemed(int pointsRedeemed) {
        this.pointsRedeemed = pointsRedeemed;
    }

    public String getRedeemedDate() {
        return redeemedDate;
    }

    public void setRedeemedDate(String redeemedDate) {
        this.redeemedDate = redeemedDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}