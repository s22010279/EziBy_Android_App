package com.eziby.eziby_android_app.Database;

public class DbTableSubCategory {
    public static final String TABLE_SUB_CATEGORY = "SubCategory";


    public static final String COLUMN_SUB_CATEGORY_NAME = "SubCategoryName";
    public static final String COLUMN_SUB_CATEGORY_IMAGE = "SubCategoryImage";

    public static final String CREATE_TABLE_SUB_CATEGORY = "CREATE TABLE " + TABLE_SUB_CATEGORY + " (" +
            DbFieldsCommon.COLUMN_SUB_CATEGORY_ID + " INTEGER PRIMARY KEY, " +
            DbFieldsCommon.COLUMN_CATEGORY_ID + " INTEGER NOT NULL, " +
            COLUMN_SUB_CATEGORY_NAME + " TEXT NOT NULL, " +
            COLUMN_SUB_CATEGORY_IMAGE + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
}
