package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.database.Cursor;

import com.eziby.eziby_android_app.Models.Rating;

public class DbTableRating {
    public static final String TABLE_RATING = "Rating";


    public static final String COLUMN_RATING_ID = "RatingId";
    public static final String COLUMN_RATING_STAR = "RatingStar";
    public static final String COLUMN_RATING_REVIEW = "RatingReview";


    public static final String CREATE_TABLE_RATING = "CREATE TABLE " + TABLE_RATING + " (" +
            COLUMN_RATING_ID + " INTEGER PRIMARY KEY, " +
            DbFieldsCommon.COLUMN_ITEM_ID + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_CLIENT_ID + " INTEGER NOT NULL, " +
            COLUMN_RATING_STAR + " INTEGER NOT NULL, " +
            COLUMN_RATING_REVIEW + " TEXT NOT NULL, " +
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_DELETED + " INTEGER NOT NULL, " +
            DbFieldsCommon.COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";

    @SuppressLint("Range")
    public static Rating fetchData(Cursor result) {
        return null;
    }
}
