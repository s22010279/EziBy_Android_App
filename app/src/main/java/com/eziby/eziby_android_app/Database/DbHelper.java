package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.eziby.eziby_android_app.Models.MyComment;
import com.eziby.eziby_android_app.Models.MyPlace;
import com.eziby.eziby_android_app.Models.MyUser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "wander_lust.db";
    public static final String TABLE_USER = "user_table";
    public static final String TABLE_PLACE = "place_table";
    public static final String TABLE_COMMENT = "comment_table";
    public static final String TABLE_BOOKED_MARKED = "booked_marked_table";
    public static final String COLUMN_BACKGROUND_MUSIC = "backgroundMusic";
    public static final String COLUMN_BOOKED_MARKED_ID = "bookedMarkedId";
    public static final String COLUMN_COMMENT = "comment";
    public static final String COLUMN_COMMENT_ID = "commentId";
    public static final String COLUMN_COMMENTED_DATE = "commentedDate";
    public static final String COLUMN_CONTRIBUTION = "contribution";
    public static final String COLUMN_COUNTRY = "country";
    public static final String COLUMN_DATE_CREATED = "dateCreated";
    public static final String COLUMN_DETAIL = "detail";
    public static final String COLUMN_DISPLAY_NAME = "displayName";
    public static final String COLUMN_EMAIL_ADDRESS = "emailAddress";
    public static final String COLUMN_GOOGLE_DIRECTION = "googleDirection";
    public static final String COLUMN_HEADER = "header";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_MEMBER_SINCE = "memberSince";
    public static final String COLUMN_PLACE_ID = "placeId";
    public static final String COLUMN_PROFILE_PICTURE_URI = "profilePictureUri";
    public static final String COLUMN_RATINGS = "ratings";
    public static final String COLUMN_SHARED = "shared";
    public static final String COLUMN_SUBSCRIBED_TO_NEWS_LETTER = "subscribedToNewsLetter";
    public static final String COLUMN_TOKEN = "token";
    public static final String COLUMN_USER_ID = "userId";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLACE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKED_MARKED);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_USER + " (" +
                COLUMN_USER_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMAIL_ADDRESS + " text, " +
                COLUMN_TOKEN + " text, " +
                COLUMN_DISPLAY_NAME + " text, " +
                COLUMN_PROFILE_PICTURE_URI + " text, " +
                COLUMN_SUBSCRIBED_TO_NEWS_LETTER + " text, " +
                COLUMN_BACKGROUND_MUSIC + " text, " +
                COLUMN_CONTRIBUTION + " text, " +
                COLUMN_MEMBER_SINCE + " text, " +
                COLUMN_RATINGS + " text " +
                "); ");

        db.execSQL("create table " + TABLE_PLACE + " (" +
                COLUMN_PLACE_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMAIL_ADDRESS + " text, " +
                COLUMN_HEADER + " text, " +
                COLUMN_DETAIL + " text, " +
                COLUMN_COUNTRY + " text, " +
                COLUMN_IMAGE + " text, " +
                COLUMN_GOOGLE_DIRECTION + " text, " +
                COLUMN_DATE_CREATED + " text, " +
                COLUMN_SHARED + " text, " +
                "FOREIGN KEY (" + COLUMN_EMAIL_ADDRESS + ") REFERENCES " + TABLE_USER + "(" + COLUMN_EMAIL_ADDRESS + ") " +
                "); ");

        db.execSQL("create table " + TABLE_COMMENT + " (" +
                COLUMN_COMMENT_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PLACE_ID + " integer, " +
                COLUMN_EMAIL_ADDRESS + " text, " +
                COLUMN_COMMENT + " text, " +
                COLUMN_COMMENTED_DATE + " text, " +
                "FOREIGN KEY (" + COLUMN_EMAIL_ADDRESS + ") REFERENCES " + TABLE_USER + "(" + COLUMN_EMAIL_ADDRESS + "), " +
                "FOREIGN KEY (" + COLUMN_PLACE_ID + ") REFERENCES " + TABLE_PLACE + "(" + COLUMN_PLACE_ID + ") " +
                "); ");

        db.execSQL("create table " + TABLE_BOOKED_MARKED + " (" +
                COLUMN_BOOKED_MARKED_ID + " integer PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PLACE_ID + " integer, " +
                COLUMN_EMAIL_ADDRESS + " text, " +
                "FOREIGN KEY (" + COLUMN_EMAIL_ADDRESS + ") REFERENCES " + TABLE_USER + "(" + COLUMN_EMAIL_ADDRESS + "), " +
                "FOREIGN KEY (" + COLUMN_PLACE_ID + ") REFERENCES " + TABLE_PLACE + "(" + COLUMN_PLACE_ID + ") " +
                "); ");
    }

    private String getCurrentDate() {
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());//dd/MM/yyyy
        Date now = new Date();
        return simpleDateFormat.format(now);
    }

    //comment table function
    public boolean insertComment(MyComment myComment) {
        myComment.setCommentedDate(getCurrentDate());

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PLACE_ID, myComment.getPlaceId());
        contentValues.put(COLUMN_EMAIL_ADDRESS, myComment.getEmailAddress());
        contentValues.put(COLUMN_COMMENT, myComment.getComment());
        contentValues.put(COLUMN_COMMENTED_DATE, myComment.getCommentedDate());
        long result = db.insert(TABLE_COMMENT, null, contentValues);

        return result != -1;
    }

    @SuppressLint("Range")
    public List<MyComment> getComments(int placeId) {
        List<MyComment> comments = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_COMMENT + " WHERE " + COLUMN_PLACE_ID + " = " + placeId + " ORDER BY commentId DESC";
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                MyComment myComment = new MyComment();
                myComment.setCommentId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_COMMENT_ID))));
                myComment.setPlaceId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_PLACE_ID))));
                myComment.setEmailAddress(result.getString(result.getColumnIndex(COLUMN_EMAIL_ADDRESS)));
                myComment.setComment(result.getString(result.getColumnIndex(COLUMN_COMMENT)));
                myComment.setCommentedDate(result.getString(result.getColumnIndex(COLUMN_COMMENTED_DATE)));
                comments.add(myComment);
            }
        }
        result.close();
        return comments;
    }

    public Integer deleteComment(int commentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_COMMENT, COLUMN_COMMENT_ID + " = ?", new String[]{String.valueOf(commentId)});
    }

    public void deleteComments(int placeId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COMMENT, COLUMN_PLACE_ID + " = ?", new String[]{String.valueOf(placeId)});
    }

    //place table functions
    public boolean insertPlace(MyPlace myPlace) {
        myPlace.setDateCreated(getCurrentDate());

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL_ADDRESS, myPlace.getEmailAddress());
        contentValues.put(COLUMN_HEADER, myPlace.getHeader());
        contentValues.put(COLUMN_DETAIL, myPlace.getDetail());
        contentValues.put(COLUMN_COUNTRY, myPlace.getCountry());
        contentValues.put(COLUMN_IMAGE, myPlace.getImage());
        contentValues.put(COLUMN_GOOGLE_DIRECTION, myPlace.getGoogleDirection());
        contentValues.put(COLUMN_DATE_CREATED, myPlace.getDateCreated()); //date field
        contentValues.put(COLUMN_SHARED, myPlace.getShared());
        long result = db.insert(TABLE_PLACE, null, contentValues);

        return result != -1;
    }


    public boolean updatePlace(MyPlace myPlace) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL_ADDRESS, myPlace.getEmailAddress());
        contentValues.put(COLUMN_HEADER, myPlace.getHeader());
        contentValues.put(COLUMN_DETAIL, myPlace.getDetail());
        contentValues.put(COLUMN_COUNTRY, myPlace.getCountry());
        contentValues.put(COLUMN_IMAGE, myPlace.getImage());
        contentValues.put(COLUMN_GOOGLE_DIRECTION, myPlace.getGoogleDirection());
        contentValues.put(COLUMN_SHARED, myPlace.getShared());
        db.update(TABLE_PLACE, contentValues, COLUMN_PLACE_ID + " = ?", new String[]{String.valueOf(myPlace.getPlaceId())});
        return true;
    }

    @SuppressLint("Range")
    public List<MyPlace> getPlaces(String emailAddress) {
        List<MyPlace> places = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query;
        if (emailAddress == null) {
            query = "SELECT * FROM " + TABLE_PLACE + " WHERE " + COLUMN_SHARED + " = 1 ORDER BY " + COLUMN_PLACE_ID + " desc";
        } else {
            query = "SELECT * FROM " + TABLE_PLACE + " WHERE " + COLUMN_EMAIL_ADDRESS + " = '" + emailAddress + "'  ORDER BY " + COLUMN_PLACE_ID + " DESC";
        }
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                MyPlace myPlace = new MyPlace();
                myPlace.setPlaceId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_PLACE_ID))));
                myPlace.setEmailAddress(result.getString(result.getColumnIndex(COLUMN_EMAIL_ADDRESS)));
                myPlace.setHeader(result.getString(result.getColumnIndex(COLUMN_HEADER)));
                myPlace.setDetail(result.getString(result.getColumnIndex(COLUMN_DETAIL)));
                myPlace.setCountry(result.getString(result.getColumnIndex(COLUMN_COUNTRY)));
                myPlace.setImage(result.getString(result.getColumnIndex(COLUMN_IMAGE)));
                myPlace.setGoogleDirection(result.getString(result.getColumnIndex(COLUMN_GOOGLE_DIRECTION)));
                myPlace.setDateCreated(result.getString(result.getColumnIndex(COLUMN_DATE_CREATED)));
                myPlace.setShared(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_SHARED))));
                places.add(myPlace);
            }
        }
        result.close();
        return places;
    }

    @SuppressLint("Range")
    public MyPlace getAPlace(int placeId) {
        MyPlace myPlace = new MyPlace();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PLACE + " WHERE " + COLUMN_PLACE_ID + " = " + placeId;
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                myPlace.setPlaceId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_PLACE_ID))));
                myPlace.setEmailAddress(result.getString(result.getColumnIndex(COLUMN_EMAIL_ADDRESS)));
                myPlace.setHeader(result.getString(result.getColumnIndex(COLUMN_HEADER)));
                myPlace.setDetail(result.getString(result.getColumnIndex(COLUMN_DETAIL)));
                myPlace.setCountry(result.getString(result.getColumnIndex(COLUMN_COUNTRY)));
                myPlace.setImage(result.getString(result.getColumnIndex(COLUMN_IMAGE)));
                myPlace.setGoogleDirection(result.getString(result.getColumnIndex(COLUMN_GOOGLE_DIRECTION)));
                myPlace.setDateCreated(result.getString(result.getColumnIndex(COLUMN_DATE_CREATED)));
                myPlace.setShared(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_SHARED))));
            }
        }
        result.close();
        return myPlace;
    }

    public Integer deleteAPlace(int placeId) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_PLACE, COLUMN_PLACE_ID + " = ?", new String[]{String.valueOf(placeId)});
    }

    //user table functions
    public boolean insertUser(MyUser myUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL_ADDRESS, myUser.getEmailAddress());
        contentValues.put(COLUMN_TOKEN, myUser.getToken());
        contentValues.put(COLUMN_DISPLAY_NAME, myUser.getDisplayName());
        contentValues.put(COLUMN_PROFILE_PICTURE_URI, myUser.getProfilePictureUri());
        contentValues.put(COLUMN_SUBSCRIBED_TO_NEWS_LETTER, myUser.isSubscribedToNewsLetter());
        contentValues.put(COLUMN_BACKGROUND_MUSIC, myUser.isBackgroundMusic());
        contentValues.put(COLUMN_CONTRIBUTION, myUser.getContribution());
        contentValues.put(COLUMN_MEMBER_SINCE, myUser.getMemberSince());
        contentValues.put(COLUMN_RATINGS, myUser.getRatings());
        long result = db.insert(TABLE_USER, null, contentValues);

        return result != -1;
    }

    public boolean hasUser(String emailAddress) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_EMAIL_ADDRESS + " = '" + emailAddress + "'", null);
        boolean userFound = result.getCount() > 0;
        result.close();
        return userFound;
    }

    @SuppressLint("Range")
    public MyUser getUser(String emailAddress) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_USER + " WHERE " + COLUMN_EMAIL_ADDRESS + " = '" + emailAddress + "'", null);
        MyUser myUser = new MyUser();
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                myUser.setUserId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_USER_ID))));
                myUser.setEmailAddress(result.getString(result.getColumnIndex(COLUMN_EMAIL_ADDRESS)));
                myUser.setToken(result.getString(result.getColumnIndex(COLUMN_TOKEN)));
                myUser.setDisplayName(result.getString(result.getColumnIndex(COLUMN_DISPLAY_NAME)));
                myUser.setProfilePictureUri(result.getString(result.getColumnIndex(COLUMN_PROFILE_PICTURE_URI)));
                myUser.setSubscribedToNewsLetter(Objects.equals(result.getString(result.getColumnIndex(COLUMN_SUBSCRIBED_TO_NEWS_LETTER)), "1"));
                myUser.setBackgroundMusic(Objects.equals(result.getString(result.getColumnIndex(COLUMN_BACKGROUND_MUSIC)), "1"));
                myUser.setContribution(result.getString(result.getColumnIndex(COLUMN_CONTRIBUTION)));
                myUser.setMemberSince(result.getString(result.getColumnIndex(COLUMN_MEMBER_SINCE)));
                myUser.setRatings(result.getString(result.getColumnIndex(COLUMN_RATINGS)));
            }
        }
        result.close();
        return myUser;
    }

    public void updateUser(MyUser myUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL_ADDRESS, myUser.getEmailAddress());
        contentValues.put(COLUMN_TOKEN, myUser.getToken());
        contentValues.put(COLUMN_DISPLAY_NAME, myUser.getDisplayName());
        contentValues.put(COLUMN_PROFILE_PICTURE_URI, myUser.getProfilePictureUri());
        contentValues.put(COLUMN_SUBSCRIBED_TO_NEWS_LETTER, myUser.isSubscribedToNewsLetter());
        contentValues.put(COLUMN_BACKGROUND_MUSIC, myUser.isBackgroundMusic());
        contentValues.put(COLUMN_CONTRIBUTION, myUser.getContribution());
        contentValues.put(COLUMN_MEMBER_SINCE, myUser.getMemberSince());
        contentValues.put(COLUMN_RATINGS, myUser.getRatings());
        db.update(TABLE_USER, contentValues, COLUMN_USER_ID + " = ?", new String[]{String.valueOf(myUser.getUserId())});
    }
}
