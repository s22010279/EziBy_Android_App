package com.eziby.eziby_android_app.Database;

public class DbTableShoppingCart {
    public static final String TABLE_SHOPPING_CART = "ShoppingCart";


    public static final String COLUMN_SHOPPING_CART_ID = "ShoppingCartId";


    public static final String CREATE_TABLE_SHOPPING_CART = "CREATE TABLE " + TABLE_SHOPPING_CART + " (" +
            COLUMN_SHOPPING_CART_ID + " INTEGER PRIMARY KEY, " +
            DbFieldsCommon.COLUMN_CLIENT_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_ITEM_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_QUANTITY + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_CREATED_DATE + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
}
