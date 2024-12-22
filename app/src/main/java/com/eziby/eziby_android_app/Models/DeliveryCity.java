package com.eziby.eziby_android_app.Models;

public class DeliveryCity {
    private int deliveryCityId;
    private String deliveryCityName = "";
    private double deliveryCharge;
    private int displayOrder;
    private boolean active;
    private boolean deleted;
    private String updatedDate;

    // Getters and Setters
    public int getDeliveryCityId() {
        return deliveryCityId;
    }

    public void setDeliveryCityId(int deliveryCityId) {
        this.deliveryCityId = deliveryCityId;
    }

    public String getDeliveryCityName() {
        return deliveryCityName;
    }

    public void setDeliveryCityName(String deliveryCityName) {
        this.deliveryCityName = deliveryCityName;
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(double deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
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