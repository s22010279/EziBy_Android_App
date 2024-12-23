package com.eziby.eziby_android_app.Database;

public class DbTableCustomerPointRedeem {
    public static final String TABLE_CUSTOMER_POINT_REDEEM = "CustomerPointRedeem";


    public static final String COLUMN_REDEEMED_ID = "RedeemedId";
    public static final String COLUMN_CUSTOMER_ID = "CustomerId";
    public static final String COLUMN_POINTS_REDEEMED = "PointsRedeemed";
    public static final String COLUMN_REDEEMED_DATE = "RedeemedDate";
    public static final String CREATE_TABLE_CUSTOMER_POINT_REDEEM = "CREATE TABLE " + TABLE_CUSTOMER_POINT_REDEEM + " (" +
            COLUMN_REDEEMED_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_CUSTOMER_ID + " INTEGER NOT NULL, " +
            COLUMN_POINTS_REDEEMED + " INTEGER NOT NULL, " +
            COLUMN_REDEEMED_DATE + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";

}
