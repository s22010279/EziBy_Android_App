package com.eziby.eziby_android_app.Models;

public class DeliveryTime {
    private int deliveryTimeId;
    private String deliveryTimeName = "";
    private int displayOrder;
    private boolean active;
    private boolean deleted;
    private String updatedDate;

    // Getters and Setters
    public int getDeliveryTimeId() {
        return deliveryTimeId;
    }

    public void setDeliveryTimeId(int deliveryTimeId) {
        this.deliveryTimeId = deliveryTimeId;
    }

    public String getDeliveryTimeName() {
        return deliveryTimeName;
    }

    public void setDeliveryTimeName(String deliveryTimeName) {
        this.deliveryTimeName = deliveryTimeName;
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