package com.eziby.eziby_android_app.Models;

public class CarouselImage {
    // Default constructor
    public CarouselImage() {
    }

    private int carouselId;
    private String carouselDetails;
    private String carouselImageName;
    private String carouselLink;
    private String carouselType;
    private int displayOrder;
    private boolean active;
    private boolean deleted;
    private String updatedDate;


    // Getters and Setters
    public int getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(int carouselId) {
        this.carouselId = carouselId;
    }

    public String getCarouselDetails() {
        return carouselDetails;
    }

    public void setCarouselDetails(String carouselDetails) {
        this.carouselDetails = carouselDetails;
    }

    public String getCarouselImageName() {
        return carouselImageName;
    }

    public void setCarouselImageName(String carouselImageName) {
        this.carouselImageName = carouselImageName;
    }

    public String getCarouselLink() {
        return carouselLink;
    }

    public void setCarouselLink(String carouselLink) {
        this.carouselLink = carouselLink;
    }

    public String getCarouselType() {
        return carouselType;
    }

    public void setCarouselType(String carouselType) {
        this.carouselType = carouselType;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}

