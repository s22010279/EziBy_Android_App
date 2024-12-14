package com.eziby.eziby_android_app.screens;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.eziby.eziby_android_app.Classes.MyGeoLocation;
import com.eziby.eziby_android_app.Classes.MySharedPreferences;
import com.eziby.eziby_android_app.Models.MyComment;
import com.eziby.eziby_android_app.Models.MyPlace;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class PlaceViewActivity extends AppCompatActivity implements OnMapReadyCallback {
    DbHelper dbHelper;
    MyPlace myPlace;

    ImageView place_image;

    Button btnGoogleMap, btnNavigate, btnComment, btnDeleteComment;
    TextView place_header_text, place_details_text, txtComment;

    MyGeoLocation myGeoLocation;

    LinearLayout layout;

    int placeId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_view);

        dbHelper = new DbHelper(this);
        myGeoLocation = new MyGeoLocation(this, PlaceViewActivity.this);

        place_image = findViewById(R.id.place_image);

        btnGoogleMap = findViewById(R.id.btnGoogleMap);
        btnNavigate = findViewById(R.id.btnNavigate);
        btnComment = findViewById(R.id.btnComment);

        place_header_text = findViewById(R.id.place_header_text);
        place_details_text = findViewById(R.id.place_details_text);
        txtComment = findViewById(R.id.txtComment);
//        txtComment.requestFocus();
        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
            placeId = bundle.getInt("placeId");
        Log.e("PassedValue", String.valueOf(placeId));

        if (placeId != 0) {
            myPlace = dbHelper.getAPlace(placeId);

            place_header_text.setText(myPlace.getHeader());
            place_details_text.setText(myPlace.getDetail());
            File imageFileName = new File(myPlace.getImage());
            Picasso.get().load(imageFileName).into(place_image);

            registerButtonListeners();
        }

        addCommentsCards();
    }

    void addCommentsCards() {
        layout = findViewById(R.id.containerPlaceView);
        layout.removeAllViews();
        layout.setScrollContainer(true);
        List<MyComment> myComments = dbHelper.getComments(placeId);
        if (myComments.size() > 0)
            for (int i = 0; i < myComments.size(); i++)
                addCardComment(myComments.get(i));
    }

    void registerButtonListeners() {
        btnGoogleMap.setOnClickListener(v -> toLocation(myPlace.getGoogleDirection(), false));

        btnNavigate.setOnClickListener(v -> toLocation(myPlace.getGoogleDirection(), true));

        btnComment.setOnClickListener(view -> {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (this.getCurrentFocus() != null)
                inputManager.hideSoftInputFromWindow(Objects.requireNonNull(this.getCurrentFocus()).getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

            if (txtComment.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Please type your comment.", Toast.LENGTH_SHORT).show();
                return;
            }
            String email1 = new MySharedPreferences(view.getContext()).getEmail();
            try (DbHelper dbHelper = new DbHelper(view.getContext())) {
                MyComment myComment = new MyComment();
                myComment.setPlaceId(placeId);
                myComment.setEmailAddress(email1);
                myComment.setComment(txtComment.getText().toString());
                if (dbHelper.insertComment(myComment)) {
                    txtComment.setText("");
                    addCommentsCards();
                    Toast.makeText(this, "Comment Added.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Location location = myGeoLocation.currentLocation;
        LatLng latLangCurrentLocation = new LatLng(location.getLatitude(), location.getLongitude());
        googleMap.addMarker(new MarkerOptions().position(latLangCurrentLocation).title("Current Location"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLangCurrentLocation, 18.0f));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    private void toLocation(String latLang, boolean isNavigation) {
        Uri uri;
        Intent intent;
        try {
            if (isNavigation) {
                uri = Uri.parse("google.navigation:q=" + latLang + "&mode=d");
            } else {
                uri = Uri.parse("http://maps.google.com/maps?daddr=" + latLang);
            }
        } catch (ActivityNotFoundException exception) {
            uri = Uri.parse("");
        }
        intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void addCardComment(MyComment myComment) {
        final View view = getLayoutInflater().inflate(R.layout.card_comment, (ViewGroup) layout.getParent(), false);
        TextView txt_comment = view.findViewById(R.id.txt_comment);
        TextView txt_user_and_date = view.findViewById(R.id.txt_user_and_date);

        txt_comment.setText(myComment.getComment());
        String commentedBy = myComment.getEmailAddress() + " - " + myComment.getCommentedDate();
        txt_user_and_date.setText(commentedBy);

        String email1 = new MySharedPreferences(view.getContext()).getEmail();

        btnDeleteComment = view.findViewById(R.id.btnDeleteComment);
        if (Objects.equals(email1, myComment.getEmailAddress())) {
            btnDeleteComment.setOnClickListener(v -> new AlertDialog.Builder(this)
                    .setTitle("Delete")
                    .setMessage("Remove comment?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(android.R.string.yes, (dialog, whichButton) -> {
                        Integer recordDeleted;
                        try (DbHelper dbHelper = new DbHelper(this)) {
                            recordDeleted = dbHelper.deleteComment(myComment.getCommentId());
                        }
                        if (recordDeleted > 0) {
                            addCommentsCards();
                            Toast.makeText(this, "Comment Deleted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Not Deleted!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton(android.R.string.no, null).show());
        } else {
            btnDeleteComment.setVisibility(View.INVISIBLE);
        }
        layout.addView(view);
    }
}