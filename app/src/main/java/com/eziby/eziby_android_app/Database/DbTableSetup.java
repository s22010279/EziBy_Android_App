package com.eziby.eziby_android_app.Database;

public class DbTableSetup {
    public static final String TABLE_SETUP = "Setup";


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


    public static final String CREATE_TABLE_SETUP = "CREATE TABLE " + TABLE_SETUP + " (" +
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
            DbFieldsCommon.COLUMN_ACTIVE + " INTEGER NOT NULL DEFAULT 0" +
            ");";

}