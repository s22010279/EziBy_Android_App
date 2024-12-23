package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.eziby.eziby_android_app.Models.Brand;
import com.eziby.eziby_android_app.Models.CarouselImage;
import com.eziby.eziby_android_app.Models.Category;
import com.eziby.eziby_android_app.Models.Client;
import com.eziby.eziby_android_app.Models.Item;
import com.eziby.eziby_android_app.Models.MyUser;
import com.eziby.eziby_android_app.Models.Setup;
import com.eziby.eziby_android_app.Models.ShoppingCartViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "EziBy.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbTableSetup.TABLE_SETUP);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableUser.TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableCategory.TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableBrand.TABLE_BRAND);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableCarouselImage.TABLE_CAROUSEL_IMAGE);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableItem.TABLE_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableClient.TABLE_CLIENT);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableCustomerPointRedeem.TABLE_CUSTOMER_POINT_REDEEM);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableDeliveryCity.TABLE_DELIVERY_CITY);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableDeliveryTime.TABLE_DELIVERY_TIME);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableShoppingCart.TABLE_SHOPPING_CART);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableWishList.TABLE_WISH_LIST);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableRating.TABLE_RATING);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableViewedItem.TABLE_VIEWED_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableStatus.TABLE_STATUS);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableUOM.TABLE_UOM);
        db.execSQL("DROP TABLE IF EXISTS " + DbTableSubCategory.TABLE_SUB_CATEGORY);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //region Create table
        db.execSQL(DbTableSetup.CREATE_TABLE_SETUP);
        db.execSQL(DbTableUser.CREATE_TABLE_USER);
        db.execSQL(DbTableCategory.CREATE_TABLE_CATEGORY);
        db.execSQL(DbTableBrand.CREATE_TABLE_BRAND);
        db.execSQL(DbTableCarouselImage.CREATE_TABLE_CAROUSEL_IMAGE);
        db.execSQL(DbTableItem.CREATE_TABLE_ITEM);
        db.execSQL(DbTableClient.CREATE_TABLE_CLIENT);
        db.execSQL(DbTableCustomerPointRedeem.CREATE_TABLE_CUSTOMER_POINT_REDEEM);
        db.execSQL(DbTableDeliveryCity.CREATE_TABLE_DELIVERY_CITY);
        db.execSQL(DbTableDeliveryTime.CREATE_TABLE_DELIVERY_TIME);
        db.execSQL(DbTableShoppingCart.CREATE_TABLE_SHOPPING_CART);
        db.execSQL(DbTableWishList.CREATE_TABLE_WISH_LIST);
        db.execSQL(DbTableRating.CREATE_TABLE_RATING);
        db.execSQL(DbTableViewedItem.CREATE_TABLE_VIEWED_ITEM);
        db.execSQL(DbTableStatus.CREATE_TABLE_STATUS);
        db.execSQL(DbTableUOM.CREATE_TABLE_UOM);
        db.execSQL(DbTableSubCategory.CREATE_TABLE_SUB_CATEGORY);
        //endregion

        //region Insert Data
        db.execSQL(DataScript.INSERT_DATA_SETUPS);
        db.execSQL(DataScript.INSERT_DATA_CATEGORIES);
        db.execSQL(DataScript.INSERT_DATA_BRANDS);
        db.execSQL(DataScript.INSERT_DATA_CAROUSEL_IMAGES);
        db.execSQL(DataScript.INSERT_DATA_ITEMS);
        db.execSQL(DataScript.INSERT_DATA_CLIENTS);
        db.execSQL(DataScript.INSERT_DATA_SHOPPING_CART);
        //endregion
    }

    @SuppressLint("Range")
    public List<CarouselImage> getCarouselImages() {
        List<CarouselImage> carouselImages = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DbTableCarouselImage.TABLE_CAROUSEL_IMAGE +
                " WHERE " + DbFieldsCommon.COLUMN_DELETED + " = " + 0 +
                " AND " + DbFieldsCommon.COLUMN_ACTIVE + " = " + 1 +
                " ORDER BY " + DbFieldsCommon.COLUMN_DISPLAY_ORDER + " ASC";
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                carouselImages.add(DbTableCarouselImage.fetchData(result));
            }
        }
        result.close();
        return carouselImages;
    }

    @SuppressLint("Range")
    public Setup getASetup() {
        Setup setup = new Setup();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DbTableSetup.TABLE_SETUP;
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                setup = DbTableSetup.fetchData(result);
            }
        }
        result.close();
        return setup;
    }

    @SuppressLint("Range")
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DbTableCategory.TABLE_CATEGORY +
                " WHERE " + DbFieldsCommon.COLUMN_DELETED + " = " + 0 +
                " AND " + DbFieldsCommon.COLUMN_ACTIVE + " = " + 1 +
                " ORDER BY " + DbFieldsCommon.COLUMN_DISPLAY_ORDER + " ASC";
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                categories.add(DbTableCategory.fetchData(result));
            }
        }
        result.close();
        return categories;
    }

    @SuppressLint("Range")
    public List<ShoppingCartViewModel> getShoppingCarts(int clientId) {
        List<ShoppingCartViewModel> shoppingCartViewModelList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " +
                DbTableItem.TABLE_ITEM + "." + DbFieldsCommon.COLUMN_ITEM_ID + ", " +
                DbTableItem.TABLE_ITEM + "." + DbTableItem.COLUMN_ITEM_NAME + ", " +
                DbTableItem.TABLE_ITEM + "." + DbTableItem.COLUMN_ITEM_IMAGE_1 + ", " +
                DbTableItem.TABLE_ITEM + "." + DbTableItem.COLUMN_SELLING_PRICE + ", " +

                DbTableShoppingCart.TABLE_SHOPPING_CART + "." + DbTableShoppingCart.COLUMN_SHOPPING_CART_ID + ", " +
                DbTableShoppingCart.TABLE_SHOPPING_CART + "." + DbFieldsCommon.COLUMN_CLIENT_ID + ", " +
                DbTableShoppingCart.TABLE_SHOPPING_CART + "." + DbFieldsCommon.COLUMN_QUANTITY + ", " +
                DbTableShoppingCart.TABLE_SHOPPING_CART + "." + DbFieldsCommon.COLUMN_CREATED_DATE + ", " +
                DbTableShoppingCart.TABLE_SHOPPING_CART + "." + DbFieldsCommon.COLUMN_DELETED + ", " +
                DbTableShoppingCart.TABLE_SHOPPING_CART + "." + DbFieldsCommon.COLUMN_UPDATED_DATE +

                " FROM " + DbTableShoppingCart.TABLE_SHOPPING_CART +
                " INNER JOIN " + DbTableItem.TABLE_ITEM +
                " ON " +
                DbTableItem.TABLE_ITEM + "." + DbFieldsCommon.COLUMN_ITEM_ID + " = " + DbTableShoppingCart.TABLE_SHOPPING_CART + "." + DbFieldsCommon.COLUMN_ITEM_ID +
                " WHERE " +
                DbTableShoppingCart.TABLE_SHOPPING_CART + "." + DbFieldsCommon.COLUMN_CLIENT_ID + " = " + clientId +
                " AND " +
                DbTableItem.TABLE_ITEM + "." + DbFieldsCommon.COLUMN_DELETED + " = " + 0 +
                " AND " +
                DbTableShoppingCart.TABLE_SHOPPING_CART + "." + DbFieldsCommon.COLUMN_DELETED + " = " + 0;

        Log.d("Query", query);

        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                shoppingCartViewModelList.add(DbTableShoppingCart.fetchData(result));
            }
        }
        result.close();
        return shoppingCartViewModelList;
    }

    @SuppressLint("Range")
    public List<Item> getItems(int brandId, int categoryId, int itemId) {
        List<Item> items = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DbTableItem.TABLE_ITEM +
                " WHERE " + DbFieldsCommon.COLUMN_DELETED + " = " + 0 +
                " AND " + DbFieldsCommon.COLUMN_ACTIVE + " = " + 1;
        if (itemId > 0) {//filter for brandID
            query = query + " AND " + DbFieldsCommon.COLUMN_ITEM_ID + " = " + itemId;
        }
        if (brandId > 0) {//filter for brandID
            query = query + " AND " + DbFieldsCommon.COLUMN_BRAND_ID + " = " + brandId;
        }
        if (categoryId > 0) {//filter for categoryID
            query = query + " AND " + DbFieldsCommon.COLUMN_CATEGORY_ID + " = " + categoryId;
        }

        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                items.add(DbTableItem.fetchData(result));
            }
        }
        result.close();
        return items;
    }

    @SuppressLint("Range")
    public List<Brand> getBrands() {
        List<Brand> brands = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DbTableBrand.TABLE_BRAND +
                " WHERE " + DbFieldsCommon.COLUMN_DELETED + " = " + 0 +
                " AND " + DbFieldsCommon.COLUMN_ACTIVE + " = " + 1 +
                " ORDER BY " + DbFieldsCommon.COLUMN_DISPLAY_ORDER + " ASC";
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                brands.add(DbTableBrand.fetchData(result));
            }
        }
        result.close();
        return brands;
    }

    @SuppressLint("Range")
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DbTableClient.TABLE_CLIENT;
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                clients.add(DbTableClient.fetchData(result));
            }
        }
        result.close();
        return clients;
    }


    private String getCurrentDate() {
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());//dd/MM/yyyy
        Date now = new Date();
        return simpleDateFormat.format(now);
    }

    public boolean insertShoppingCart(int itemId, int clientId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbTableShoppingCart.COLUMN_SHOPPING_CART_ID, "");
        contentValues.put(DbFieldsCommon.COLUMN_CLIENT_ID, clientId);
        contentValues.put(DbFieldsCommon.COLUMN_ITEM_ID, itemId);
        contentValues.put(DbFieldsCommon.COLUMN_QUANTITY, "");
        contentValues.put(DbFieldsCommon.COLUMN_CREATED_DATE, "");
        contentValues.put(DbFieldsCommon.COLUMN_DELETED, "");
        contentValues.put(DbFieldsCommon.COLUMN_UPDATED_DATE, "");

        long result = db.insert(DbTableUser.TABLE_USER, null, contentValues);

        return result != -1;
    }

    public boolean insertUser(MyUser myUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbFieldsCommon.COLUMN_EMAIL_ADDRESS, myUser.getEmailAddress());
        contentValues.put(DbTableUser.COLUMN_TOKEN, myUser.getToken());
        contentValues.put(DbTableUser.COLUMN_DISPLAY_NAME, myUser.getDisplayName());
        contentValues.put(DbTableUser.COLUMN_PROFILE_PICTURE_URI, myUser.getProfilePictureUri());
        contentValues.put(DbTableUser.COLUMN_SUBSCRIBED_TO_NEWS_LETTER, myUser.isSubscribedToNewsLetter());
        contentValues.put(DbTableUser.COLUMN_BACKGROUND_MUSIC, myUser.isBackgroundMusic());
        contentValues.put(DbTableUser.COLUMN_CONTRIBUTION, myUser.getContribution());
        contentValues.put(DbTableUser.COLUMN_MEMBER_SINCE, myUser.getMemberSince());
        contentValues.put(DbTableUser.COLUMN_RATINGS, myUser.getRatings());
        long result = db.insert(DbTableUser.TABLE_USER, null, contentValues);

        return result != -1;
    }

    public boolean hasUser(String emailAddress) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + DbTableUser.TABLE_USER + " WHERE " + DbFieldsCommon.COLUMN_EMAIL_ADDRESS + " = '" + emailAddress + "'", null);
        boolean userFound = result.getCount() > 0;
        result.close();
        return userFound;
    }

    @SuppressLint("Range")
    public MyUser getUser(String emailAddress) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM " + DbTableUser.TABLE_USER + " WHERE " + DbFieldsCommon.COLUMN_EMAIL_ADDRESS + " = '" + emailAddress + "'", null);
        MyUser myUser = new MyUser();
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                myUser.setUserId(Integer.parseInt(result.getString(result.getColumnIndex(DbTableUser.COLUMN_USER_ID))));
                myUser.setEmailAddress(result.getString(result.getColumnIndex(DbFieldsCommon.COLUMN_EMAIL_ADDRESS)));
                myUser.setToken(result.getString(result.getColumnIndex(DbTableUser.COLUMN_TOKEN)));
                myUser.setDisplayName(result.getString(result.getColumnIndex(DbTableUser.COLUMN_DISPLAY_NAME)));
                myUser.setProfilePictureUri(result.getString(result.getColumnIndex(DbTableUser.COLUMN_PROFILE_PICTURE_URI)));
                myUser.setSubscribedToNewsLetter(result.getInt(result.getColumnIndex(DbTableUser.COLUMN_SUBSCRIBED_TO_NEWS_LETTER)) == 1);
                myUser.setBackgroundMusic(result.getInt(result.getColumnIndex(DbTableUser.COLUMN_BACKGROUND_MUSIC)) == 1);
                myUser.setContribution(result.getString(result.getColumnIndex(DbTableUser.COLUMN_CONTRIBUTION)));
                myUser.setMemberSince(result.getString(result.getColumnIndex(DbTableUser.COLUMN_MEMBER_SINCE)));
                myUser.setRatings(result.getString(result.getColumnIndex(DbTableUser.COLUMN_RATINGS)));
            }
        }
        result.close();
        return myUser;
    }

    public void updateUser(MyUser myUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbFieldsCommon.COLUMN_EMAIL_ADDRESS, myUser.getEmailAddress());
        contentValues.put(DbTableUser.COLUMN_TOKEN, myUser.getToken());
        contentValues.put(DbTableUser.COLUMN_DISPLAY_NAME, myUser.getDisplayName());
        contentValues.put(DbTableUser.COLUMN_PROFILE_PICTURE_URI, myUser.getProfilePictureUri());
        contentValues.put(DbTableUser.COLUMN_SUBSCRIBED_TO_NEWS_LETTER, myUser.isSubscribedToNewsLetter());
        contentValues.put(DbTableUser.COLUMN_BACKGROUND_MUSIC, myUser.isBackgroundMusic());
        contentValues.put(DbTableUser.COLUMN_CONTRIBUTION, myUser.getContribution());
        contentValues.put(DbTableUser.COLUMN_MEMBER_SINCE, myUser.getMemberSince());
        contentValues.put(DbTableUser.COLUMN_RATINGS, myUser.getRatings());
        db.update(DbTableUser.TABLE_USER, contentValues, DbTableUser.COLUMN_USER_ID + " = ?", new String[]{String.valueOf(myUser.getUserId())});
    }
}

//    //comment table function
//    public boolean insertComment(MyComment myComment) {
//        myComment.setCommentedDate(getCurrentDate());
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_PLACE_ID, myComment.getPlaceId());
//        contentValues.put(COLUMN_EMAIL_ADDRESS, myComment.getEmailAddress());
//        contentValues.put(COLUMN_COMMENT, myComment.getComment());
//        contentValues.put(COLUMN_COMMENTED_DATE, myComment.getCommentedDate());
//        long result = db.insert(TABLE_COMMENT, null, contentValues);
//
//        return result != -1;
//    }
//
//    @SuppressLint("Range")
//    public List<MyComment> getComments(int placeId) {
//        List<MyComment> comments = new ArrayList<>();
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT * FROM " + TABLE_COMMENT + " WHERE " + COLUMN_PLACE_ID + " = " + placeId + " ORDER BY commentId DESC";
//        Cursor result = db.rawQuery(query, null);
//        if (result.getCount() > 0) {
//            while (result.moveToNext()) {
//                MyComment myComment = new MyComment();
//                myComment.setCommentId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_COMMENT_ID))));
//                myComment.setPlaceId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_PLACE_ID))));
//                myComment.setEmailAddress(result.getString(result.getColumnIndex(COLUMN_EMAIL_ADDRESS)));
//                myComment.setComment(result.getString(result.getColumnIndex(COLUMN_COMMENT)));
//                myComment.setCommentedDate(result.getString(result.getColumnIndex(COLUMN_COMMENTED_DATE)));
//                comments.add(myComment);
//            }
//        }
//        result.close();
//        return comments;
//    }
//
//    public Integer deleteComment(int commentId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_COMMENT, COLUMN_COMMENT_ID + " = ?", new String[]{String.valueOf(commentId)});
//    }
//
//    public void deleteComments(int placeId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_COMMENT, COLUMN_PLACE_ID + " = ?", new String[]{String.valueOf(placeId)});
//    }
//
//    //place table functions
//    public boolean insertPlace(MyPlace myPlace) {
//        myPlace.setDateCreated(getCurrentDate());
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_EMAIL_ADDRESS, myPlace.getEmailAddress());
//        contentValues.put(COLUMN_HEADER, myPlace.getHeader());
//        contentValues.put(COLUMN_DETAIL, myPlace.getDetail());
//        contentValues.put(COLUMN_COUNTRY, myPlace.getCountry());
//        contentValues.put(COLUMN_IMAGE, myPlace.getImage());
//        contentValues.put(COLUMN_GOOGLE_DIRECTION, myPlace.getGoogleDirection());
//        contentValues.put(COLUMN_DATE_CREATED, myPlace.getDateCreated()); //date field
//        contentValues.put(COLUMN_SHARED, myPlace.getShared());
//        long result = db.insert(TABLE_PLACE, null, contentValues);
//
//        return result != -1;
//    }
//
//
//    public boolean updatePlace(MyPlace myPlace) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_EMAIL_ADDRESS, myPlace.getEmailAddress());
//        contentValues.put(COLUMN_HEADER, myPlace.getHeader());
//        contentValues.put(COLUMN_DETAIL, myPlace.getDetail());
//        contentValues.put(COLUMN_COUNTRY, myPlace.getCountry());
//        contentValues.put(COLUMN_IMAGE, myPlace.getImage());
//        contentValues.put(COLUMN_GOOGLE_DIRECTION, myPlace.getGoogleDirection());
//        contentValues.put(COLUMN_SHARED, myPlace.getShared());
//        db.update(TABLE_PLACE, contentValues, COLUMN_PLACE_ID + " = ?", new String[]{String.valueOf(myPlace.getPlaceId())});
//        return true;
//    }
//
//    @SuppressLint("Range")
//    public List<MyPlace> getPlaces(String emailAddress) {
//        List<MyPlace> places = new ArrayList<>();
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query;
//        if (emailAddress == null) {
//            query = "SELECT * FROM " + TABLE_PLACE + " WHERE " + COLUMN_SHARED + " = 1 ORDER BY " + COLUMN_PLACE_ID + " desc";
//        } else {
//            query = "SELECT * FROM " + TABLE_PLACE + " WHERE " + COLUMN_EMAIL_ADDRESS + " = '" + emailAddress + "'  ORDER BY " + COLUMN_PLACE_ID + " DESC";
//        }
//        Cursor result = db.rawQuery(query, null);
//        if (result.getCount() > 0) {
//            while (result.moveToNext()) {
//                MyPlace myPlace = new MyPlace();
//                myPlace.setPlaceId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_PLACE_ID))));
//                myPlace.setEmailAddress(result.getString(result.getColumnIndex(COLUMN_EMAIL_ADDRESS)));
//                myPlace.setHeader(result.getString(result.getColumnIndex(COLUMN_HEADER)));
//                myPlace.setDetail(result.getString(result.getColumnIndex(COLUMN_DETAIL)));
//                myPlace.setCountry(result.getString(result.getColumnIndex(COLUMN_COUNTRY)));
//                myPlace.setImage(result.getString(result.getColumnIndex(COLUMN_IMAGE)));
//                myPlace.setGoogleDirection(result.getString(result.getColumnIndex(COLUMN_GOOGLE_DIRECTION)));
//                myPlace.setDateCreated(result.getString(result.getColumnIndex(COLUMN_DATE_CREATED)));
//                myPlace.setShared(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_SHARED))));
//                places.add(myPlace);
//            }
//        }
//        result.close();
//        return places;
//    }
//
//    @SuppressLint("Range")
//    public MyPlace getAPlace(int placeId) {
//        MyPlace myPlace = new MyPlace();
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT * FROM " + TABLE_PLACE + " WHERE " + COLUMN_PLACE_ID + " = " + placeId;
//        Cursor result = db.rawQuery(query, null);
//        if (result.getCount() > 0) {
//            while (result.moveToNext()) {
//                myPlace.setPlaceId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_PLACE_ID))));
//                myPlace.setEmailAddress(result.getString(result.getColumnIndex(COLUMN_EMAIL_ADDRESS)));
//                myPlace.setHeader(result.getString(result.getColumnIndex(COLUMN_HEADER)));
//                myPlace.setDetail(result.getString(result.getColumnIndex(COLUMN_DETAIL)));
//                myPlace.setCountry(result.getString(result.getColumnIndex(COLUMN_COUNTRY)));
//                myPlace.setImage(result.getString(result.getColumnIndex(COLUMN_IMAGE)));
//                myPlace.setGoogleDirection(result.getString(result.getColumnIndex(COLUMN_GOOGLE_DIRECTION)));
//                myPlace.setDateCreated(result.getString(result.getColumnIndex(COLUMN_DATE_CREATED)));
//                myPlace.setShared(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_SHARED))));
//            }
//        }
//        result.close();
//        return myPlace;
//    }
//
//    public Integer deleteAPlace(int placeId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_PLACE, COLUMN_PLACE_ID + " = ?", new String[]{String.valueOf(placeId)});
//    }


