package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.eziby.eziby_android_app.Models.Brand;

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

    @SuppressLint("Range")
    public static Brand fetchData(Cursor result) {
        Brand brand = new Brand();
        brand.setBrandId(Integer.parseInt(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_BRAND_ID))));
        brand.setBrandName(result.getString(result.getColumnIndex(DbTableBrand.COLUMN_BRAND_NAME)));
        brand.setBrandImage(result.getString(result.getColumnIndex(DbTableBrand.COLUMN_BRAND_IMAGE)));
        brand.setDisplayOrder(Integer.parseInt(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_DISPLAY_ORDER))));

        brand.setActive(result.getInt(result.getColumnIndex(DbFieldsCommon.COLUMN_ACTIVE)) == 1);
        brand.setDeleted(result.getInt(result.getColumnIndex(DbFieldsCommon.COLUMN_DELETED)) == 1);

        brand.setUpdatedDate(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_UPDATED_DATE)));
        return brand;
    }
}
