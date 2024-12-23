package com.eziby.eziby_android_app.Database;

public class DbTableDeliveryCity {
    public static final String TABLE_DELIVERY_CITY = "DeliveryCity";


    public static final String COLUMN_DELIVERY_CITY_ID = "DeliveryCityId";
    public static final String COLUMN_DELIVERY_CITY_NAME = "DeliveryCityName";
    public static final String COLUMN_DELIVERY_CHARGE = "DeliveryCharge";

    public static final String CREATE_TABLE_DELIVERY_CITY = "CREATE TABLE " + TABLE_DELIVERY_CITY + " (" +
            COLUMN_DELIVERY_CITY_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_DELIVERY_CITY_NAME + " TEXT NOT NULL, " +
            COLUMN_DELIVERY_CHARGE + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";

}
