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

import androidx.fragment.app.Fragment;

import com.eziby.eziby_android_app.Models.MyPlace;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.R;
import com.eziby.eziby_android_app.screens.PlaceViewActivity;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;


public class HomeFragment extends Fragment {
    LinearLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);

        layout = view.findViewById(R.id.containerFragmentHome);

        loadPlaces();

        return view;
    }

    private void loadPlaces() {
        try (DbHelper dbHelper = new DbHelper(this.getContext())) {
            List<MyPlace> places = dbHelper.getPlaces(null);
            if (places.size() > 0) {
                layout.removeAllViews();
                for (int i = 0; i < places.size(); i++)
                    addCard(places.get(i));
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void addCard(MyPlace myPlace) {
        final View view = getLayoutInflater().inflate(R.layout.card_home, (ViewGroup) layout.getParent(), false);
        TextView place_header_text = view.findViewById(R.id.txt_user_and_date);
        TextView place_details_text = view.findViewById(R.id.txt_comment);
        TextView txtCreatedBy = view.findViewById(R.id.txtCreatedBy);
        TextView txtCreateOn = view.findViewById(R.id.txtCreateOn);
        ImageView place_image = view.findViewById(R.id.place_image);
        Button btn_details = view.findViewById(R.id.btnNavigate);

        String headerText = myPlace.getHeader() + " (" + myPlace.getCountry() + ")";
        place_header_text.setText(headerText);
        place_details_text.setText(myPlace.getDetail());
        String createdBy = "Created By: " + myPlace.getEmailAddress();
        txtCreatedBy.setText(createdBy);
        String createdOn = "Created On: " + myPlace.getDateCreated();
        txtCreateOn.setText(createdOn);
        File imageFileName = new File(myPlace.getImage());
        Picasso.get().load(imageFileName).into(place_image);

        btn_details.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), PlaceViewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("placeId", myPlace.getPlaceId()); //Your id
            intent.putExtras(bundle); //Put your id to your next Intent
            startActivity(intent);
        });

        layout.addView(view);
    }
}