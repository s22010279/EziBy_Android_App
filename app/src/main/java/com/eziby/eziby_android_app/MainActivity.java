package com.eziby.eziby_android_app;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.eziby.eziby_android_app.Classes.MySharedPreferences;
import com.eziby.eziby_android_app.Models.MyUser;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.databinding.ActivityMainBinding;
import com.eziby.eziby_android_app.Fragments.AboutUsFragment;
import com.eziby.eziby_android_app.Fragments.HomeFragment;
import com.eziby.eziby_android_app.Fragments.MySpotFragment;
import com.eziby.eziby_android_app.Fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    public static MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //set the initial view with Home Fragment
        replaceFragment(new HomeFragment());

//        //************* REMOVE IT LATER
//        new MySharedPreferences(this).saveEmail("swordcicle@gmail.com");
//        //*****************************
        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            int menuItemId = item.getItemId();

            if (menuItemId == R.id.home) {
                replaceFragment(new HomeFragment());
                return true;
            } else if (menuItemId == R.id.myspots) {
                replaceFragment(new MySpotFragment());
                return true;
            } else if (menuItemId == R.id.profile) {
                replaceFragment(new ProfileFragment());
                return true;
            } else if (menuItemId == R.id.aboutUs) {
                replaceFragment(new AboutUsFragment());
                return true;
            }
            return true;
        });

        String email = new MySharedPreferences(this).getEmail();
        try (DbHelper dbHelper = new DbHelper(this)) {
            MyUser myUser = dbHelper.getUser(email);
            if (myUser.isBackgroundMusic()) playMediaPlayer(this);
        }
    }

    public static void playMediaPlayer( Context mContext) {
        if (MainActivity.mediaPlayer == null)
            MainActivity.mediaPlayer = MediaPlayer.create(mContext,
                    R.raw.profile_background_music);
        mediaPlayer.setLooping(true);
        if (MainActivity.mediaPlayer != null) MainActivity.mediaPlayer.start();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.containerMain, fragment);
        transaction.commit();
    }
}