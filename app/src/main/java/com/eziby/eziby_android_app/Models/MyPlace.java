package com.eziby.eziby_android_app.Models;

public class MyPlace {
    // Default constructor
    public MyPlace() {

    } private int placeId;
    private String emailAddress;
    private String header;
    private String detail;
    private String country;
    private String image;
    private String googleDirection;
    private String dateCreated;
    private int shared;


    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGoogleDirection() {
        return googleDirection;
    }

    public void setGoogleDirection(String googleDirection) {
        this.googleDirection = googleDirection;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getShared() {
        return shared;
    }

    public void setShared(int shared) {
        this.shared = shared;
    }
}
