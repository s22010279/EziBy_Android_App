package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.eziby.eziby_android_app.Models.WishList;

public class DbTableWishList {
    public static final String TABLE_WISH_LIST = "WishList";


    public static final String COLUMN_WISH_LIST_ID = "WishListId";

    public static final String CREATE_TABLE_WISH_LIST = "CREATE TABLE " + TABLE_WISH_LIST + " (" +
            COLUMN_WISH_LIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DbFieldsCommon.COLUMN_CLIENT_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_ITEM_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_QUANTITY + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_CREATED_DATE + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL," +
            "UNIQUE(" + DbFieldsCommon.COLUMN_CLIENT_ID + ", " + DbFieldsCommon.COLUMN_ITEM_ID + ")" +
            ");";

    @SuppressLint("Range")
    public static WishList fetchData(Cursor result) {
        return null;
    }
}
