package com.eziby.eziby_android_app.Fragments;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.eziby.eziby_android_app.Classes.MySharedPreferences;
import com.eziby.eziby_android_app.screens.MainActivity;
import com.eziby.eziby_android_app.Models.MyUser;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ProfileFragment extends Fragment {
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 1888;
    public static final String TAG = "CameraValues";
    SwitchMaterial switchPlayMusic, switchNewsLetter;
    Button btn_change_image, btn_signOut;
    ImageView image_profile;
    TextView textViewNameValue, textViewEmailValue, textViewRatingValue, textViewMemberSinceValue, textViewContributionValue;
    MySharedPreferences sharedPreferences;
    ProgressBar progressBar_signOut;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        try {
            if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
                if (resultCode == Activity.RESULT_OK) {
                    Bitmap imageTaken = (Bitmap) Objects.requireNonNull(intent.getExtras()).get("data");
                    if (imageTaken != null) {
                        image_profile.setImageBitmap(imageTaken);
                        sharedPreferences.saveProfileImage(imageTaken);
                        Toast.makeText(getActivity(), "Image Captured", Toast.LENGTH_SHORT).show();
                    }
                } else if (resultCode == Activity.RESULT_CANCELED) {
                    Toast.makeText(getActivity(), "Cancelled image capture", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Failed to capture image", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e(TAG, "Error Occurred - " + ex.getMessage());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_profile,
                container, false);

        textViewNameValue = myView.findViewById(R.id.textViewNameValue);
        textViewEmailValue = myView.findViewById(R.id.textViewEmailValue);
        textViewRatingValue = myView.findViewById(R.id.textViewRatingValue);
        textViewMemberSinceValue = myView.findViewById(R.id.textViewMemberSinceValue);
        textViewContributionValue = myView.findViewById(R.id.textViewContributionValue);
        image_profile = myView.findViewById(R.id.image_profile);
        switchPlayMusic = myView.findViewById(R.id.switch_Music);
        switchNewsLetter = myView.findViewById(R.id.switch_newsletter);
        progressBar_signOut = myView.findViewById(R.id.progressBar_signOut);
        btn_signOut = myView.findViewById(R.id.btn_signOut);
        btn_change_image = myView.findViewById((R.id.btn_change_image));

        if (MainActivity.mediaPlayer != null && MainActivity.mediaPlayer.isPlaying())
            switchPlayMusic.setChecked(true);

        sharedPreferences = new MySharedPreferences(myView.getContext());

        String email = sharedPreferences.getEmail();

        try (DbHelper userNet = new DbHelper(myView.getContext())) {
            MyUser myUser = userNet.getUser(email);
            textViewNameValue.setText(myUser.getDisplayName());
            textViewEmailValue.setText(myUser.getEmailAddress());
            switchNewsLetter.setChecked(myUser.isSubscribedToNewsLetter());
            switchPlayMusic.setChecked(myUser.isBackgroundMusic());
            textViewMemberSinceValue.setText(myUser.getMemberSince());
            textViewRatingValue.setText(String.format(myUser.getRatings() + " Star(s)"));
            textViewContributionValue.setText(myUser.getContribution());
            //getting locally saved image for the profile
            Bitmap bitmap = sharedPreferences.getProfileImage();
            if (bitmap != null) {
                image_profile.setImageBitmap(bitmap);
            } else {
                Picasso.get()
                        .load(myUser.getProfilePictureUri())
                        .placeholder(R.drawable.outline_account_circle_24)
                        .into(image_profile);
            }
        }

        if (switchPlayMusic.isChecked()) {
            MainActivity.playMediaPlayer(this.getContext());
        }

        btn_signOut.setOnClickListener(view -> {
            btn_signOut.setEnabled(false);
            sharedPreferences.removeEmail();
            sharedPreferences.removeProfileImage();
            progressBar_signOut.setVisibility(View.VISIBLE);

            Handler handler = new Handler();
            handler.postDelayed(() -> {
                PackageManager packageManager = view.getContext().getPackageManager();
                Intent intent = packageManager.getLaunchIntentForPackage(view.getContext().getPackageName());
                assert intent != null;
                ComponentName componentName = intent.getComponent();
                Intent mainIntent = Intent.makeRestartActivityTask(componentName);
                mainIntent.setPackage(view.getContext().getPackageName());
                view.getContext().startActivity(mainIntent);
                Runtime.getRuntime().exit(0);
            }, 5000);   //5 seconds
        });

        switchNewsLetter.setOnClickListener(view -> {
            if (switchNewsLetter.isChecked()) {
                Toast.makeText(getActivity(), "Subscribed to Newsletter.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Unsubscribed from Newsletter.", Toast.LENGTH_SHORT).show();
            }
            updateUserSwitchValues(view.getContext(), email);
        });

        switchPlayMusic.setOnClickListener(view -> {
            if (switchPlayMusic.isChecked()) {
                MainActivity.playMediaPlayer(this.getContext());
            } else {
                if (MainActivity.mediaPlayer != null && MainActivity.mediaPlayer.isPlaying())
                    MainActivity.mediaPlayer.pause();
            }

            if (switchPlayMusic.isChecked()) {
                Toast.makeText(getActivity(), "Background music enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Background music disabled", Toast.LENGTH_SHORT).show();
            }
            updateUserSwitchValues(view.getContext(), email);
        });


        btn_change_image.setOnClickListener(view -> {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
        });
        return myView;
    }

    void updateUserSwitchValues(Context context, String email) {
        try (DbHelper dbHelper = new DbHelper(context)) {
            MyUser myUser1 = dbHelper.getUser(email);
            myUser1.setSubscribedToNewsLetter(switchNewsLetter.isChecked());
            myUser1.setBackgroundMusic(switchPlayMusic.isChecked());
            dbHelper.updateUser(myUser1);
        }
    }
}














