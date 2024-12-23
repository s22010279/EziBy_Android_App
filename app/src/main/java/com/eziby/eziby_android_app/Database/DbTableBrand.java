package com.eziby.eziby_android_app.Database;

public class DbTableBrand {
    public static final String TABLE_BRAND = "Brand";


    public static final String COLUMN_BRAND_NAME = "BrandName";
    public static final String COLUMN_BRAND_IMAGE = "BrandImage";
    public static final String CREATE_TABLE_BRAND = "CREATE TABLE " + TABLE_BRAND + " (" +
            DbFieldsCommon.COLUMN_BRAND_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_BRAND_NAME + " TEXT NOT NULL, " +
            COLUMN_BRAND_IMAGE + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER NOT NULL, " + // SQLite uses INTEGER for booleans (0 = false, 1 = true)
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" + // Dates are typically stored as TEXT in ISO 8601 format
            ");";
}
