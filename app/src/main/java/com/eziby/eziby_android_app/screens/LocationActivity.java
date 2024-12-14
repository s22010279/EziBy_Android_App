package com.eziby.eziby_android_app.screens;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.eziby.eziby_android_app.MainActivity;
import com.eziby.eziby_android_app.R;

public class LocationActivity extends AppCompatActivity {
    public static final String PERMISSION = "PermissionValues";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void btn_onclick(View view) {

        ActivityCompat.requestPermissions(LocationActivity.this, new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION
        }, 100);
    }

    public void btn_skip_onclick(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
            Log.e(PERMISSION, "ACCESS FINE LOCATION is Enabled");
        //Intent i = new Intent(this, LoginActivity.class);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
