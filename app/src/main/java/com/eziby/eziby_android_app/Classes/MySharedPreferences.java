package com.eziby.eziby_android_app.Classes;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class MySharedPreferences extends AppCompatActivity {
    Context mContext;

    public MySharedPreferences(Context context) {
        this.mContext = context;
    }

    public void saveProfileImage(Bitmap imageTaken) {
        String base64ImageString = DbBitmapUtility.getBase64String(imageTaken);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("PROFILE_IMAGE" + getEmail(), base64ImageString);
        edit.apply();
    }

    public Bitmap getProfileImage() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        String previouslyEncodedImage = sharedPreferences.getString("PROFILE_IMAGE" + getEmail(), "");

        if (!previouslyEncodedImage.equalsIgnoreCase("")) {
            return DbBitmapUtility.getImage(previouslyEncodedImage);
        }
        return null;
    }

    public void removeProfileImage() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove("PROFILE_IMAGE" + getEmail());
        edit.apply();
    }

    public void saveEmail(String valueToSave) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("EMAIL", valueToSave);
        edit.apply();
    }

    public String getEmail() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        String readValue = sharedPreferences.getString("EMAIL", "");

        if (!readValue.equalsIgnoreCase("")) {
            return readValue;
        }
        return null;
    }

    public void removeEmail() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove("EMAIL");
        edit.apply();
    }
}