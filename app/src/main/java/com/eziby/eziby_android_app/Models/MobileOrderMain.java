package com.eziby.eziby_android_app.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MobileOrderMain {

    private String mobileOrderMainId;
    private String orderGUID;
    private LocalDateTime orderDate;
    private int orderStatusId;
    private String orderStatusUpdatedDate;
    private int clientId;
    private int paidStatusId;
    private String deliveredDateTime;
    private String deliveryFullName;
    private String deliveryEmail;
    private String deliveryPhone;
    private String deliveryAddress;
    private int deliveryCityId;
    private String deliveryNote;
    private BigDecimal totalAmount;
    private BigDecimal pointAmount;
    private BigDecimal deliveryCharge;
    private BigDecimal grandTotal;
    private String deliveryGoogleGeoLocation;
    private String paymentMethod;
    private String environment;
    private String updatedDate;

    // Getters and Setters

    public String getMobileOrderMainId() {
        return mobileOrderMainId;
    }

    public void setMobileOrderMainId(String mobileOrderMainId) {
        this.mobileOrderMainId = mobileOrderMainId;
    }

    public String getOrderGUID() {
        return orderGUID;
    }

    public void setOrderGUID(String orderGUID) {
        this.orderGUID = orderGUID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public String getOrderStatusUpdatedDate() {
        return orderStatusUpdatedDate;
    }

    public void setOrderStatusUpdatedDate(String orderStatusUpdatedDate) {
        this.orderStatusUpdatedDate = orderStatusUpdatedDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getPaidStatusId() {
        return paidStatusId;
    }

    public void setPaidStatusId(int paidStatusId) {
        this.paidStatusId = paidStatusId;
    }

    public String getDeliveredDateTime() {
        return deliveredDateTime;
    }

    public void setDeliveredDateTime(String deliveredDateTime) {
        this.deliveredDateTime = deliveredDateTime;
    }

    public String getDeliveryFullName() {
        return deliveryFullName;
    }

    public void setDeliveryFullName(String deliveryFullName) {
        this.deliveryFullName = deliveryFullName;
    }

    public String getDeliveryEmail() {
        return deliveryEmail;
    }

    public void setDeliveryEmail(String deliveryEmail) {
        this.deliveryEmail = deliveryEmail;
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getDeliveryCityId() {
        return deliveryCityId;
    }

    public void setDeliveryCityId(int deliveryCityId) {
        this.deliveryCityId = deliveryCityId;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPointAmount() {
        return pointAmount;
    }

    public void setPointAmount(BigDecimal pointAmount) {
        this.pointAmount = pointAmount;
    }

    public BigDecimal getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(BigDecimal deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getDeliveryGoogleGeoLocation() {
        return deliveryGoogleGeoLocation;
    }

    public void setDeliveryGoogleGeoLocation(String deliveryGoogleGeoLocation) {
        this.deliveryGoogleGeoLocation = deliveryGoogleGeoLocation;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
