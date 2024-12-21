package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.eziby.eziby_android_app.Models.Brand;
import com.eziby.eziby_android_app.Models.Category;
import com.eziby.eziby_android_app.Models.MyUser;
import com.eziby.eziby_android_app.Models.Setup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class DbHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "EziBy.db";
    public static final String TABLE_SETUP = "Setups";
    public static final String TABLE_USER = "user_table";
    public static final String TABLE_CATEGORIES = "Categories";
    public static final String TABLE_BRANDS = "Brands";
    //columns for Setup table - start
    public static final String COLUMN_SETUP_ID = "SetupId";
    public static final String COLUMN_BRANCH_NAME = "BranchName";
    public static final String COLUMN_BRANCH_DESCRIPTION = "BranchDescription";
    public static final String COLUMN_BRANCH_ADDRESS = "BranchAddress";
    public static final String COLUMN_BRANCH_LAND_PHONE = "BranchLandPhone";
    public static final String COLUMN_BRANCH_MOBILE = "BranchMobile";
    public static final String COLUMN_CURRENCY_MARK = "CurrencyMark";
    public static final String COLUMN_CURRENCY_DECIMALS = "CurrencyDecimals";
    public static final String COLUMN_INITIAL_DELIVERY_DAYS = "InitialDeliveryDays";
    public static final String COLUMN_MAXIMUM_DELIVERY_DAYS = "MaximumDeliveryDays";
    public static final String COLUMN_ANDROID_ONGOING_MAINTENANCE = "Android_OnGoingMaintenance";
    public static final String COLUMN_ANDROID_FORCE_UPDATE = "Android_ForceUpdate";
    public static final String COLUMN_ANDROID_BUILD_NUMBER = "Android_BuildNumber";
    public static final String COLUMN_MAIN_API_URI = "MainAPIUri";
    public static final String COLUMN_MAIN_SLIDESHOW_IMAGES_URI = "MainSlideShowImagesUri";
    public static final String COLUMN_CATEGORY_IMAGES_URI = "CategoryImagesUri";
    public static final String COLUMN_CATEGORY_HEADER_URI = "CategoryHeaderUri";
    public static final String COLUMN_SUBCATEGORY_IMAGES_URI = "SubCategoryImagesUri";
    public static final String COLUMN_ITEMS_IMAGE_URI = "ItemsImageUri";
    public static final String COLUMN_BRAND_IMAGE_URI = "BrandImageUri";
    public static final String COLUMN_SOCIAL_MEDIA_URI = "SocialMediaUri";
    public static final String COLUMN_ADVERTISEMENT_IMAGE_URI = "AdvertisementImageUri";
    public static final String COLUMN_OTHER_IMAGE_URI = "OtherImageUri";
    public static final String COLUMN_TERMS_AND_CONDITIONS_URI = "TermsAndConditionsUri";
    public static final String COLUMN_PRIVACY_POLICY_URI = "PrivacyPolicyUri";
    public static final String COLUMN_OUR_SERVICES_URI = "OurServicesUri";
    public static final String COLUMN_CONTACT_US_URI = "ContactUsUri";
    public static final String COLUMN_ABOUT_US_URI = "AboutUsUri";
    public static final String COLUMN_SERVER_MAPPED_IMAGE_PATH = "ServerMappedImagePath";
    public static final String COLUMN_NEW_ORDER_REFRESH_INTERVAL = "NewOrderRefreshInterval";
    public static final String COLUMN_ALLOW_DISCOUNT_IN_POS = "AllowDiscountInPOS";
    public static final String COLUMN_CRYSTAL_REPORT_PATH = "CrystalReportPath";
    public static final String COLUMN_ACTIVE = "Active";
    //columns for Category table - start
    public static final String COLUMN_CATEGORY_ID = "CategoryId";
    public static final String COLUMN_CATEGORY_NAME = "CategoryName";
    public static final String COLUMN_CATEGORY_IMAGE = "CategoryImage";
    public static final String COLUMN_CATEGORY_HEADER_IMAGE = "CategoryHeaderImage";
    //columns for Setup table - end
    public static final String COLUMN_DISPLAY_ORDER = "DisplayOrder";
    public static final String COLUMN_MAX_DISCOUNT = "MaxDiscount";
    public static final String COLUMN_DELETED = "Deleted";
    public static final String COLUMN_UPDATED_DATE = "UpdatedDate";
    public static final String CREATE_TABLE_CATEGORIES = "create table " + TABLE_CATEGORIES + " (" +
            COLUMN_CATEGORY_ID + " integer PRIMARY KEY, " +
            COLUMN_CATEGORY_NAME + " text, " +
            COLUMN_CATEGORY_IMAGE + " text, " +
            COLUMN_CATEGORY_HEADER_IMAGE + " text, " +
            COLUMN_DISPLAY_ORDER + " integer, " +
            COLUMN_MAX_DISCOUNT + " text, " +
            COLUMN_ACTIVE + " integer, " +
            COLUMN_DELETED + " integer, " +
            COLUMN_UPDATED_DATE + " text " +
            "); ";
    //columns for User table - start
    public static final String COLUMN_BACKGROUND_MUSIC = "backgroundMusic";
    public static final String COLUMN_CONTRIBUTION = "contribution";
    public static final String COLUMN_DISPLAY_NAME = "displayName";
    public static final String COLUMN_EMAIL_ADDRESS = "emailAddress";
    //columns for Category table - end
    public static final String COLUMN_MEMBER_SINCE = "memberSince";
    public static final String COLUMN_PROFILE_PICTURE_URI = "profilePictureUri";
    public static final String COLUMN_RATINGS = "ratings";
    public static final String COLUMN_SUBSCRIBED_TO_NEWS_LETTER = "subscribedToNewsLetter";
    public static final String COLUMN_TOKEN = "token";
    public static final String COLUMN_USER_ID = "userId";
    //columns for Brand table - start
    public static final String COLUMN_BRAND_ID = "BrandId";
    public static final String COLUMN_BRAND_NAME = "BrandName";
    public static final String COLUMN_BRAND_IMAGE = "BrandImage";
    public static final String CREATE_TABLE_BRANDS =
            "CREATE TABLE " + TABLE_BRANDS + " (" +
                    COLUMN_BRAND_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_BRAND_NAME + " TEXT NOT NULL, " +
                    COLUMN_BRAND_IMAGE + " TEXT NOT NULL, " +
                    COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
                    COLUMN_ACTIVE + " INTEGER NOT NULL, " + // SQLite uses INTEGER for booleans (0 = false, 1 = true)
                    COLUMN_DELETED + " INTEGER NOT NULL, " +
                    COLUMN_UPDATED_DATE + " TEXT NOT NULL" + // Dates are typically stored as TEXT in ISO 8601 format
                    ");";
    private static final String CREATE_TABLE_SETUP = "CREATE TABLE " + TABLE_SETUP + " (" +
            COLUMN_SETUP_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_BRANCH_NAME + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_BRANCH_DESCRIPTION + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_BRANCH_ADDRESS + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_BRANCH_LAND_PHONE + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_BRANCH_MOBILE + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_CURRENCY_MARK + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_CURRENCY_DECIMALS + " INTEGER NOT NULL DEFAULT 0, " +
            COLUMN_INITIAL_DELIVERY_DAYS + " INTEGER NOT NULL DEFAULT 0, " +
            COLUMN_MAXIMUM_DELIVERY_DAYS + " INTEGER NOT NULL DEFAULT 0, " +
            COLUMN_ANDROID_ONGOING_MAINTENANCE + " INTEGER NOT NULL DEFAULT 0, " +
            COLUMN_ANDROID_FORCE_UPDATE + " INTEGER NOT NULL DEFAULT 0, " +
            COLUMN_ANDROID_BUILD_NUMBER + " INTEGER NOT NULL DEFAULT 0, " +
            COLUMN_MAIN_API_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_MAIN_SLIDESHOW_IMAGES_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_CATEGORY_IMAGES_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_CATEGORY_HEADER_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_SUBCATEGORY_IMAGES_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_ITEMS_IMAGE_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_BRAND_IMAGE_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_SOCIAL_MEDIA_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_ADVERTISEMENT_IMAGE_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_OTHER_IMAGE_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_TERMS_AND_CONDITIONS_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_PRIVACY_POLICY_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_OUR_SERVICES_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_CONTACT_US_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_ABOUT_US_URI + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_SERVER_MAPPED_IMAGE_PATH + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_NEW_ORDER_REFRESH_INTERVAL + " INTEGER NOT NULL DEFAULT 0, " +
            COLUMN_ALLOW_DISCOUNT_IN_POS + " INTEGER NOT NULL DEFAULT 0, " +
            COLUMN_CRYSTAL_REPORT_PATH + " TEXT NOT NULL DEFAULT '', " +
            COLUMN_ACTIVE + " INTEGER NOT NULL DEFAULT 0" +
            ");";
    //columns for User table - end
    private static final String CREATE_TABLE_USER = "create table " + TABLE_USER + " (" +
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
            "); ";
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETUP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BRANDS);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SETUP);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_CATEGORIES);
        db.execSQL(CREATE_TABLE_BRANDS);

        db.execSQL(DataScript.INSERT_DATA_SETUPS);
        db.execSQL(DataScript.INSERT_DATA_CATEGORIES);
        db.execSQL(DataScript.INSERT_DATA_BRANDS);
    }
    //columns for Brand table - end

    @SuppressLint("Range")
    public Setup getASetup() {
        Setup setup = new Setup();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_SETUP;
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                setup.setSetupId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_SETUP_ID))));
                setup.setBranchName(result.getString(result.getColumnIndex(COLUMN_BRANCH_NAME)));
                setup.setBranchDescription(result.getString(result.getColumnIndex(COLUMN_BRANCH_DESCRIPTION)));
                setup.setBranchAddress(result.getString(result.getColumnIndex(COLUMN_BRANCH_ADDRESS)));
                setup.setBranchLandPhone(result.getString(result.getColumnIndex(COLUMN_BRANCH_LAND_PHONE)));
                setup.setBranchMobile(result.getString(result.getColumnIndex(COLUMN_BRANCH_MOBILE)));
                setup.setCurrencyMark(result.getString(result.getColumnIndex(COLUMN_CURRENCY_MARK)));
                setup.setCurrencyDecimals(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_CURRENCY_DECIMALS))));
                setup.setInitialDeliveryDays(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_INITIAL_DELIVERY_DAYS))));
                setup.setMaximumDeliveryDays(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_MAXIMUM_DELIVERY_DAYS))));
                setup.setAndroidOnGoingMaintenance(Boolean.parseBoolean(result.getString(result.getColumnIndex(COLUMN_ANDROID_ONGOING_MAINTENANCE))));
                setup.setAndroidForceUpdate(Boolean.parseBoolean(result.getString(result.getColumnIndex(COLUMN_ANDROID_FORCE_UPDATE))));
                setup.setAndroidBuildNumber(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_ANDROID_BUILD_NUMBER))));
                setup.setMainAPIUri(result.getString(result.getColumnIndex(COLUMN_MAIN_API_URI)));
                setup.setMainSlideShowImagesUri(result.getString(result.getColumnIndex(COLUMN_MAIN_SLIDESHOW_IMAGES_URI)));
                setup.setCategoryImagesUri(result.getString(result.getColumnIndex(COLUMN_CATEGORY_IMAGES_URI)));
                setup.setCategoryHeaderUri(result.getString(result.getColumnIndex(COLUMN_CATEGORY_HEADER_URI)));
                setup.setSubCategoryImagesUri(result.getString(result.getColumnIndex(COLUMN_SUBCATEGORY_IMAGES_URI)));
                setup.setItemsImageUri(result.getString(result.getColumnIndex(COLUMN_ITEMS_IMAGE_URI)));
                setup.setBrandImageUri(result.getString(result.getColumnIndex(COLUMN_BRAND_IMAGE_URI)));
                setup.setSocialMediaUri(result.getString(result.getColumnIndex(COLUMN_SOCIAL_MEDIA_URI)));
                setup.setAdvertisementImageUri(result.getString(result.getColumnIndex(COLUMN_ADVERTISEMENT_IMAGE_URI)));
                setup.setOtherImageUri(result.getString(result.getColumnIndex(COLUMN_OTHER_IMAGE_URI)));
                setup.setTermsAndConditionsUri(result.getString(result.getColumnIndex(COLUMN_TERMS_AND_CONDITIONS_URI)));
                setup.setPrivacyPolicyUri(result.getString(result.getColumnIndex(COLUMN_PRIVACY_POLICY_URI)));
                setup.setOurServicesUri(result.getString(result.getColumnIndex(COLUMN_OUR_SERVICES_URI)));
                setup.setContactUsUri(result.getString(result.getColumnIndex(COLUMN_CONTACT_US_URI)));
                setup.setAboutUsUri(result.getString(result.getColumnIndex(COLUMN_ABOUT_US_URI)));
                setup.setServerMappedImagePath(result.getString(result.getColumnIndex(COLUMN_SERVER_MAPPED_IMAGE_PATH)));
                setup.setCrystalReportPath(result.getString(result.getColumnIndex(COLUMN_CRYSTAL_REPORT_PATH)));
                setup.setNewOrderRefreshInterval(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_NEW_ORDER_REFRESH_INTERVAL))));
                setup.setAllowDiscountInPOS(Boolean.parseBoolean(result.getString(result.getColumnIndex(COLUMN_ALLOW_DISCOUNT_IN_POS))));
                setup.setActive(Boolean.parseBoolean(result.getString(result.getColumnIndex(COLUMN_ACTIVE))));
            }
        }
        result.close();
        return setup;
    }

    @SuppressLint("Range")
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CATEGORIES +
                " WHERE " + COLUMN_DELETED + " = " + 0 +
                " AND " + COLUMN_ACTIVE + " = " + 1 +
                " ORDER BY " + COLUMN_DISPLAY_ORDER + " ASC";
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                Category category = new Category();
                category.setCategoryId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_CATEGORY_ID))));
                category.setCategoryName(result.getString(result.getColumnIndex(COLUMN_CATEGORY_NAME)));
                category.setCategoryImage(result.getString(result.getColumnIndex(COLUMN_CATEGORY_IMAGE)));
                category.setCategoryHeaderImage(result.getString(result.getColumnIndex(COLUMN_CATEGORY_HEADER_IMAGE)));
                category.setDisplayOrder(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_DISPLAY_ORDER))));
                category.setMaxDiscount(Long.parseLong(result.getString(result.getColumnIndex(COLUMN_MAX_DISCOUNT))));
                category.setActive(Boolean.parseBoolean(result.getString(result.getColumnIndex(COLUMN_ACTIVE))));
                category.setDeleted(Boolean.parseBoolean(result.getString(result.getColumnIndex(COLUMN_DELETED))));
                category.setUpdatedDate(result.getString(result.getColumnIndex(COLUMN_UPDATED_DATE)));
                categories.add(category);
            }
        }
        result.close();
        return categories;
    }

    @SuppressLint("Range")
    public List<Brand> getBrands() {
        List<Brand> brands = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_BRANDS +
                " WHERE " + COLUMN_DELETED + " = " + 0 +
                " AND " + COLUMN_ACTIVE + " = " + 1 +
                " ORDER BY " + COLUMN_DISPLAY_ORDER + " ASC";
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                Brand brand = new Brand();
                brand.setBrandId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_BRAND_ID))));
                brand.setBrandName(result.getString(result.getColumnIndex(COLUMN_BRAND_NAME)));
                brand.setBrandImage(result.getString(result.getColumnIndex(COLUMN_BRAND_IMAGE)));
                brand.setDisplayOrder(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_DISPLAY_ORDER))));
                brand.setActive(Boolean.parseBoolean(result.getString(result.getColumnIndex(COLUMN_ACTIVE))));
                brand.setDeleted(Boolean.parseBoolean(result.getString(result.getColumnIndex(COLUMN_DELETED))));
                brand.setUpdatedDate(result.getString(result.getColumnIndex(COLUMN_UPDATED_DATE)));
                brands.add(brand);
            }
        }
        result.close();
        return brands;
    }

    private String getCurrentDate() {
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.getDefault());//dd/MM/yyyy
        Date now = new Date();
        return simpleDateFormat.format(now);
    }

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


