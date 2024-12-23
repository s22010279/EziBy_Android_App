package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.eziby.eziby_android_app.Models.ShoppingCartViewModel;

import java.math.BigDecimal;

public class DbTableShoppingCart {
    public static final String TABLE_SHOPPING_CART = "ShoppingCart";


    public static final String COLUMN_SHOPPING_CART_ID = "ShoppingCartId";


    public static final String CREATE_TABLE_SHOPPING_CART = "CREATE TABLE " + TABLE_SHOPPING_CART + " (" +
            COLUMN_SHOPPING_CART_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DbFieldsCommon.COLUMN_CLIENT_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_ITEM_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_QUANTITY + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_CREATED_DATE + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL, " +
            "UNIQUE(" + DbFieldsCommon.COLUMN_CLIENT_ID + ", " + DbFieldsCommon.COLUMN_ITEM_ID + ")" +
            ");";

    @SuppressLint("Range")
    public static ShoppingCartViewModel readData(Cursor result) {
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        shoppingCartViewModel.setShoppingCartId(Integer.parseInt(result.getString(result.getColumnIndex(DbTableShoppingCart.COLUMN_SHOPPING_CART_ID))));
        shoppingCartViewModel.setClientId(Integer.parseInt(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_CLIENT_ID))));
        shoppingCartViewModel.setItemId(Integer.parseInt(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_ITEM_ID))));
        shoppingCartViewModel.setItemName(result.getString(result.getColumnIndex(DbTableItem.COLUMN_ITEM_NAME)));
        shoppingCartViewModel.setItemImage1(result.getString(result.getColumnIndex(DbTableItem.COLUMN_ITEM_IMAGE_1)));
        shoppingCartViewModel.setSellingPrice(new BigDecimal(result.getString(result.getColumnIndex(DbTableItem.COLUMN_SELLING_PRICE))));
        shoppingCartViewModel.setQuantity(Integer.parseInt(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_QUANTITY))));
        shoppingCartViewModel.setCreatedDate(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_CREATED_DATE)));
        shoppingCartViewModel.setDeleted(result.getInt(result.getColumnIndex(DbFieldsCommon.COLUMN_DELETED)) == 1);
        shoppingCartViewModel.setUpdatedDate(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_UPDATED_DATE)));
        return shoppingCartViewModel;
    }
}
