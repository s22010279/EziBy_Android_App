package com.eziby.eziby_android_app.Models;

public class Category {
    // Default constructor
    public Category() {
    }

    private int categoryId;
    private String categoryName = "";
    private String categoryImage = "";
    private String categoryHeaderImage = "";
    private int displayOrder;
    private Long maxDiscount;
    private boolean active;
    private boolean deleted;
    private String updatedDate;


    // Getters and Setters
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryHeaderImage() {
        return categoryHeaderImage;
    }

    public void setCategoryHeaderImage(String categoryHeaderImage) {
        this.categoryHeaderImage = categoryHeaderImage;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Long getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Long maxDiscount) {
        this.maxDiscount = maxDiscount;
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
