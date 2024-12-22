package com.eziby.eziby_android_app.Models;

public class Client {
    private int clientId;
    private boolean isGuestMode;
    private String emailAddress = "";
    private String guestId = "";
    private String fullName = "";
    private String phoneNumber = "";
    private boolean phoneVerified = false;
    private boolean emailVerified = false;
    private boolean subscribedForNewsLetters;
    private boolean suspended = false;
    private String suspendedReason = "";
    private String dateCreated;
    private String dateLastLogged;
    private String updatedDate;

    // Getters and Setters
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public boolean isGuestMode() {
        return isGuestMode;
    }

    public void setGuestMode(boolean guestMode) {
        isGuestMode = guestMode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPhoneVerified() {
        return phoneVerified;
    }

    public void setPhoneVerified(boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isSubscribedForNewsLetters() {
        return subscribedForNewsLetters;
    }

    public void setSubscribedForNewsLetters(boolean subscribedForNewsLetters) {
        this.subscribedForNewsLetters = subscribedForNewsLetters;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public String getSuspendedReason() {
        return suspendedReason;
    }

    public void setSuspendedReason(String suspendedReason) {
        this.suspendedReason = suspendedReason;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateLastLogged() {
        return dateLastLogged;
    }

    public void setDateLastLogged(String dateLastLogged) {
        this.dateLastLogged = dateLastLogged;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}

