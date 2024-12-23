package com.eziby.eziby_android_app.Database;

public class DbTableCategory {
    public static final String TABLE_CATEGORY = "Category";


    public static final String COLUMN_CATEGORY_NAME = "CategoryName";
    public static final String COLUMN_CATEGORY_IMAGE = "CategoryImage";
    public static final String COLUMN_CATEGORY_HEADER_IMAGE = "CategoryHeaderImage";
    public static final String COLUMN_MAX_DISCOUNT = "MaxDiscount";
    public static final String CREATE_TABLE_CATEGORY = "CREATE TABLE " + TABLE_CATEGORY + " (" +
            DbFieldsCommon.COLUMN_CATEGORY_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_CATEGORY_NAME + " TEXT, " +
            COLUMN_CATEGORY_IMAGE + " TEXT, " +
            COLUMN_CATEGORY_HEADER_IMAGE + " TEXT, " +
            DbFieldsCommon.COLUMN_DISPLAY_ORDER + " INTEGER, " +
            COLUMN_MAX_DISCOUNT + " TEXT, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT " +
            "); ";

}
