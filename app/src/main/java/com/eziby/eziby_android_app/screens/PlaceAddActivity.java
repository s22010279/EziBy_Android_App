package com.eziby.eziby_android_app.screens;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.eziby.eziby_android_app.Classes.DbBitmapUtility;
import com.eziby.eziby_android_app.Classes.MySharedPreferences;
import com.eziby.eziby_android_app.Models.MyPlace;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class PlaceAddActivity extends AppCompatActivity implements LocationListener {
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 1888;
    public static final String TAG = "CameraValues";
    EditText txtHeader, txtCountry, txtLatLang, txtDetail;
    ImageView imgPlace;
    Button btnSetGoogleLocation, btnSavePlace, btnLoadImage;
    SwitchMaterial switchShare;
    int placeId = 0;
    MyPlace myPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_add);

        txtHeader = findViewById(R.id.txtHeader);
        txtCountry = findViewById(R.id.txtCountry);
        txtDetail = findViewById(R.id.txtDetail);
        txtLatLang = findViewById(R.id.txtLatLang);

        imgPlace = findViewById(R.id.imgPlace);

        btnSetGoogleLocation = findViewById(R.id.btnSetGoogleLocation);
        btnSavePlace = findViewById(R.id.btnSavePlace);
        btnLoadImage = findViewById(R.id.btnLoadImage);

        switchShare = findViewById(R.id.switchShare);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            placeId = bundle.getInt("placeId");
        Log.e("PassedValue", String.valueOf(placeId));

        if (placeId != 0) {
//            try (DbHelper dbHelper = new DbHelper(this)) {
//                myPlace = dbHelper.getAPlace(placeId);
//            }


            txtHeader.setText(myPlace.getHeader());
            txtCountry.setText(myPlace.getCountry());
            txtDetail.setText(myPlace.getDetail());
            txtLatLang.setText(myPlace.getGoogleDirection());
            File imageFileName = new File(myPlace.getImage());
            Picasso.get().load(imageFileName).into(imgPlace);
            switchShare.setChecked(myPlace.getShared() == 1);
            String btnName = "Update Place";
            btnSavePlace.setText(btnName);
        }

        setGoogleLocation();
        saveProcedure();
        takePhoto();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        try {
            if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
                if (resultCode == Activity.RESULT_OK) {
                    Bitmap imageTaken = (Bitmap) Objects.requireNonNull(intent.getExtras()).get("data");
                    if (imageTaken != null) {
                        imgPlace.setImageBitmap(imageTaken);
                        showToastMessage("Image Captured");
                    }
                } else if (resultCode == Activity.RESULT_CANCELED) {
                    showToastMessage("Cancelled image capture");
                } else {
                    showToastMessage("Failed to capture image");
                }
            }
        } catch (Exception ex) {
            Log.e(TAG, "Error Occurred - " + ex.getMessage());
        }
    }

    void takePhoto() {
        btnLoadImage.setOnClickListener(view -> {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
        });
    }

    void setGoogleLocation() {
        btnSetGoogleLocation.setOnClickListener(v -> {
            //todo
        });
    }

    void saveProcedure() {
        btnSavePlace.setOnClickListener(v -> {

            String email = new MySharedPreferences(this).getEmail();
            String header = txtHeader.getText().toString().trim();
            String country = txtCountry.getText().toString().trim();
            String detail = txtDetail.getText().toString().trim();
            String latLang = txtLatLang.getText().toString().trim();
            int shared = switchShare.isChecked() ? 1 : 0;

            Drawable imageTaken = imgPlace.getDrawable();
            BitmapDrawable bitmapDrawable = ((BitmapDrawable) imageTaken);
            if (bitmapDrawable == null) {
                showToastMessage("Take the Place Image");
                btnLoadImage.requestFocus();
                return;
            }

            Bitmap placeImage = bitmapDrawable.getBitmap();

            //validation part
            if (header.isEmpty()) {
                showToastMessage("Enter the Header");
                txtHeader.requestFocus();
                return;
            }

            if (country.isEmpty()) {
                showToastMessage("Enter the Country");
                txtCountry.requestFocus();
                return;
            }

            if (detail.isEmpty()) {
                showToastMessage("Enter the Details");
                txtDetail.requestFocus();
                return;
            }

            if (latLang.isEmpty()) {
                showToastMessage("Set the Google Location");
                btnSetGoogleLocation.requestFocus();
                return;
            }


            //saving the image first and get the file name
            String imageFileName;
            try {
                imageFileName = DbBitmapUtility.saveImageToCache(this.getCacheDir().toString(), placeImage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //saving the place record
            try (DbHelper dbHelper1 = new DbHelper(this)) {
                MyPlace myPlace = new MyPlace();
                myPlace.setPlaceId(placeId);
                myPlace.setEmailAddress(email);
                myPlace.setHeader(header);
                myPlace.setDetail(detail);
                myPlace.setCountry(country);
                myPlace.setImage(imageFileName);
                myPlace.setGoogleDirection(latLang);
                myPlace.setDateCreated("will be set by function");
                myPlace.setShared(shared);
//                if (placeId > 0) {
//                    if (dbHelper1.updatePlace(myPlace)) {
//                        showToastMessage("Place Updated");
//                        setResult(2);
//                        this.finish();
//                    } else {
//                        showToastMessage("Error Occurred");
//                    }
//                } else {
//                    if (dbHelper1.insertPlace(myPlace)) {
//                        showToastMessage("Place Added");
//                        setResult(2);
//                        this.finish();
//                    } else {
//                        showToastMessage("Error Occurred");
//                    }
//                }

            }


        });
    }

    void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        Log.e("LocationValues", "Lat: " + location.getLatitude() + " Lang: " + location.getLongitude());
    }
}