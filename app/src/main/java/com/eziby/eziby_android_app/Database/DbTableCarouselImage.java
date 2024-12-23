package com.eziby.eziby_android_app.Database;

public class DbTableCarouselImage {
    public static final String TABLE_CAROUSEL_IMAGE = "CarouselImage";


    public static final String COLUMN_CAROUSEL_ID = "CarouselId";
    public static final String COLUMN_CAROUSEL_DETAILS = "CarouselDetails";
    public static final String COLUMN_CAROUSEL_IMAGE_NAME = "CarouselImageName";
    public static final String COLUMN_CAROUSEL_LINK = "CarouselLink";
    public static final String COLUMN_CAROUSEL_TYPE = "CarouselType";
    public static final String CREATE_TABLE_CAROUSEL_IMAGE = "CREATE TABLE " + TABLE_CAROUSEL_IMAGE + " (" +
            COLUMN_CAROUSEL_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_CAROUSEL_DETAILS + " TEXT NOT NULL, " +
            COLUMN_CAROUSEL_IMAGE_NAME + " TEXT NOT NULL, " +
            COLUMN_CAROUSEL_LINK + " TEXT NOT NULL, " +
            COLUMN_CAROUSEL_TYPE + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER NOT NULL, " + // SQLite uses INTEGER for boolean values (0 = false, 1 = true)
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" + // Dates can be stored as TEXT in ISO 8601 format (YYYY-MM-DD HH:MM:SS)
            ");";
}
