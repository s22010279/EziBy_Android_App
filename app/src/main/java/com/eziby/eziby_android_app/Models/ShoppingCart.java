package com.eziby.eziby_android_app.Models;

public class ShoppingCart {
    private int shoppingCartId;
    private int clientId; // Reference to Client
    private int itemId; // Reference to Item
    private int itemPriceVariantId; // Reference to ItemPriceVariant
    private int quantity;
    private String dateCreated;
    private boolean deleted;
    private String dateUpdated;

    // Getters and Setters
    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
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

    public int getItemPriceVariantId() {
        return itemPriceVariantId;
    }

    public void setItemPriceVariantId(int itemPriceVariantId) {
        this.itemPriceVariantId = itemPriceVariantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}

