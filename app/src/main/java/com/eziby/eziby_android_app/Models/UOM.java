package com.eziby.eziby_android_app.Models;

public class UOM {
    private int uomId;
    private String uomName = "";
    private String uomFullName = "";
    private boolean active;
    private boolean deleted;
    private String updatedDate; // Using String for date

    // Getters and Setters
    public int getUomId() {
        return uomId;
    }

    public void setUomId(int uomId) {
        this.uomId = uomId;
    }

    public String getUomName() {
        return uomName;
    }

    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    public String getUomFullName() {
        return uomFullName;
    }

    public void setUomFullName(String uomFullName) {
        this.uomFullName = uomFullName;
    }

    // Computed property equivalent
    public String getUomNameWithFullName() {
        return uomName + "-" + uomFullName;
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

