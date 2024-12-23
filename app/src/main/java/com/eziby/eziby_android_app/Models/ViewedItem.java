package com.eziby.eziby_android_app.Models;

public class ViewedItem {
    private int viewId;
    private int clientId; // Reference to Client
    private int itemId; // Reference to Item
    private int viewedCount;
    private String createdDate; // Using String for date
    private String dateLastViewed; // Using String for date
    private String updatedDate; // Using String for date

    // Getters and Setters
    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

     public int getViewedCount() {
        return viewedCount;
    }

    public void setViewedCount(int viewedCount) {
        this.viewedCount = viewedCount;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDateLastViewed() {
        return dateLastViewed;
    }

    public void setDateLastViewed(String dateLastViewed) {
        this.dateLastViewed = dateLastViewed;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}

