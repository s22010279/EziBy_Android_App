package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.eziby.eziby_android_app.Models.Category;

public class DbTableCategory {
    public static final String TABLE_CATEGORY = "Category";


    public static final String COLUMN_CATEGORY_NAME = "CategoryName";
    public static final String COLUMN_CATEGORY_IMAGE = "CategoryImage";
    public static final String COLUMN_CATEGORY_HEADER_IMAGE = "CategoryHeaderImage";
    public static final String COLUMN_MAX_DISCOUNT = "MaxDiscount";
    public static final String CREATE_TABLE_CATEGORY = "CREATE TABLE " + TABLE_CATEGORY + " (" +
            DbFieldsCommon.COLUMN_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_CATEGORY_NAME + " TEXT, " +
            COLUMN_CATEGORY_IMAGE + " TEXT, " +
            COLUMN_CATEGORY_HEADER_IMAGE + " TEXT, " +
            DbFieldsCommon.COLUMN_DISPLAY_ORDER + " INTEGER, " +
            COLUMN_MAX_DISCOUNT + " TEXT, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT " +
            "); ";

    @SuppressLint("Range")
    public static Category fetchData(Cursor result) {
        Category category = new Category();
        category.setCategoryId(Integer.parseInt(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_CATEGORY_ID))));
        category.setCategoryName(result.getString(result.getColumnIndex(DbTableCategory.COLUMN_CATEGORY_NAME)));
        category.setCategoryImage(result.getString(result.getColumnIndex(DbTableCategory.COLUMN_CATEGORY_IMAGE)));
        category.setCategoryHeaderImage(result.getString(result.getColumnIndex(DbTableCategory.COLUMN_CATEGORY_HEADER_IMAGE)));
        category.setDisplayOrder(Integer.parseInt(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_DISPLAY_ORDER))));
        category.setMaxDiscount(Long.parseLong(result.getString(result.getColumnIndex(DbTableCategory.COLUMN_MAX_DISCOUNT))));
        category.setActive(result.getInt(result.getColumnIndex(DbFieldsCommon.COLUMN_ACTIVE)) == 1);
        category.setDeleted(result.getInt(result.getColumnIndex(DbFieldsCommon.COLUMN_DELETED)) == 1);
        category.setUpdatedDate(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_UPDATED_DATE)));
        return category;
    }
}
