package com.eziby.eziby_android_app.screens;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.eziby.eziby_android_app.Fragments.HomeFragment;
import com.eziby.eziby_android_app.R;

public class Flash_Activity extends AppCompatActivity {
    public static final String TAG = "PermissionValues";
//    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

//        videoView = findViewById(R.id.videoView);
//        videoView.setVideoPath("android.resource://" +
//                getPackageName() + "/" +
//                R.raw.introduction_video2);
//        videoView.setCameraDistance(2);
//        videoView.start();
    }

    public void btn_onclick(View view) {
//        if (videoView.isPlaying()) videoView.stopPlayback();
//        videoView = null;

        Intent i;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.e(TAG, "ACCESS_FINE_LOCATION is Disabled");
            i = new Intent(this, Location_Activity.class);
        } else {
            Log.e(TAG, "ACCESS_FINE_LOCATION is Enabled");
            //i = new Intent(this, LoginActivity.class);
            i = new Intent(this, HomeFragment.class);
        }
        startActivity(i);
    }
}
