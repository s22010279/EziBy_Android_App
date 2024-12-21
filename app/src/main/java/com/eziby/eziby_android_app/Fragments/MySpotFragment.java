package com.eziby.eziby_android_app.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.eziby.eziby_android_app.Models.MyPlace;
import com.eziby.eziby_android_app.R;
import com.eziby.eziby_android_app.screens.PlaceAddActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.File;

public class MySpotFragment extends Fragment {
    LinearLayout layout;
    TextView emptyViewLayout1, emptyViewLayout2;
    Button btnDeletePlace, btnEditPlace;
    FloatingActionButton btnAddPlace;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2) {
//            loadPlaces();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_spot,
                container, false);

        btnAddPlace = view.findViewById(R.id.btnAddPlace);

        emptyViewLayout1 = view.findViewById(R.id.emptyViewLayout1);
        emptyViewLayout2 = view.findViewById(R.id.emptyViewLayout2);
        layout = view.findViewById(R.id.containerViewLayout);
//        loadPlaces();

        btnAddPlace.setOnClickListener(v -> {

            Intent i = new Intent(v.getContext(), PlaceAddActivity.class);
            startActivityForResult(i, 0);
        });
        return view;
    }

//    private void loadPlaces() {
//        String email = new MySharedPreferences(this.getContext()).getEmail();
//        try (DbHelper dbHelper = new DbHelper(this.getContext())) {
//            List<MyPlace> places = dbHelper.getPlaces(email);
//            layout.removeAllViews();
//            if (places.size() > 0) {
//                for (int i = 0; i < places.size(); i++)
//                    addCard(places.get(i));
//            } else {
//                layout.addView(emptyViewLayout1);
//                layout.addView(emptyViewLayout2);
//            }
//        }
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void addCard(MyPlace myPlace) {
        final View view = getLayoutInflater().inflate(R.layout.card_spot, (ViewGroup) layout.getParent(), false);
        TextView place_header_text = view.findViewById(R.id.txt_user_and_date);
        TextView place_details_text = view.findViewById(R.id.txt_comment);
        ImageView place_image = view.findViewById(R.id.place_image);

        btnDeletePlace = view.findViewById(R.id.btnDeletePlace);
        btnEditPlace = view.findViewById(R.id.btnEditPlace);

        String headerText = myPlace.getHeader() + " (" + myPlace.getCountry() + ")";
        place_header_text.setText(headerText);
        place_details_text.setText(myPlace.getDetail());
        File imageFileName = new File(myPlace.getImage());
        Picasso.get().load(imageFileName).into(place_image);

        btnDeletePlace.setOnClickListener(v -> {

            new AlertDialog.Builder(this.requireContext())
                    .setTitle("Delete")
                    .setMessage("Do you really want to Delete a Place?")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(android.R.string.yes, (dialog, whichButton) -> {
                        Integer recordDeleted = 0;
//                        try (DbHelper dbHelper = new DbHelper(this.getContext())) {
//                            dbHelper.deleteComments(myPlace.getPlaceId());
//                            recordDeleted = dbHelper.deleteAPlace(myPlace.getPlaceId());
//                        }
//                        if (recordDeleted > 0) {
//                            loadPlaces();
//                            Toast.makeText(getActivity(), "Place Deleted", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(getActivity(), "Not Deleted!", Toast.LENGTH_SHORT).show();
//                        }
                    })
                    .setNegativeButton(android.R.string.no, null).show();
        });

        btnEditPlace.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), PlaceAddActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("placeId", myPlace.getPlaceId()); //Your id
            intent.putExtras(bundle); //Put your id to your next Intent
            startActivityForResult(intent, 0);
        });

        layout.addView(view);
    }
}