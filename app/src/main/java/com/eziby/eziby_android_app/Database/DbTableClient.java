package com.eziby.eziby_android_app.Database;

public class DbTableClient {
    public static final String TABLE_CLIENT = "Client";


    public static final String COLUMN_IS_GUEST_MODE = "IsGuestMode";
    public static final String COLUMN_GUEST_ID = "GuestId";
    public static final String COLUMN_FULL_NAME = "FullName";
    public static final String COLUMN_PHONE_NUMBER = "PhoneNumber";
    public static final String COLUMN_PHONE_VERIFIED = "PhoneVerified";
    public static final String COLUMN_EMAIL_VERIFIED = "EmailVerified";
    public static final String COLUMN_SUBSCRIBED_FOR_NEWS_LETTERS = "SubscribedForNewsLetters";
    public static final String COLUMN_SUSPENDED = "Suspended";
    public static final String COLUMN_SUSPENDED_REASON = "SuspendedReason";
    public static final String COLUMN_DATE_LAST_LOGGED = "DateLastLogged";

    public static final String CREATE_TABLE_CLIENT = "CREATE TABLE " + TABLE_CLIENT + " (" +
            DbFieldsCommon.COLUMN_CLIENT_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_IS_GUEST_MODE + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_EMAIL_ADDRESS + " TEXT NOT NULL, " +
            COLUMN_GUEST_ID + " TEXT NOT NULL, " +
            COLUMN_FULL_NAME + " TEXT NOT NULL, " +
            COLUMN_PHONE_NUMBER + " TEXT NOT NULL, " +
            COLUMN_PHONE_VERIFIED + " INTEGER NOT NULL, " +
            COLUMN_EMAIL_VERIFIED + " INTEGER NOT NULL, " +
            COLUMN_SUBSCRIBED_FOR_NEWS_LETTERS + " INTEGER NOT NULL, " +
            COLUMN_SUSPENDED + " INTEGER NOT NULL, " +
            COLUMN_SUSPENDED_REASON + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_CREATED_DATE + " TEXT NOT NULL, " +
            COLUMN_DATE_LAST_LOGGED + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
}
