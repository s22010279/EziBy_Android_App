package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.google.firebase.firestore.auth.User;

public class DbTableUser {
    public static final String TABLE_USER = "User";


    public static final String COLUMN_BACKGROUND_MUSIC = "BackgroundMusic";
    public static final String COLUMN_CONTRIBUTION = "Contribution";
    public static final String COLUMN_DISPLAY_NAME = "DisplayName";
    public static final String COLUMN_MEMBER_SINCE = "MemberSince";
    public static final String COLUMN_PROFILE_PICTURE_URI = "ProfilePictureUri";
    public static final String COLUMN_RATINGS = "Ratings";
    public static final String COLUMN_SUBSCRIBED_TO_NEWS_LETTER = "SubscribedToNewsLetter";
    public static final String COLUMN_TOKEN = "Token";
    public static final String COLUMN_USER_ID = "UserId";

    public static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " (" +
            COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            DbFieldsCommon.COLUMN_EMAIL_ADDRESS + " TEXT, " +
            COLUMN_TOKEN + " TEXT, " +
            COLUMN_DISPLAY_NAME + " TEXT, " +
            COLUMN_PROFILE_PICTURE_URI + " TEXT, " +
            COLUMN_SUBSCRIBED_TO_NEWS_LETTER + " TEXT, " +
            COLUMN_BACKGROUND_MUSIC + " TEXT, " +
            COLUMN_CONTRIBUTION + " TEXT, " +
            COLUMN_MEMBER_SINCE + " TEXT, " +
            COLUMN_RATINGS + " TEXT " +
            "); ";

    @SuppressLint("Range")
    public static User fetchData(Cursor result) {
        return null;
    }

}
