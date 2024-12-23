package com.eziby.eziby_android_app.Database;

public class DbTableItem {
    public static final String TABLE_ITEM = "Item";


    public static final String COLUMN_ITEM_NAME = "ItemName";
    public static final String COLUMN_SPECIFICATION = "Specification";
    public static final String COLUMN_SKU_BARCODE = "SKUBarcode";
    public static final String COLUMN_DIMENSION = "Dimension";
    public static final String COLUMN_ITEM_IMAGE_1 = "ItemImage1";
    public static final String COLUMN_ITEM_IMAGE_2 = "ItemImage2";
    public static final String COLUMN_ITEM_IMAGE_3 = "ItemImage3";
    public static final String COLUMN_STOP_REORDER = "StopReOrder";
    public static final String COLUMN_REORDER_LEVEL = "ReOrderLevel";
    public static final String COLUMN_REORDER_QTY = "ReOrderQty";
    public static final String COLUMN_ALLOW_FRACTION_IN_QTY = "AllowFractionInQty";
    public static final String COLUMN_NON_EXCHANGEABLE = "NonExchangeable";
    public static final String COLUMN_ONE_TIME_PURCHASABLE_QTY = "OneTimePurchasableQty";
    public static final String COLUMN_QTY_ON_HAND = "QtyOnHand";
    public static final String COLUMN_MRP = "MRP";
    public static final String COLUMN_SELLING_PRICE = "SellingPrice";
    public static final String COLUMN_MOB_DISCOUNT_PERCENTAGE = "MOB_DiscountPercentage";
    public static final String COLUMN_IS_AVAILABLE_IN_MOBILE_APP = "IsAvailableInMobileApp";
    public static final String COLUMN_IS_AVAILABLE_IN_POS = "IsAvailableInPOS";
    public static final String COLUMN_IS_NEW_ARRIVAL = "IsNewArrival";
    public static final String COLUMN_IS_TRENDING = "IsTrending";
    public static final String COLUMN_IS_EXPRESS = "IsExpress";
    public static final String COLUMN_TOTAL_SOLD = "TotalSold";
    public static final String COLUMN_TOTAL_CLICKED = "TotalClicked";
    public static final String COLUMN_AVERAGE_RATING = "AverageRating";


    public static final String CREATE_TABLE_ITEM = "CREATE TABLE " + TABLE_ITEM + " (" +
            DbFieldsCommon.COLUMN_ITEM_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_ITEM_NAME + " TEXT NOT NULL, " +
            COLUMN_SPECIFICATION + " TEXT, " +
            COLUMN_SKU_BARCODE + " TEXT, " +
            COLUMN_DIMENSION + " TEXT, " +
            COLUMN_ITEM_IMAGE_1 + " TEXT, " +
            COLUMN_ITEM_IMAGE_2 + " TEXT, " +
            COLUMN_ITEM_IMAGE_3 + " TEXT, " +
            DbFieldsCommon.COLUMN_BRAND_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_CATEGORY_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_SUB_CATEGORY_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_DELIVERY_TIME_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UOM_ID + " INTEGER NOT NULL, " +
            COLUMN_STOP_REORDER + " INTEGER NOT NULL, " +
            COLUMN_REORDER_LEVEL + " INTEGER NOT NULL, " +
            COLUMN_REORDER_QTY + " INTEGER NOT NULL, " +
            COLUMN_ALLOW_FRACTION_IN_QTY + " INTEGER NOT NULL, " +
            COLUMN_NON_EXCHANGEABLE + " INTEGER NOT NULL, " +
            COLUMN_ONE_TIME_PURCHASABLE_QTY + " INTEGER NOT NULL, " +
            COLUMN_QTY_ON_HAND + " INTEGER NOT NULL, " +
            COLUMN_MRP + " REAL NOT NULL, " +
            COLUMN_SELLING_PRICE + " REAL NOT NULL, " +
            COLUMN_MOB_DISCOUNT_PERCENTAGE + " REAL, " +
            COLUMN_IS_AVAILABLE_IN_MOBILE_APP + " INTEGER NOT NULL, " +
            COLUMN_IS_AVAILABLE_IN_POS + " INTEGER NOT NULL, " +
            COLUMN_IS_NEW_ARRIVAL + " INTEGER NOT NULL, " +
            COLUMN_IS_TRENDING + " INTEGER NOT NULL, " +
            COLUMN_IS_EXPRESS + " INTEGER NOT NULL, " +
            COLUMN_TOTAL_SOLD + " INTEGER, " +
            COLUMN_TOTAL_CLICKED + " INTEGER, " +
            COLUMN_AVERAGE_RATING + " REAL, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";

}
