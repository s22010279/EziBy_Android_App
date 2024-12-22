package com.eziby.eziby_android_app.Models;

import java.math.BigDecimal;

public class MobileOrderSub {

    private int mobileOrderSubId;
    private String mobileOrderMainId;
    private int itemId;
    private int quantity;
    private BigDecimal sellingPrice;
    private BigDecimal discountPercentage;
    private BigDecimal discountAmount;
    private BigDecimal discountedSellingPrice;
    private int orderStatusId;
    private String updatedDate;

    // Getters and Setters

    public int getMobileOrderSubId() {
        return mobileOrderSubId;
    }

    public void setMobileOrderSubId(int mobileOrderSubId) {
        this.mobileOrderSubId = mobileOrderSubId;
    }

    public String getMobileOrderMainId() {
        return mobileOrderMainId;
    }

    public void setMobileOrderMainId(String mobileOrderMainId) {
        this.mobileOrderMainId = mobileOrderMainId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getDiscountedSellingPrice() {
        return discountedSellingPrice;
    }

    public void setDiscountedSellingPrice(BigDecimal discountedSellingPrice) {
        this.discountedSellingPrice = discountedSellingPrice;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
