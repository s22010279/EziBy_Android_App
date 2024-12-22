package com.eziby.eziby_android_app.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.eziby.eziby_android_app.Models.Brand;
import com.eziby.eziby_android_app.Models.CarouselImage;
import com.eziby.eziby_android_app.Models.Category;
import com.eziby.eziby_android_app.Models.Client;
import com.eziby.eziby_android_app.Models.Item;
import com.eziby.eziby_android_app.Models.MyUser;
import com.eziby.eziby_android_app.Models.Setup;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SETUP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BRANDS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAROUSEL_IMAGES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER_POINT_REDEEM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DELIVERY_CITY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DELIVERY_TIME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPPING_CART);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WISH_LIST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RATING);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VIEWED_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STATUS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UOM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUB_CATEGORY);
        onCreate(db);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SETUP);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_CATEGORIES);
        db.execSQL(CREATE_TABLE_BRANDS);
        db.execSQL(CREATE_TABLE_CAROUSEL_IMAGES);
        db.execSQL(CREATE_TABLE_ITEMS);
        db.execSQL(CREATE_TABLE_CLIENTS);
        db.execSQL(CREATE_TABLE_CUSTOMER_POINT_REDEEM);
        db.execSQL(CREATE_TABLE_DELIVERY_CITY);
        db.execSQL(CREATE_TABLE_DELIVERY_TIME);
        db.execSQL(CREATE_TABLE_SHOPPING_CART);
        db.execSQL(CREATE_TABLE_WISH_LIST);
        db.execSQL(CREATE_TABLE_RATING);
        db.execSQL(CREATE_TABLE_VIEWED_ITEM);
        db.execSQL(CREATE_TABLE_STATUS);
        db.execSQL(CREATE_TABLE_UOM);
        db.execSQL(CREATE_TABLE_SUB_CATEGORY);


        //region Insert Data
        db.execSQL(DataScript.INSERT_DATA_SETUPS);
        db.execSQL(DataScript.INSERT_DATA_CATEGORIES);
        db.execSQL(DataScript.INSERT_DATA_BRANDS);
        db.execSQL(DataScript.INSERT_DATA_CAROUSEL_IMAGES);
        db.execSQL(DataScript.INSERT_DATA_ITEMS);
        db.execSQL(DataScript.INSERT_DATA_CLIENTS);
        // db.execSQL(DataScript.INSERT_DATA_CLIENTS1);
        // db.execSQL(DataScript.INSERT_DATA_CLIENTS2);
        // db.execSQL(DataScript.INSERT_DATA_CLIENTS3);
        // db.execSQL(DataScript.INSERT_DATA_CLIENTS4);
        // db.execSQL(DataScript.INSERT_DATA_CLIENTS5);
        // db.execSQL(DataScript.INSERT_DATA_CLIENTS6);
        // db.execSQL(DataScript.INSERT_DATA_CLIENTS7);
        // endregion

    }


    //region DB and Table Names
    public static final String DATABASE_NAME = "EziBy.db";
    public static final String TABLE_SETUP = "Setups";
    public static final String TABLE_USER = "user_table";
    public static final String TABLE_CATEGORIES = "Categories";
    public static final String TABLE_BRANDS = "Brands";
    public static final String TABLE_CAROUSEL_IMAGES = "CarouselImages";
    public static final String TABLE_ITEMS = "Items";
    public static final String TABLE_CLIENT = "Clients";
    public static final String TABLE_CUSTOMER_POINT_REDEEM = "CustomerPointRedeem";
    public static final String TABLE_DELIVERY_CITY = "DeliveryCity";
    public static final String TABLE_DELIVERY_TIME = "DeliveryTime";
    public static final String TABLE_SHOPPING_CART = "ShoppingCart";
    public static final String TABLE_WISH_LIST = "WishList";
    public static final String TABLE_RATING = "Rating";
    public static final String TABLE_VIEWED_ITEM = "ViewedItem";
    public static final String TABLE_STATUS = "Status";
    public static final String TABLE_UOM = "UOM";
    public static final String TABLE_SUB_CATEGORY = "SubCategory";
    //endregion

    //region Common Properties
    public static final String COLUMN_DISPLAY_ORDER = "DisplayOrder";
    public static final String COLUMN_DELIVERY_TIME_ID = "DeliveryTimeId";
    public static final String COLUMN_DELETED = "Deleted";
    public static final String COLUMN_ACTIVE = "Active";
    public static final String COLUMN_UPDATED_DATE = "UpdatedDate";
    public static final String COLUMN_EMAIL_ADDRESS = "emailAddress";
    //endregion Common Properties

    //region CarouselImages table
    public static final String COLUMN_CAROUSEL_ID = "carouselId";
    public static final String COLUMN_CAROUSEL_DETAILS = "carouselDetails";
    public static final String COLUMN_CAROUSEL_IMAGE_NAME = "carouselImageName";
    public static final String COLUMN_CAROUSEL_LINK = "carouselLink";
    public static final String COLUMN_CAROUSEL_TYPE = "carouselType";
    public static final String CREATE_TABLE_CAROUSEL_IMAGES = "CREATE TABLE " + TABLE_CAROUSEL_IMAGES + " (" +
            COLUMN_CAROUSEL_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_CAROUSEL_DETAILS + " TEXT NOT NULL, " +
            COLUMN_CAROUSEL_IMAGE_NAME + " TEXT NOT NULL, " +
            COLUMN_CAROUSEL_LINK + " TEXT NOT NULL, " +
            COLUMN_CAROUSEL_TYPE + " TEXT NOT NULL, " +
            COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
            COLUMN_ACTIVE + " INTEGER NOT NULL, " + // SQLite uses INTEGER for boolean values (0 = false, 1 = true)
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" + // Dates can be stored as TEXT in ISO 8601 format (YYYY-MM-DD HH:MM:SS)
            ");";
    //endregion

    //region Setup table
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
    //endregion Setup table

    //region User table
    public static final String COLUMN_BACKGROUND_MUSIC = "backgroundMusic";
    public static final String COLUMN_CONTRIBUTION = "contribution";
    public static final String COLUMN_DISPLAY_NAME = "displayName";
    public static final String COLUMN_MEMBER_SINCE = "memberSince";
    public static final String COLUMN_PROFILE_PICTURE_URI = "profilePictureUri";
    public static final String COLUMN_RATINGS = "ratings";
    public static final String COLUMN_SUBSCRIBED_TO_NEWS_LETTER = "subscribedToNewsLetter";
    public static final String COLUMN_TOKEN = "token";
    public static final String COLUMN_USER_ID = "userId";
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
    //endregion User table

    //region Category table
    public static final String COLUMN_CATEGORY_ID = "CategoryId";
    public static final String COLUMN_CATEGORY_NAME = "CategoryName";
    public static final String COLUMN_CATEGORY_IMAGE = "CategoryImage";
    public static final String COLUMN_CATEGORY_HEADER_IMAGE = "CategoryHeaderImage";
    public static final String COLUMN_MAX_DISCOUNT = "MaxDiscount";
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
    //endregion Category table

    //region SubCategory table
    public static final String COLUMN_SUB_CATEGORY_ID = "SubCategoryId";
    public static final String COLUMN_SUB_CATEGORY_NAME = "SubCategoryName";
    public static final String COLUMN_SUB_CATEGORY_IMAGE = "SubCategoryImage";

    public static final String CREATE_TABLE_SUB_CATEGORY = "CREATE TABLE " + TABLE_SUB_CATEGORY + " (" +
            COLUMN_SUB_CATEGORY_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_CATEGORY_ID + " INTEGER NOT NULL, " +
            COLUMN_SUB_CATEGORY_NAME + " TEXT NOT NULL, " +
            COLUMN_SUB_CATEGORY_IMAGE + " TEXT NOT NULL, " +
            COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
            COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
    //endregion

    //region Brand table
    public static final String COLUMN_BRAND_ID = "BrandId";
    public static final String COLUMN_BRAND_NAME = "BrandName";
    public static final String COLUMN_BRAND_IMAGE = "BrandImage";
    public static final String CREATE_TABLE_BRANDS = "CREATE TABLE " + TABLE_BRANDS + " (" +
            COLUMN_BRAND_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_BRAND_NAME + " TEXT NOT NULL, " +
            COLUMN_BRAND_IMAGE + " TEXT NOT NULL, " +
            COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
            COLUMN_ACTIVE + " INTEGER NOT NULL, " + // SQLite uses INTEGER for booleans (0 = false, 1 = true)
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" + // Dates are typically stored as TEXT in ISO 8601 format
            ");";
    //endregion Brand table

    //region UOM table
    public static final String COLUMN_UOM_ID = "UOMId";
    public static final String COLUMN_UOM_NAME = "UOMName";
    public static final String COLUMN_UOM_FULL_NAME = "UOMFullName";

    public static final String CREATE_TABLE_UOM = "CREATE TABLE " + TABLE_UOM + " (" +
            COLUMN_UOM_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_UOM_NAME + " TEXT NOT NULL, " +
            COLUMN_UOM_FULL_NAME + " TEXT NOT NULL, " +
            COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
    //endregion

    //region Item table
    public static final String COLUMN_ITEM_ID = "ItemId";
    public static final String COLUMN_ITEM_NAME = "ItemName";
    public static final String COLUMN_SPECIFICATION = "Specification";
    public static final String COLUMN_SKU_BARCODE = "SKUBarcode";
    public static final String COLUMN_DIMENSION = "Dimension";
    public static final String COLUMN_ITEM_IMAGE_1 = "ItemImage1";
    public static final String COLUMN_ITEM_IMAGE_2 = "ItemImage2";
    public static final String COLUMN_ITEM_IMAGE_3 = "ItemImage3";


    public static final String COLUMN_STOP_REORDER = "StopReOrder";
    public static final String COLUMN_REORDER_LEVEL = "ReOrderLevel";
    public static final String COLUMN_REORDER_QTY = "ReOrderQty";

    public static final String COLUMN_ALLOW_FRACTION_IN_QTY = "AllowFractionInQty";
    public static final String COLUMN_NON_EXCHANGABLE = "NonExchangable";
    public static final String COLUMN_ONE_TIME_PURCHASABLE_QTY = "OneTimePurchasableQty";

    public static final String COLUMN_QTY_ON_HAND = "QtyOnHand";
    public static final String COLUMN_MRP = "MRP";
    public static final String COLUMN_SELLING_PRICE = "SellingPrice";
    public static final String COLUMN_MOB_DISCOUNT_PERCENTAGE = "MOB_DiscountPercentage";

    public static final String COLUMN_IS_AVAILABLE_IN_MOBILE_APP = "IsAvailableInMobileApp";
    public static final String COLUMN_IS_AVAILABLE_IN_POS = "IsAvailableInPOS";
    public static final String COLUMN_IS_NEW_ARRIVAL = "IsNewArrival";
    public static final String COLUMN_IS_TRENDING = "IsTrending";
    public static final String COLUMN_IS_EXPRESS = "IsExpress";
    public static final String COLUMN_TOTAL_SOLD = "TotalSold";
    public static final String COLUMN_TOTAL_CLICKED = "TotalClicked";
    public static final String COLUMN_AVERAGE_RATING = "AverageRating";

    public static final String CREATE_TABLE_ITEMS = "CREATE TABLE " + TABLE_ITEMS + " (" +
            COLUMN_ITEM_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_ITEM_NAME + " TEXT NOT NULL, " +
            COLUMN_SPECIFICATION + " TEXT, " +
            COLUMN_SKU_BARCODE + " TEXT, " +
            COLUMN_DIMENSION + " TEXT, " +
            COLUMN_ITEM_IMAGE_1 + " TEXT, " +
            COLUMN_ITEM_IMAGE_2 + " TEXT, " +
            COLUMN_ITEM_IMAGE_3 + " TEXT, " +
            COLUMN_BRAND_ID + " INTEGER NOT NULL, " +
            COLUMN_CATEGORY_ID + " INTEGER NOT NULL, " +
            COLUMN_SUB_CATEGORY_ID + " INTEGER NOT NULL, " +
            COLUMN_DELIVERY_TIME_ID + " INTEGER NOT NULL, " +
            COLUMN_UOM_ID + " INTEGER NOT NULL, " +
            COLUMN_STOP_REORDER + " INTEGER NOT NULL, " +
            COLUMN_REORDER_LEVEL + " INTEGER NOT NULL, " +
            COLUMN_REORDER_QTY + " INTEGER NOT NULL, " +
            COLUMN_ALLOW_FRACTION_IN_QTY + " INTEGER NOT NULL, " +
            COLUMN_NON_EXCHANGABLE + " INTEGER NOT NULL, " +
            COLUMN_ONE_TIME_PURCHASABLE_QTY + " INTEGER NOT NULL, " +
            COLUMN_QTY_ON_HAND + " INTEGER NOT NULL, " +
            COLUMN_MRP + " REAL NOT NULL, " +
            COLUMN_SELLING_PRICE + " REAL NOT NULL, " +
            COLUMN_MOB_DISCOUNT_PERCENTAGE + " REAL, " +
            COLUMN_IS_AVAILABLE_IN_MOBILE_APP + " INTEGER NOT NULL, " +
            COLUMN_IS_AVAILABLE_IN_POS + " INTEGER NOT NULL, " +
            COLUMN_IS_NEW_ARRIVAL + " INTEGER NOT NULL, " +
            COLUMN_IS_TRENDING + " INTEGER NOT NULL, " +
            COLUMN_IS_EXPRESS + " INTEGER NOT NULL, " +
            COLUMN_TOTAL_SOLD + " INTEGER, " +
            COLUMN_TOTAL_CLICKED + " INTEGER, " +
            COLUMN_AVERAGE_RATING + " REAL, " +
            COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
    //endregion

    //region Client table
    public static final String COLUMN_CLIENT_ID = "ClientId";
    public static final String COLUMN_IS_GUEST_MODE = "IsGuestMode";
    public static final String COLUMN_GUEST_ID = "GuestId";
    public static final String COLUMN_FULL_NAME = "FullName";
    public static final String COLUMN_PHONE_NUMBER = "PhoneNumber";
    public static final String COLUMN_PHONE_VERIFIED = "PhoneVerified";
    public static final String COLUMN_EMAIL_VERIFIED = "EmailVerified";
    public static final String COLUMN_SUBSCRIBED_FOR_NEWS_LETTERS = "SubscribedForNewsLetters";
    public static final String COLUMN_SUSPENDED = "Suspended";
    public static final String COLUMN_SUSPENDED_REASON = "SuspendedReason";
    public static final String COLUMN_DATE_CREATED = "DateCreated";
    public static final String COLUMN_DATE_LAST_LOGGED = "DateLastLogged";

    public static final String CREATE_TABLE_CLIENTS = "CREATE TABLE " + TABLE_CLIENT + " (" +
            COLUMN_CLIENT_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_IS_GUEST_MODE + " INTEGER NOT NULL, " +
            COLUMN_EMAIL_ADDRESS + " TEXT NOT NULL, " +
            COLUMN_GUEST_ID + " TEXT NOT NULL, " +
            COLUMN_FULL_NAME + " TEXT NOT NULL, " +
            COLUMN_PHONE_NUMBER + " TEXT NOT NULL, " +
            COLUMN_PHONE_VERIFIED + " INTEGER NOT NULL, " +
            COLUMN_EMAIL_VERIFIED + " INTEGER NOT NULL, " +
            COLUMN_SUBSCRIBED_FOR_NEWS_LETTERS + " INTEGER NOT NULL, " +
            COLUMN_SUSPENDED + " INTEGER NOT NULL, " +
            COLUMN_SUSPENDED_REASON + " TEXT NOT NULL, " +
            COLUMN_DATE_CREATED + " TEXT NOT NULL, " +
            COLUMN_DATE_LAST_LOGGED + " TEXT NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
    //endregion

    //region CustomerPointRedeem table
    public static final String COLUMN_REDEEMED_ID = "RedeemedId";
    public static final String COLUMN_CUSTOMER_ID = "CustomerId";
    public static final String COLUMN_POINTS_REDEEMED = "PointsRedeemed";
    public static final String COLUMN_REDEEMED_DATE = "RedeemedDate";
    public static final String CREATE_TABLE_CUSTOMER_POINT_REDEEM = "CREATE TABLE " + TABLE_CUSTOMER_POINT_REDEEM + " (" +
            COLUMN_REDEEMED_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_CUSTOMER_ID + " INTEGER NOT NULL, " +
            COLUMN_POINTS_REDEEMED + " INTEGER NOT NULL, " +
            COLUMN_REDEEMED_DATE + " TEXT NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
    //endregion

    //region DeliveryCity table
    public static final String COLUMN_DELIVERY_CITY_ID = "DeliveryCityId";
    public static final String COLUMN_DELIVERY_CITY_NAME = "DeliveryCityName";
    public static final String COLUMN_DELIVERY_CHARGE = "DeliveryCharge";

    public static final String CREATE_TABLE_DELIVERY_CITY = "CREATE TABLE " + TABLE_DELIVERY_CITY + " (" +
            COLUMN_DELIVERY_CITY_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_DELIVERY_CITY_NAME + " TEXT NOT NULL, " +
            COLUMN_DELIVERY_CHARGE + " INTEGER NOT NULL, " +
            COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
            COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
    //endregion

    //region DeliveryTime table
    public static final String COLUMN_DELIVERY_TIME_NAME = "DeliveryTimeName";

    public static final String CREATE_TABLE_DELIVERY_TIME = "CREATE TABLE " + TABLE_DELIVERY_TIME + " (" +
            COLUMN_DELIVERY_TIME_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_DELIVERY_TIME_NAME + " TEXT NOT NULL, " +
            COLUMN_DISPLAY_ORDER + " INTEGER NOT NULL, " +
            COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
    //endregion

    //region ShoppingCart table
    public static final String COLUMN_SHOPPING_CART_ID = "ShoppingCartId";
    public static final String COLUMN_ITEM_PRICE_VARIANT_ID = "ItemPriceVariantId";
    public static final String COLUMN_QUANTITY = "Quantity";
    public static final String COLUMN_DATE_UPDATED = "DateUpdated";

    public static final String CREATE_TABLE_SHOPPING_CART = "CREATE TABLE " + TABLE_SHOPPING_CART + " (" +
            COLUMN_SHOPPING_CART_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_CLIENT_ID + " INTEGER NOT NULL, " +
            COLUMN_ITEM_ID + " INTEGER NOT NULL, " +
            COLUMN_ITEM_PRICE_VARIANT_ID + " INTEGER NOT NULL, " +
            COLUMN_QUANTITY + " INTEGER NOT NULL, " +
            COLUMN_DATE_CREATED + " TEXT NOT NULL, " +
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_DATE_UPDATED + " TEXT NOT NULL" +
            ");";
    //endregion

    //region WishList table
    public static final String COLUMN_WISH_LIST_ID = "WishListId";

    public static final String CREATE_TABLE_WISH_LIST = "CREATE TABLE " + TABLE_WISH_LIST + " (" +
            COLUMN_WISH_LIST_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_CLIENT_ID + " INTEGER NOT NULL, " +
            COLUMN_ITEM_ID + " INTEGER NOT NULL, " +
            COLUMN_ITEM_PRICE_VARIANT_ID + " INTEGER NOT NULL, " +
            COLUMN_QUANTITY + " INTEGER NOT NULL, " +
            COLUMN_DATE_CREATED + " TEXT NOT NULL, " +
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_DATE_UPDATED + " TEXT NOT NULL" +
            ");";
    //endregion

    //region Rating table
    public static final String COLUMN_RATING_ID = "RatingId";
    public static final String COLUMN_RATING_STAR = "RatingStar";
    public static final String COLUMN_RATING_REVIEW = "RatingReview";

    public static final String CREATE_TABLE_RATING = "CREATE TABLE " + TABLE_RATING + " (" +
            COLUMN_RATING_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_ITEM_ID + " INTEGER NOT NULL, " +
            COLUMN_ITEM_PRICE_VARIANT_ID + " INTEGER NOT NULL, " +
            COLUMN_CLIENT_ID + " INTEGER NOT NULL, " +
            COLUMN_RATING_STAR + " INTEGER NOT NULL, " +
            COLUMN_RATING_REVIEW + " TEXT NOT NULL, " +
            COLUMN_ACTIVE + " INTEGER NOT NULL, " +
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
    //endregion

    //region ViewedItem table
    public static final String COLUMN_VIEW_ID = "ViewId";
    public static final String COLUMN_VIEWED_COUNT = "ViewedCount";
    public static final String COLUMN_DATE_LAST_VIEWED = "DateLastViewed";

    public static final String CREATE_TABLE_VIEWED_ITEM = "CREATE TABLE " + TABLE_VIEWED_ITEM + " (" +
            COLUMN_VIEW_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_CLIENT_ID + " INTEGER NOT NULL, " +
            COLUMN_ITEM_ID + " INTEGER NOT NULL, " +
            COLUMN_ITEM_PRICE_VARIANT_ID + " INTEGER NOT NULL, " +
            COLUMN_VIEWED_COUNT + " INTEGER NOT NULL, " +
            COLUMN_DATE_CREATED + " TEXT NOT NULL, " +
            COLUMN_DATE_LAST_VIEWED + " TEXT NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
    //endregion

    //region Status table
    public static final String COLUMN_STATUS_ID = "StatusId";
    public static final String COLUMN_STATUS_NAME = "StatusName";

    public static final String CREATE_TABLE_STATUS = "CREATE TABLE " + TABLE_STATUS + " (" +
            COLUMN_STATUS_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_STATUS_NAME + " TEXT NOT NULL, " +
            COLUMN_DELETED + " INTEGER NOT NULL, " +
            COLUMN_UPDATED_DATE + " TEXT NOT NULL" +
            ");";
    //endregion


    @SuppressLint("Range")
    public List<CarouselImage> getCarouselImages() {
        List<CarouselImage> carouselImages = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CAROUSEL_IMAGES +
                " WHERE " + COLUMN_DELETED + " = " + 0 +
                " AND " + COLUMN_ACTIVE + " = " + 1 +
                " ORDER BY " + COLUMN_DISPLAY_ORDER + " ASC";
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                CarouselImage carouselImage = new CarouselImage();
                carouselImage.setCarouselId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_CAROUSEL_ID))));
                carouselImage.setCarouselDetails(result.getString(result.getColumnIndex(COLUMN_CAROUSEL_DETAILS)));
                carouselImage.setCarouselImageName(result.getString(result.getColumnIndex(COLUMN_CAROUSEL_IMAGE_NAME)));
                carouselImage.setCarouselLink(result.getString(result.getColumnIndex(COLUMN_CAROUSEL_LINK)));
                carouselImage.setCarouselType(result.getString(result.getColumnIndex(COLUMN_CAROUSEL_TYPE)));
                carouselImage.setDisplayOrder(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_DISPLAY_ORDER))));
                carouselImage.setActive(result.getInt(result.getColumnIndex(COLUMN_ACTIVE)) == 1);
                carouselImage.setDeleted(result.getInt(result.getColumnIndex(COLUMN_DELETED)) == 1);
                carouselImage.setUpdatedDate(result.getString(result.getColumnIndex(COLUMN_UPDATED_DATE)));
                carouselImages.add(carouselImage);
            }
        }
        result.close();
        return carouselImages;
    }

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
                setup.setAndroidOnGoingMaintenance(result.getInt(result.getColumnIndex(COLUMN_ANDROID_ONGOING_MAINTENANCE)) == 1);
                setup.setAndroidForceUpdate(result.getInt(result.getColumnIndex(COLUMN_ANDROID_FORCE_UPDATE)) == 1);
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
                setup.setAllowDiscountInPOS(result.getInt(result.getColumnIndex(COLUMN_ALLOW_DISCOUNT_IN_POS)) == 1);
                setup.setActive(result.getInt(result.getColumnIndex(COLUMN_ACTIVE)) == 1);

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
                category.setActive(result.getInt(result.getColumnIndex(COLUMN_ACTIVE)) == 1);
                category.setDeleted(result.getInt(result.getColumnIndex(COLUMN_DELETED)) == 1);
                category.setUpdatedDate(result.getString(result.getColumnIndex(COLUMN_UPDATED_DATE)));
                categories.add(category);
            }
        }
        result.close();
        return categories;
    }

    @SuppressLint("Range")
    public List<Item> getItems(int brandId, int categoryId, int itemId) {
        List<Item> items = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ITEMS +
                " WHERE " + COLUMN_DELETED + " = " + 0 +
                " AND " + COLUMN_ACTIVE + " = " + 1;
        if (itemId > 0) {//filter for brandID
            query = query + " AND " + COLUMN_ITEM_ID + " = " + itemId;
        }
        if (brandId > 0) {//filter for brandID
            query = query + " AND " + COLUMN_BRAND_ID + " = " + brandId;
        }
        if (categoryId > 0) {//filter for categoryID
            query = query + " AND " + COLUMN_CATEGORY_ID + " = " + categoryId;
        }

        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                Item item = new Item();
                item.setItemId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_ITEM_ID))));
                item.setItemName(result.getString(result.getColumnIndex(COLUMN_ITEM_NAME)));
                item.setItemImage1(result.getString(result.getColumnIndex(COLUMN_ITEM_IMAGE_1)));
                item.setItemImage2(result.getString(result.getColumnIndex(COLUMN_ITEM_IMAGE_2)));
                item.setItemImage3(result.getString(result.getColumnIndex(COLUMN_ITEM_IMAGE_3)));
                item.setSpecification(result.getString(result.getColumnIndex(COLUMN_SPECIFICATION)));
                item.setSkuBarcode(result.getString(result.getColumnIndex(COLUMN_SKU_BARCODE)));
                item.setDimension(result.getString(result.getColumnIndex(COLUMN_DIMENSION)));

                item.setStopReOrder(result.getInt(result.getColumnIndex(COLUMN_STOP_REORDER)) == 1);
                item.setTrending(result.getInt(result.getColumnIndex(COLUMN_IS_TRENDING)) == 1);
                item.setNewArrival(result.getInt(result.getColumnIndex(COLUMN_IS_NEW_ARRIVAL)) == 1);
                item.setExpress(result.getInt(result.getColumnIndex(COLUMN_IS_EXPRESS)) == 1);
                item.setAllowFractionInQty(result.getInt(result.getColumnIndex(COLUMN_ALLOW_FRACTION_IN_QTY)) == 1);
                item.setNonExchangable(result.getInt(result.getColumnIndex(COLUMN_NON_EXCHANGABLE)) == 1);
                item.setAvailableInMobileApp(result.getInt(result.getColumnIndex(COLUMN_IS_AVAILABLE_IN_MOBILE_APP)) == 1);
                item.setAvailableInPOS(result.getInt(result.getColumnIndex(COLUMN_IS_AVAILABLE_IN_POS)) == 1);
                item.setActive(result.getInt(result.getColumnIndex(COLUMN_ACTIVE)) == 1);
                item.setDeleted(result.getInt(result.getColumnIndex(COLUMN_DELETED)) == 1);

                item.setUpdatedDate(result.getString(result.getColumnIndex(COLUMN_UPDATED_DATE)));

                item.setQtyOnHand(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_QTY_ON_HAND))));
                item.setBrandId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_BRAND_ID))));
                item.setCategoryId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_CATEGORY_ID))));
                item.setSubCategoryId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_SUB_CATEGORY_ID))));
                item.setDeliveryTimeId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_DELIVERY_TIME_ID))));
                item.setUomId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_UOM_ID))));
                item.setReOrderLevel(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_REORDER_LEVEL))));
                item.setReOrderQty(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_REORDER_QTY))));
                item.setOneTimePurchasableQty(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_ONE_TIME_PURCHASABLE_QTY))));
                item.setTotalSold(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_TOTAL_SOLD))));
                item.setTotalClicked(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_TOTAL_CLICKED))));

                item.setMrp(new BigDecimal(result.getString(result.getColumnIndex(COLUMN_MRP))));
                item.setSellingPrice(new BigDecimal(result.getString(result.getColumnIndex(COLUMN_SELLING_PRICE))));
                item.setMobDiscountPercentage(new BigDecimal(result.getString(result.getColumnIndex(COLUMN_MOB_DISCOUNT_PERCENTAGE))));
                item.setAverageRating(new BigDecimal(result.getString(result.getColumnIndex(COLUMN_AVERAGE_RATING))));

                items.add(item);
            }
        }
        result.close();
        return items;
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

                brand.setActive(result.getInt(result.getColumnIndex(COLUMN_ACTIVE)) == 1);
                brand.setDeleted(result.getInt(result.getColumnIndex(COLUMN_DELETED)) == 1);

                brand.setUpdatedDate(result.getString(result.getColumnIndex(COLUMN_UPDATED_DATE)));
                brands.add(brand);
            }
        }
        result.close();
        return brands;
    }

    @SuppressLint("Range")
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CLIENT;
        Cursor result = db.rawQuery(query, null);
        if (result.getCount() > 0) {
            while (result.moveToNext()) {
                Client client = new Client();
                client.setClientId(Integer.parseInt(result.getString(result.getColumnIndex(COLUMN_CLIENT_ID))));

                client.setEmailAddress(result.getString(result.getColumnIndex(COLUMN_EMAIL_ADDRESS)));
                client.setGuestId(result.getString(result.getColumnIndex(COLUMN_GUEST_ID)));
                client.setFullName(result.getString(result.getColumnIndex(COLUMN_FULL_NAME)));
                client.setPhoneNumber(result.getString(result.getColumnIndex(COLUMN_PHONE_NUMBER)));

                client.setGuestMode(result.getInt(result.getColumnIndex(COLUMN_IS_GUEST_MODE)) == 1);
                client.setEmailVerified(result.getInt(result.getColumnIndex(COLUMN_EMAIL_VERIFIED)) == 1);
                client.setSubscribedForNewsLetters(result.getInt(result.getColumnIndex(COLUMN_SUBSCRIBED_FOR_NEWS_LETTERS)) == 1);
                client.setSuspended(result.getInt(result.getColumnIndex(COLUMN_SUSPENDED)) == 1);

                client.setSuspendedReason(result.getString(result.getColumnIndex(COLUMN_SUSPENDED_REASON)));
                client.setDateCreated(result.getString(result.getColumnIndex(COLUMN_DATE_CREATED)));
                client.setDateLastLogged(result.getString(result.getColumnIndex(COLUMN_DATE_LAST_LOGGED)));
                client.setUpdatedDate(result.getString(result.getColumnIndex(COLUMN_UPDATED_DATE)));
                clients.add(client);
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
                myUser.setSubscribedToNewsLetter(result.getInt(result.getColumnIndex(COLUMN_SUBSCRIBED_TO_NEWS_LETTER)) == 1);
                myUser.setBackgroundMusic(result.getInt(result.getColumnIndex(COLUMN_BACKGROUND_MUSIC)) == 1);
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


