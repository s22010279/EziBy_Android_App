package com.eziby.eziby_android_app.screens;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.eziby.eziby_android_app.R;

public class Flash_Activity extends AppCompatActivity {
    public static final String TAG = "PermissionValues";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
    }

    public void btn_onclick(View view) {
        Intent i;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "ACCESS_FINE_LOCATION is Disabled");
            i = new Intent(this, Location_Activity.class);
        } else {
            Log.d(TAG, "ACCESS_FINE_LOCATION is Enabled");
//            i = new Intent(this, Login_Activity.class);
            i = new Intent(this, Main_Activity.class);
        }
        startActivity(i);
    }
}
