package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.eziby.eziby_android_app.Models.WishListViewModel;

import java.math.BigDecimal;

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
    public static WishListViewModel readData(Cursor result) {
        WishListViewModel wishListViewModel = new WishListViewModel();
        wishListViewModel.setWishListId(Integer.parseInt(result.getString(result.getColumnIndex(DbTableWishList.COLUMN_WISH_LIST_ID))));
        wishListViewModel.setClientId(Integer.parseInt(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_CLIENT_ID))));
        wishListViewModel.setItemId(Integer.parseInt(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_ITEM_ID))));
        wishListViewModel.setItemName(result.getString(result.getColumnIndex(DbTableItem.COLUMN_ITEM_NAME)));
        wishListViewModel.setItemImage1(result.getString(result.getColumnIndex(DbTableItem.COLUMN_ITEM_IMAGE_1)));
        wishListViewModel.setSellingPrice(new BigDecimal(result.getString(result.getColumnIndex(DbTableItem.COLUMN_SELLING_PRICE))));
        wishListViewModel.setQuantity(Integer.parseInt(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_QUANTITY))));
        wishListViewModel.setCreatedDate(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_CREATED_DATE)));
        wishListViewModel.setDeleted(result.getInt(result.getColumnIndex(DbFieldsCommon.COLUMN_DELETED)) == 1);
        wishListViewModel.setUpdatedDate(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_UPDATED_DATE)));
        return wishListViewModel;
    }
}
