package com.eziby.eziby_android_app.Models;

public class Setup {
    // Default constructor
    public Setup() {
    }

    private int setupId;
    private String branchName = "";
    private String branchDescription = "";
    private String branchAddress = "";
    private String branchLandPhone = "";
    private String branchMobile = "";
    private String currencyMark = "";
    private int currencyDecimals;
    private int initialDeliveryDays;
    private int maximumDeliveryDays;
    private boolean androidOnGoingMaintenance;
    private boolean androidForceUpdate;
    private int androidBuildNumber;
    private String mainAPIUri = "";
    private String mainSlideShowImagesUri = "";
    private String categoryImagesUri = "";
    private String categoryHeaderUri = "";
    private String subCategoryImagesUri = "";
    private String itemsImageUri = "";
    private String brandImageUri = "";
    private String socialMediaUri = "";
    private String advertisementImageUri = "";
    private String otherImageUri = "";
    private String termsAndConditionsUri = "";
    private String privacyPolicyUri = "";
    private String ourServicesUri = "";
    private String contactUsUri = "";
    private String aboutUsUri = "";
    private String serverMappedImagePath = "";
    private int newOrderRefreshInterval;
    private boolean allowDiscountInPOS;
    private String crystalReportPath = "";
    private boolean active;


    // Getters and Setters
    public int getSetupId() {
        return setupId;
    }

    public void setSetupId(int setupId) {
        this.setupId = setupId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchDescription() {
        return branchDescription;
    }

    public void setBranchDescription(String branchDescription) {
        this.branchDescription = branchDescription;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchLandPhone() {
        return branchLandPhone;
    }

    public void setBranchLandPhone(String branchLandPhone) {
        this.branchLandPhone = branchLandPhone;
    }

    public String getBranchMobile() {
        return branchMobile;
    }

    public void setBranchMobile(String branchMobile) {
        this.branchMobile = branchMobile;
    }

    public String getCurrencyMark() {
        return currencyMark;
    }

    public void setCurrencyMark(String currencyMark) {
        this.currencyMark = currencyMark;
    }

    public int getCurrencyDecimals() {
        return currencyDecimals;
    }

    public void setCurrencyDecimals(int currencyDecimals) {
        this.currencyDecimals = currencyDecimals;
    }

    public int getInitialDeliveryDays() {
        return initialDeliveryDays;
    }

    public void setInitialDeliveryDays(int initialDeliveryDays) {
        this.initialDeliveryDays = initialDeliveryDays;
    }

    public int getMaximumDeliveryDays() {
        return maximumDeliveryDays;
    }

    public void setMaximumDeliveryDays(int maximumDeliveryDays) {
        this.maximumDeliveryDays = maximumDeliveryDays;
    }

    public boolean isAndroidOnGoingMaintenance() {
        return androidOnGoingMaintenance;
    }

    public void setAndroidOnGoingMaintenance(boolean androidOnGoingMaintenance) {
        this.androidOnGoingMaintenance = androidOnGoingMaintenance;
    }

    public boolean isAndroidForceUpdate() {
        return androidForceUpdate;
    }

    public void setAndroidForceUpdate(boolean androidForceUpdate) {
        this.androidForceUpdate = androidForceUpdate;
    }

    public int getAndroidBuildNumber() {
        return androidBuildNumber;
    }

    public void setAndroidBuildNumber(int androidBuildNumber) {
        this.androidBuildNumber = androidBuildNumber;
    }

    public String getMainAPIUri() {
        return mainAPIUri;
    }

    public void setMainAPIUri(String mainAPIUri) {
        this.mainAPIUri = mainAPIUri;
    }

    public String getMainSlideShowImagesUri() {
        return mainSlideShowImagesUri;
    }

    public void setMainSlideShowImagesUri(String mainSlideShowImagesUri) {
        this.mainSlideShowImagesUri = mainSlideShowImagesUri;
    }

    public String getCategoryImagesUri() {
        return categoryImagesUri;
    }

    public void setCategoryImagesUri(String categoryImagesUri) {
        this.categoryImagesUri = categoryImagesUri;
    }

    public String getCategoryHeaderUri() {
        return categoryHeaderUri;
    }

    public void setCategoryHeaderUri(String categoryHeaderUri) {
        this.categoryHeaderUri = categoryHeaderUri;
    }

    public String getSubCategoryImagesUri() {
        return subCategoryImagesUri;
    }

    public void setSubCategoryImagesUri(String subCategoryImagesUri) {
        this.subCategoryImagesUri = subCategoryImagesUri;
    }

    public String getItemsImageUri() {
        return itemsImageUri;
    }

    public void setItemsImageUri(String itemsImageUri) {
        this.itemsImageUri = itemsImageUri;
    }

    public String getBrandImageUri() {
        return brandImageUri;
    }

    public void setBrandImageUri(String brandImageUri) {
        this.brandImageUri = brandImageUri;
    }

    public String getSocialMediaUri() {
        return socialMediaUri;
    }

    public void setSocialMediaUri(String socialMediaUri) {
        this.socialMediaUri = socialMediaUri;
    }

    public String getAdvertisementImageUri() {
        return advertisementImageUri;
    }

    public void setAdvertisementImageUri(String advertisementImageUri) {
        this.advertisementImageUri = advertisementImageUri;
    }

    public String getOtherImageUri() {
        return otherImageUri;
    }

    public void setOtherImageUri(String otherImageUri) {
        this.otherImageUri = otherImageUri;
    }

    public String getTermsAndConditionsUri() {
        return termsAndConditionsUri;
    }

    public void setTermsAndConditionsUri(String termsAndConditionsUri) {
        this.termsAndConditionsUri = termsAndConditionsUri;
    }

    public String getPrivacyPolicyUri() {
        return privacyPolicyUri;
    }

    public void setPrivacyPolicyUri(String privacyPolicyUri) {
        this.privacyPolicyUri = privacyPolicyUri;
    }

    public String getOurServicesUri() {
        return ourServicesUri;
    }

    public void setOurServicesUri(String ourServicesUri) {
        this.ourServicesUri = ourServicesUri;
    }

    public String getContactUsUri() {
        return contactUsUri;
    }

    public void setContactUsUri(String contactUsUri) {
        this.contactUsUri = contactUsUri;
    }

    public String getAboutUsUri() {
        return aboutUsUri;
    }

    public void setAboutUsUri(String aboutUsUri) {
        this.aboutUsUri = aboutUsUri;
    }

    public String getServerMappedImagePath() {
        return serverMappedImagePath;
    }

    public void setServerMappedImagePath(String serverMappedImagePath) {
        this.serverMappedImagePath = serverMappedImagePath;
    }

    public int getNewOrderRefreshInterval() {
        return newOrderRefreshInterval;
    }

    public void setNewOrderRefreshInterval(int newOrderRefreshInterval) {
        this.newOrderRefreshInterval = newOrderRefreshInterval;
    }

    public boolean isAllowDiscountInPOS() {
        return allowDiscountInPOS;
    }

    public void setAllowDiscountInPOS(boolean allowDiscountInPOS) {
        this.allowDiscountInPOS = allowDiscountInPOS;
    }

    public String getCrystalReportPath() {
        return crystalReportPath;
    }

    public void setCrystalReportPath(String crystalReportPath) {
        this.crystalReportPath = crystalReportPath;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
