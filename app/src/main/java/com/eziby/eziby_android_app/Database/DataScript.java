package com.eziby.eziby_android_app.Database;

public class DataScript {
    public static final String INSERT_DATA_SETUPS = "INSERT INTO Setups(" +
            " SetupId" +
            ",BranchName" +
            ",BranchDescription" +
            ",BranchAddress" +
            ",BranchLandPhone" +
            ",BranchMobile" +
            ",CurrencyMark" +
            ",CurrencyDecimals" +
            ",InitialDeliveryDays" +
            ",MaximumDeliveryDays" +
            ",Android_OnGoingMaintenance" +
            ",Android_ForceUpdate" +
            ",Android_BuildNumber" +
            ",MainAPIUri" +
            ",MainSlideShowImagesUri" +
            ",CategoryImagesUri" +
            ",CategoryHeaderUri" +
            ",SubCategoryImagesUri" +
            ",ItemsImageUri" +
            ",BrandImageUri" +
            ",SocialMediaUri" +
            ",AdvertisementImageUri" +
            ",OtherImageUri" +
            ",TermsAndConditionsUri" +
            ",PrivacyPolicyUri" +
            ",OurServicesUri" +
            ",ContactUsUri" +
            ",AboutUsUri" +
            ",ServerMappedImagePath" +
            ",NewOrderRefreshInterval" +
            ",AllowDiscountInPOS" +
            ",Active" +
            ",CrystalReportPath)" +
            "VALUES (" +
            "1" +
            ",'Branch Name'" +
            ",'Branch Description'" +
            ",'Branch Address'" +
            ",'0118956325'" +
            ",'0777701979'" +
            ",'Rs.'\t" +
            ",2" +
            ",2" +
            ",7" +
            ",0" +
            ",0" +
            ",1" +
            ",'https://MobileApi.eziby.lk/'" +
            ",'https://images.eziby.lk/EziBy_Images/MainSlideShowImage/'" +
            ",'https://images.eziby.lk/EziBy_Images/Category/'" +
            ",'https://images.eziby.lk/EziBy_Images/CategoryHeader/'" +
            ",'https://images.eziby.lk/EziBy_Images/SubCategory/'" +
            ",'https://images.eziby.lk/EziBy_Images/Item/'" +
            ",'https://images.eziby.lk/EziBy_Images/Brand/'" +
            ",'https://images.eziby.lk/EziBy_Images/SocialMedia/'" +
            ",'https://images.eziby.lk/EziBy_Images/Advertisement/'" +
            ",'https://images.eziby.lk/EziBy_Images/Other/'" +
            ",'https://ousl.eziby.lk/Home/termsandconditions'" +
            ",'https://ousl.eziby.lk/Home/privacypolicy'" +
            ",'https://ousl.eziby.lk/Home/OurServices'" +
            ",'https://ousl.eziby.lk/Home/contactus'" +
            ",'https://ousl.eziby.lk/Home/AboutUs'" +
            ",'C:/Inetpub/vhosts/eziby.lk/'" +
            ",1" +
            ",1" +
            ",1" +
            ",'C:\\EziBy_Reports\\');";

    public static final String INSERT_DATA_CATEGORIES = "INSERT INTO Categories (" +
            " CategoryId" +
            ",CategoryName" +
            ",CategoryImage" +
            ",CategoryHeaderImage" +
            ",DisplayOrder" +
            ",MaxDiscount" +
            ",Active" +
            ",Deleted" +
            ",UpdatedDate)" +
            "VALUES " +
            "(1 , 'FoodCooking & Grains', '0000001_1_3HIQIDEM2GG.jpg', '0000001_2_3HIQIDEM2GG.jpg',  1, 11, 1, 0, '2021-01-01')," +
            "(2 , 'Oil & Ghee', '0000002_1_B10TCNEM2GG.jpg', '0000002_2_B10TCNEM2GG.jpg',  2, 12, 1, 0, '2022-01-01')," +
            "(3 , 'Masala & Spices', '0000003_1_ENEGFDEM2GG.jpg', '0000003_2_ENEGFDEM2GG.jpg',  3, 13, 1, 1, '2023-01-01')," +
            "(4 , 'Masala & Spices', '0000003_1_ENEGFDEM2GG.jpg', '0000004_2_F9KV0NAM2GG.jpg',  4, 13, 1, 1, '2023-01-01')," +
            "(5 , 'Bath & Hygiene', '0000005_1_5OW87NAM2GG.jpg', '0000005_2_5OW87NAM2GG.jpg',  5, 14, 1, 0, '2024-01-01')," +
            "(6 , 'Cleaning & House Kepping', '0000006_1_JT1Q4TAM2GG.jpg', '0000006_2_JT1Q4TAM2GG.jpg',  6, 15, 1, 0, '2025-01-01')," +
            "(8 , 'Baby Care', '0000008_1_IAD6W9AM2GG.jpg', '0000008_2_OYBZ1TAM2GG.jpg',  7, 11, 1, 0, '2021-01-01')," +
            "(11, 'Biscuits Snacks & Bakery Products', '0000011_1_THQKD9EM2GG.jpg', '0000011_2_THQKD9EM2GG.jpg',  8, 12, 1, 0, '2022-01-01')," +
            "(12, 'Milk Products & Beverages', '0000012_1_R76SBNEM2GG.jpg', '0000012_2_R76SBNEM2GG.jpg',  9, 13, 1, 1, '2023-01-01')," +
            "(13, 'Beauty cosmetic & personal care', '0000013_1_9UUUXDEM2GG.jpg', '0000013_2_9UUUXDEM2GG.jpg', 10, 14, 1, 0, '2024-01-01')," +
            "(14, 'Ayurvedic and English Medicine', '0000014_1_F1CATNEM2GG.jpg', '0000014_2_LH4BTNEM2GG.jpg', 11, 15, 1, 0, '2025-01-01')," +
            "(15, 'Egg Meat & Fish', '0000015_1_I298ODEM2GG.jpg', '0000015_2_I298ODEM2GG.jpg', 12, 14, 1, 0, '2024-01-01')," +
            "(16, 'Stationeries', '0000016_1_ZULYLTEM2GG.jpg', '0000016_2_7RBZLTEM2GG.jpg', 13, 15, 1, 0, '2025-01-01');";

    public static final String INSERT_DATA_BRANDS = "INSERT INTO Brands (\n" +
            " BrandId\n" +
            ",BrandName\n" +
            ",BrandImage\n" +
            ",DisplayOrder\n" +
            ",Active\n" +
            ",Deleted\n" +
            ",UpdatedDate)\n" +
            "VALUES \n" +
            "(14, 'Unilever','0000014_1_PSRAHE0M2GG.jpg', 1, 1, 0, '2021-01-01'),\n" +
            "(15, 'Munchee',\t'0000015_1_568PI9AM2GG.jpg', 2, 1, 0, '2022-01-01'),\n" +
            "(16, 'Gal Oya',\t'0000016_1_PLSBHDAM2GG.jpg', 3, 1, 0, '2023-01-01'),\n" +
            "(17, 'Healthy',\t'0000017_1_EK64FDAM2GG.jpg', 4, 1, 0, '2024-01-01'),\n" +
            "(18, 'Hemas',\t'0000018_1_2YLMDTAM2GG.jpg', 5, 1, 0, '2025-01-01'),\n" +
            "(19, 'Agroturf','0000019_1_ROUDCDAM2GG.jpg', 6, 1, 0, '2021-01-01'),\n" +
            "(20, 'Nestle',\t'0000020_1_J55BA9AM2GG.jpg', 7, 1, 0, '2022-01-01'),\n" +
            "(21, 'Maliban',\t'0000021_1_AJE999WM2GG.jpg', 8, 1, 0, '2023-01-01'),\n" +
            "(22, 'Atlas',\t'0000022_1_XA3D59WM2GG.jpg', 9, 1, 0,'2024-01-01');";
}
