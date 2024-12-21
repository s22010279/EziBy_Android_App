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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Adapters.CategoryAdapter;
import com.eziby.eziby_android_app.Models.MyPlace;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.R;
import com.eziby.eziby_android_app.screens.PlaceViewActivity;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {
    LinearLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView11);

        // Sample images (replace with your drawable resources)
        List<String> images_path = Arrays.asList(
                "https://images.eziby.lk/EziBy_Images/Category/0000001_1_3HIQIDEM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000002_1_B10TCNEM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000003_1_ENEGFDEM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000005_1_5OW87NAM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000006_1_JT1Q4TAM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000008_1_IAD6W9AM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000011_1_THQKD9EM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000012_1_R76SBNEM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000013_1_9UUUXDEM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000014_1_F1CATNEM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000015_1_I298ODEM2GG.jpg",
                "https://images.eziby.lk/EziBy_Images/Category/0000016_1_ZULYLTEM2GG.jpg"
        );

        List<String> categoryNames = Arrays.asList(
                "Food,Cooking & Grains",
                "Oil & Ghee",
                "Masala & Spices",
                "Bath & Hygiene",
                "Cleaning & House Keeping",
                "Baby Care",
                "Biscuits, Snacks & Bakery Products",
                "Milk Products & Beverages",
                "Beauty, cosmetic & personal care",
                "Ayurvedic and English Medicine",
                "Egg, Meat & Fish",
                "Stationer"
        );

        // Set up RecyclerView
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 3)); // 3 columns
        recyclerView.setAdapter(new CategoryAdapter(this.getContext(), images_path, categoryNames));

//        layout = view.findViewById(R.id.linear_layout_fragment_home);
//
//        loadPlaces();

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