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
            ",'Rs.'" +
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
            "(1 , 'FoodCooking & Grains',              '0000001_1_3HIQIDEM2GG.jpg', '0000001_2_3HIQIDEM2GG.jpg',  1, 11, 1, 0, '2021-01-01')," +
            "(2 , 'Oil & Ghee',                        '0000002_1_B10TCNEM2GG.jpg', '0000002_2_B10TCNEM2GG.jpg',  2, 12, 1, 0, '2022-01-01')," +
            "(3 , 'Masala & Spices',                   '0000003_1_ENEGFDEM2GG.jpg', '0000003_2_ENEGFDEM2GG.jpg',  3, 13, 1, 1, '2023-01-01')," +
            "(4 , 'Masala & Spices',                   '0000003_1_ENEGFDEM2GG.jpg', '0000004_2_F9KV0NAM2GG.jpg',  4, 13, 1, 1, '2023-01-01')," +
            "(5 , 'Bath & Hygiene',                    '0000005_1_5OW87NAM2GG.jpg', '0000005_2_5OW87NAM2GG.jpg',  5, 14, 1, 0, '2024-01-01')," +
            "(6 , 'Cleaning & House Keeping',          '0000006_1_JT1Q4TAM2GG.jpg', '0000006_2_JT1Q4TAM2GG.jpg',  6, 15, 1, 0, '2025-01-01')," +
            "(8 , 'Baby Care',                         '0000008_1_IAD6W9AM2GG.jpg', '0000008_2_OYBZ1TAM2GG.jpg',  7, 11, 1, 0, '2021-01-01')," +
            "(11, 'Biscuits Snacks & Bakery Products', '0000011_1_THQKD9EM2GG.jpg', '0000011_2_THQKD9EM2GG.jpg',  8, 12, 1, 0, '2022-01-01')," +
            "(12, 'Milk Products & Beverages',         '0000012_1_R76SBNEM2GG.jpg', '0000012_2_R76SBNEM2GG.jpg',  9, 13, 1, 1, '2023-01-01')," +
            "(13, 'Beauty cosmetic & personal care',   '0000013_1_9UUUXDEM2GG.jpg', '0000013_2_9UUUXDEM2GG.jpg', 10, 14, 1, 0, '2024-01-01')," +
            "(14, 'Ayurvedic and English Medicine',    '0000014_1_F1CATNEM2GG.jpg', '0000014_2_LH4BTNEM2GG.jpg', 11, 15, 1, 0, '2025-01-01')," +
            "(15, 'Egg Meat & Fish',                   '0000015_1_I298ODEM2GG.jpg', '0000015_2_I298ODEM2GG.jpg', 12, 14, 1, 0, '2024-01-01')," +
            "(16, 'Stationer',                         '0000016_1_ZULYLTEM2GG.jpg', '0000016_2_7RBZLTEM2GG.jpg', 13, 15, 1, 0, '2025-01-01');";

    public static final String INSERT_DATA_BRANDS = "INSERT INTO Brands (" +
            " BrandId" +
            ",BrandName" +
            ",BrandImage" +
            ",DisplayOrder" +
            ",Active" +
            ",Deleted" +
            ",UpdatedDate)" +
            "VALUES " +
            "(14, 'Unilever','0000014_1_PSRAHE0M2GG.jpg', 1, 1, 0, '2021-01-01')," +
            "(15, 'Munchee', '0000015_1_568PI9AM2GG.jpg', 2, 1, 0, '2022-01-01')," +
            "(16, 'Gal Oya', '0000016_1_PLSBHDAM2GG.jpg', 3, 1, 0, '2023-01-01')," +
            "(17, 'Healthy', '0000017_1_EK64FDAM2GG.jpg', 4, 1, 0, '2024-01-01')," +
            "(18, 'Hemas',   '0000018_1_2YLMDTAM2GG.jpg', 5, 1, 0, '2025-01-01')," +
            "(19, 'Agroturf','0000019_1_ROUDCDAM2GG.jpg', 6, 1, 0, '2021-01-01')," +
            "(20, 'Nestle',  '0000020_1_J55BA9AM2GG.jpg', 7, 1, 0, '2022-01-01')," +
            "(21, 'Maliban', '0000021_1_AJE999WM2GG.jpg', 8, 1, 0, '2023-01-01')," +
            "(22, 'Atlas',   '0000022_1_XA3D59WM2GG.jpg', 9, 1, 0, '2024-01-01');";

    public static final String INSERT_DATA_CAROUSEL_IMAGES = "INSERT INTO CarouselImages(" +
            " CarouselId" +
            ",CarouselDetails" +
            ",CarouselImageName" +
            ",CarouselLink" +
            ",CarouselType" +
            ",DisplayOrder" +
            ",Active" +
            ",Deleted" +
            ",UpdatedDate)" +
            "VALUES " +
            "( 5, 'Every day'                       , '0000005_1_ARWMGTAM2GG.jpg', 'No Link', 'HomeCarousel',  5, 1, 0, '2021-01-01')," +
            "( 7, 'Every day more products on eziby', '0000007_1_K0CXINAM2GG.jpg', 'No Link', 'HomeCarousel',  7, 1, 0, '2022-01-01')," +
            "( 8, 'Daily fresh',                      '0000008_1_FFZUJDAM2GG.jpg', 'No Link', 'HomeCarousel',  8, 0, 0, '2023-01-01')," +
            "( 9, 'Free Delivery Ramazan 2023',       '0000009_1_SEUZBQ8O2WG.jpg', 'No Link', 'HomeCarousel',  9, 0, 0, '2024-01-01')," +
            "(10, '2024 Ram',                         '0000010_1_EVZUAV1A3AG.jpg', 'No Link', 'HomeCarousel', 10, 1, 0, '2025-01-01');";

    public static final String INSERT_DATA_ITEMS = "INSERT INTO Items (" +
            "ItemId, ItemName, Specification, SKUBarcode, Dimension, ItemImage1, ItemImage2, ItemImage3, BrandId, CategoryId, SubCategoryId, DeliveryTimeId, UOMId, StopReOrder, ReOrderLevel, ReOrderQty, AllowFractionInQty, NonExchangable, OneTimePurchasableQty, IsAvailableInMobileApp, IsAvailableInPOS, IsNewArrival, IsTrending, IsExpress, TotalSold, TotalClicked, AverageRating, Active, Deleted, UpdatedDate) " +
            "VALUES " +
            "(16, 'Sugar - Brown', 'Brown sugar is a sucrose sugar product with a distinctive brown color due to the presence of molasses. It is either an unrefined or partially refined soft sugar consisting of sugar crystals with some residual molasses content (natural brown sugar', '1001', '1', '0000016_1_BNRKEPUM2GG.jpg', '', '', 16, 1, 2, 0, 4, 0, 15, 10, 1, 0, 10, 1, 1, 0, 1, 1, 0, 78, 0.00, 1, 0, '2024-01-01')," +
            "(17, 'Salt Lanka', 'Salt is a mineral composed primarily of sodium chloride (NaCl), a chemical compound belonging to the larger class of salts; salt in the form of a natural crystalline mineral is known as rock salt or halite. Salt is present in vast quantities in seawater. The open ocean has about 35 g (1.2 oz) of solids per liter of seawater, a salinity of 3.5%', '4796019630012', '1', '0000017_1_RNHQEPUM2GG.jpg', '', '', 0, 1, 3, 0, 4, 0, 15, 10, 0, 0, 10, 1, 1, 0, 0, 0, 0, 21, 0.00, 1, 0, '2024-01-01')," +
            "(18, 'Sugar -White', 'White sugar, also called granulated sugar or table sugar, is made from refined sugar cane or sugar beets. First, food processors juice the sugar cane or beets, and then they boil the cane juice to evaporate the water. ... The resulting table sugar is chemically pure sucrose. Sugar is considered a natural carbohydrate.', '1000', '1', '0000018_1_RLBSEPUM2GG.jpg', '', '', 0, 1, 2, 0, 4, 0, 15, 10, 1, 0, 5, 1, 1, 0, 1, 1, 0, 144, 0.00, 1, 0, '2024-01-01')," +
            "(19, 'Coconut Oil Heathe', '**The first high-quality coconut oil to be produced in our areaoconut oil has many nutrients that can contribute to your health and to a good diet. Its full of fatty acids that your body needs and may help improve cognitive function, metabolism, and hair and skin health', '1900', '750', '0000019_1_ACPUEPUM2GG.jpg', '', '', 17, 2, 20, 0, 1, 0, 15, 10, 0, 0, 5, 1, 1, 0, 0, 0, 0, 74, 0.00, 1, 0, '2024-01-01')," +
            "(20, 'Sunsilk Shampoo Soft Smooth', 'Its just a good shampoo for cleaning your hair and it has a nice scent to it. It lathers up nicely so you get a deep clean. I have used thie sunsilk long and strong range for quite some time now. The range has a shampoo and conditioner, and comes in a black and purple sleek bottle in a range of sizes', '4792081031566', '80', '0000020_1_1PR0EPUM2GG.jpg', '', '', 14, 5, 10, 0, 1, 0, 15, 10, 0, 0, 999, 1, 1, 0, 0, 0, 0, 9, 0.00, 1, 0, '2024-01-01')," +
            "(21, 'Tikiri Marie', 'A smooth golden milk biscuit with subtle sweetness and a distinct crisp texture, baked according to a traditional recipe.', '8888101280208', '80', '0000021_1_C0J2EPUM2GG.png', '', '', 15, 11, 21, 0, 2, 0, 15, 10, 0, 0, 5, 1, 1, 0, 0, 0, 0, 79, 0.00, 1, 0, '2024-01-01');";


    public static final String INSERT_DATA_CLIENTS = "INSERT INTO Clients (\n" +
            " ClientId\n" +
            ",FullName\n" +
            ",PhoneNumber\n" +
            ",PhoneVerified\n" +
            ",EmailAddress\n" +
            ",EmailVerified\n" +
            ",Suspended\n" +
            ",SuspendedReason\n" +
            ",SubscribedForNewsLetters\n" +
            ",DateCreated\n" +
            ",DateLastLogged\n" +
            ",IsGuestMode\n" +
            ",GuestId\n" +
            ",UpdatedDate)\n" +
            "VALUES\n" +
            "(4, 'Mohamed Anushath'   , '+94777701979', 0, 'hamzaanushath@gmail.com',     1, 0, 'No Reason', 0, '2022-05-19', '2022-10-22', 0, 'Guest Id', '2024-01-01'),\t\n" +
            "(6, 'Ahamed Siras'       , '+97470066846', 0, 'saji.logistics@yahoo.com',    0, 0, 'No Reason', 0, '2022-04-08', '2022-05-05', 0, 'Guest Id', '2024-01-01'),\t\n" +
            "(8, 'Jariya Ahamed lebbe', '+94765671894', 0, 'ahamedlebbejariya@gmail.com', 1, 0, 'No Reason', 0, '2022-06-02', '2022-09-07', 0, 'Guest Id', '2024-01-01'),\t\n" +
            "(9, 'AL niyas'           , '+94750345657', 0, 'alniyas8425@gmail.com',       0, 0, 'No Reason', 0, '2022-06-08', '2022-06-27', 0, 'Guest Id', '2024-01-01');";


    // public static final String INSERT_DATA_CLIENTS1 ="";
    // public static final String INSERT_DATA_CLIENTS2 ="";
    // public static final String INSERT_DATA_CLIENTS3 ="";
    // public static final String INSERT_DATA_CLIENTS4 ="";
    // public static final String INSERT_DATA_CLIENTS5 ="";
    // public static final String INSERT_DATA_CLIENTS6 ="";
    // public static final String INSERT_DATA_CLIENTS7 ="";
}

