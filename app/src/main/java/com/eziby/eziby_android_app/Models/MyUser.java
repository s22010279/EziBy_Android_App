package com.eziby.eziby_android_app.Models;

public class MyUser {
    // Default constructor
    public MyUser() {

    }private int userId;
    private String token;
    private String emailAddress;
    private String displayName;
    private String profilePictureUri;
    private boolean subscribedToNewsLetter;
    private boolean backgroundMusic;
    private String contribution;
    private String memberSince;
    private String ratings;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfilePictureUri() {
        return profilePictureUri;
    }

    public void setProfilePictureUri(String profilePictureUri) {
        this.profilePictureUri = profilePictureUri;
    }

    public boolean isSubscribedToNewsLetter() {
        return subscribedToNewsLetter;
    }

    public void setSubscribedToNewsLetter(boolean subscribedToNewsLetter) {
        this.subscribedToNewsLetter = subscribedToNewsLetter;
    }

    public boolean isBackgroundMusic() {
        return backgroundMusic;
    }

    public void setBackgroundMusic(boolean backgroundMusic) {
        this.backgroundMusic = backgroundMusic;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }
}
