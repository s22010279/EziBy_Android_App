package com.eziby.eziby_android_app.Database;

public class DbTableStatus {
    public static final String TABLE_STATUS = "Status";


    public static final String COLUMN_STATUS_ID = "StatusId";
    public static final String COLUMN_STATUS_NAME = "StatusName";

    public static final String CREATE_TABLE_STATUS = "CREATE TABLE " + TABLE_STATUS + " (" +
            COLUMN_STATUS_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_STATUS_NAME + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
}