package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.eziby.eziby_android_app.Models.UOM;

public class DbTableUOM {
    public static final String TABLE_UOM = "UOM";


    public static final String COLUMN_UOM_NAME = "UOMName";
    public static final String COLUMN_UOM_FULL_NAME = "UOMFullName";

    public static final String CREATE_TABLE_UOM = "CREATE TABLE " + TABLE_UOM + " (" +
            DbFieldsCommon.COLUMN_UOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_UOM_NAME + " TEXT NOT NULL, " +
            COLUMN_UOM_FULL_NAME + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";

    @SuppressLint("Range")
    public static UOM fetchData(Cursor result) {
        return null;
    }
}
