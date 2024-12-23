package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.eziby.eziby_android_app.Models.DeliveryTime;

public class DbTableDeliveryTime {
    public static final String TABLE_DELIVERY_TIME = "DeliveryTime";


    public static final String COLUMN_DELIVERY_TIME_NAME = "DeliveryTimeName";

    public static final String CREATE_TABLE_DELIVERY_TIME = "CREATE TABLE " + TABLE_DELIVERY_TIME + " (" +
            DbFieldsCommon.COLUMN_DELIVERY_TIME_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_DELIVERY_TIME_NAME + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";

    @SuppressLint("Range")
    public static DeliveryTime fetchData(Cursor result) {
        return null;
    }
}
