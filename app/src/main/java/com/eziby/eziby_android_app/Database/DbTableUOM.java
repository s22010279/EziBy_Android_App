package com.eziby.eziby_android_app.Database;

public class DbTableUOM {
    public static final String TABLE_UOM = "UOM";


    public static final String COLUMN_UOM_NAME = "UOMName";
    public static final String COLUMN_UOM_FULL_NAME = "UOMFullName";

    public static final String CREATE_TABLE_UOM = "CREATE TABLE " + TABLE_UOM + " (" +
            DbFieldsCommon.COLUMN_UOM_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_UOM_NAME + " TEXT NOT NULL, " +
            COLUMN_UOM_FULL_NAME + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";

}
