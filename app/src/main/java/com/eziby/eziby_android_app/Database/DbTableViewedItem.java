package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.eziby.eziby_android_app.Models.ViewedItem;

public class DbTableViewedItem {
    public static final String TABLE_VIEWED_ITEM = "ViewedItem";


    public static final String COLUMN_VIEW_ID = "ViewId";
    public static final String COLUMN_VIEWED_COUNT = "ViewedCount";
    public static final String COLUMN_DATE_LAST_VIEWED = "DateLastViewed";

    public static final String CREATE_TABLE_VIEWED_ITEM = "CREATE TABLE " + TABLE_VIEWED_ITEM + " (" +
            COLUMN_VIEW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DbFieldsCommon.COLUMN_CLIENT_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_ITEM_ID + " INTEGER NOT NULL, " +
            COLUMN_VIEWED_COUNT + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_CREATED_DATE + " TEXT NOT NULL, " +
            COLUMN_DATE_LAST_VIEWED + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";

    @SuppressLint("Range")
    public static ViewedItem fetchData(Cursor result) {
        return null;
    }
}
