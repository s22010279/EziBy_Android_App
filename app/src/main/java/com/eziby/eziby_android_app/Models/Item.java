package com.eziby.eziby_android_app.Models;

import java.math.BigDecimal;

public class Item {
    public Item() {
    }

    private int itemId;
    private String itemName = "";
    private String specification = "";
    private String skuBarcode = "";
    private String dimension = "";
    private String itemImage1 = "";
    private String itemImage2 = "";
    private String itemImage3 = "";

    private int brandId;
    private int categoryId;
    private int subCategoryId;
    private int deliveryTimeId;
    private int uomId;
    private boolean stopReOrder;
    private int reOrderLevel;
    private int reOrderQty;

    private boolean allowFractionInQty;
    private boolean nonExchangeable;
    private int oneTimePurchasableQty;

    private int qtyOnHand;
    private BigDecimal mrp;
    private BigDecimal sellingPrice;
    private BigDecimal mobDiscountPercentage;

    private boolean isAvailableInMobileApp;
    private boolean isAvailableInPOS;
    private boolean isNewArrival;
    private boolean isTrending;
    private boolean isExpress;

    private int totalSold;
    private int totalClicked;
    private BigDecimal averageRating;
    private boolean active;
    private boolean deleted;
    private String updatedDate;

    // Getters and Setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getSkuBarcode() {
        return skuBarcode;
    }

    public void setSkuBarcode(String skuBarcode) {
        this.skuBarcode = skuBarcode;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getItemImage1() {
        return itemImage1;
    }

    public void setItemImage1(String itemImage1) {
        this.itemImage1 = itemImage1;
    }

    public String getItemImage2() {
        return itemImage2;
    }

    public void setItemImage2(String itemImage2) {
        this.itemImage2 = itemImage2;
    }

    public String getItemImage3() {
        return itemImage3;
    }

    public void setItemImage3(String itemImage3) {
        this.itemImage3 = itemImage3;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public int getDeliveryTimeId() {
        return deliveryTimeId;
    }

    public void setDeliveryTimeId(int deliveryTimeId) {
        this.deliveryTimeId = deliveryTimeId;
    }

    public int getUomId() {
        return uomId;
    }

    public void setUomId(int uomId) {
        this.uomId = uomId;
    }

    public boolean isStopReOrder() {
        return stopReOrder;
    }

    public void setStopReOrder(boolean stopReOrder) {
        this.stopReOrder = stopReOrder;
    }

    public int getReOrderLevel() {
        return reOrderLevel;
    }

    public void setReOrderLevel(int reOrderLevel) {
        this.reOrderLevel = reOrderLevel;
    }

    public int getReOrderQty() {
        return reOrderQty;
    }

    public void setReOrderQty(int reOrderQty) {
        this.reOrderQty = reOrderQty;
    }

    public boolean isAllowFractionInQty() {
        return allowFractionInQty;
    }

    public void setAllowFractionInQty(boolean allowFractionInQty) {
        this.allowFractionInQty = allowFractionInQty;
    }

    public boolean isNonExchangeable() {
        return nonExchangeable;
    }

    public void setNonExchangeable(boolean nonExchangeable) {
        this.nonExchangeable = nonExchangeable;
    }

    public int getOneTimePurchasableQty() {
        return oneTimePurchasableQty;
    }

    public void setOneTimePurchasableQty(int oneTimePurchasableQty) {
        this.oneTimePurchasableQty = oneTimePurchasableQty;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public BigDecimal getMrp() {
        return mrp;
    }

    public void setMrp(BigDecimal mrp) {
        this.mrp = mrp;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getMobDiscountPercentage() {
        return mobDiscountPercentage;
    }

    public void setMobDiscountPercentage(BigDecimal mobDiscountPercentage) {
        this.mobDiscountPercentage = mobDiscountPercentage;
    }

    public boolean isAvailableInMobileApp() {
        return isAvailableInMobileApp;
    }

    public void setAvailableInMobileApp(boolean availableInMobileApp) {
        isAvailableInMobileApp = availableInMobileApp;
    }

    public boolean isAvailableInPOS() {
        return isAvailableInPOS;
    }

    public void setAvailableInPOS(boolean availableInPOS) {
        isAvailableInPOS = availableInPOS;
    }

    public boolean isNewArrival() {
        return isNewArrival;
    }

    public void setNewArrival(boolean newArrival) {
        isNewArrival = newArrival;
    }

    public boolean isTrending() {
        return isTrending;
    }

    public void setTrending(boolean trending) {
        isTrending = trending;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public void setExpress(boolean express) {
        isExpress = express;
    }

    public int getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(int totalSold) {
        this.totalSold = totalSold;
    }

    public int getTotalClicked() {
        return totalClicked;
    }

    public void setTotalClicked(int totalClicked) {
        this.totalClicked = totalClicked;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
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
