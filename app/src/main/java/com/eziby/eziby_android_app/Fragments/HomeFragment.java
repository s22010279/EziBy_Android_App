package com.eziby.eziby_android_app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.eziby.eziby_android_app.Adapters.BrandAdapter;
import com.eziby.eziby_android_app.Adapters.CarouselImagesAdapter;
import com.eziby.eziby_android_app.Adapters.CategoryAdapter;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.Brand;
import com.eziby.eziby_android_app.Models.CarouselImage;
import com.eziby.eziby_android_app.Models.Category;
import com.eziby.eziby_android_app.R;

import java.util.List;


public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);
        ViewPager2 viewPagerCarousel = view.findViewById(R.id.viewPagerCarousel);

        List<CarouselImage> carouselImages;
        List<Category> categories;
        List<Brand> brands;
        try (DbHelper dbHelper = new DbHelper(view.getContext())) {
            carouselImages = dbHelper.getCarouselImages();
            categories = dbHelper.getCategories();
            brands = dbHelper.getBrands();
        }

        CarouselImagesAdapter adapter = new CarouselImagesAdapter(this.getContext(),  carouselImages);
        viewPagerCarousel.setAdapter(adapter);
        int padding = getResources().getDimensionPixelSize(R.dimen.carousel_padding);
        viewPagerCarousel.setPadding(padding, 0, padding, 0);

        viewPagerCarousel.setOffscreenPageLimit(2);

        // Set up RecyclerView - Category
        RecyclerView recyclerViewCategory = view.findViewById(R.id.recycler_view_category);
        recyclerViewCategory.setLayoutManager(new GridLayoutManager(this.getContext(), 3)); // 3 columns
        recyclerViewCategory.setAdapter(new CategoryAdapter(this.getContext(), categories));

        // Set up RecyclerView - Brand
        RecyclerView recyclerViewBrand = view.findViewById(R.id.recycler_view_brand);
        recyclerViewBrand.setLayoutManager(new GridLayoutManager(this.getContext(), 4)); // 4 columns
        recyclerViewBrand.setAdapter(new BrandAdapter(this.getContext(), brands));

        return view;
    }

//    private void loadPlaces() {
//        try (DbHelper dbHelper = new DbHelper(this.getContext())) {
//            List<MyPlace> places = dbHelper.getPlaces(null);
//            if (places.size() > 0) {
//                layout.removeAllViews();
//                for (int i = 0; i < places.size(); i++)
//                    addCard(places.get(i));
//            }
//        }
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

//    private void addCard(MyPlace myPlace) {
//        final View view = getLayoutInflater().inflate(R.layout.card_home, (ViewGroup) layout.getParent(), false);
//        TextView place_header_text = view.findViewById(R.id.txt_user_and_date);
//        TextView place_details_text = view.findViewById(R.id.txt_comment);
//        TextView txtCreatedBy = view.findViewById(R.id.txtCreatedBy);
//        TextView txtCreateOn = view.findViewById(R.id.txtCreateOn);
//        ImageView place_image = view.findViewById(R.id.place_image);
//        Button btn_details = view.findViewById(R.id.btnNavigate);
//
//        String headerText = myPlace.getHeader() + " (" + myPlace.getCountry() + ")";
//        place_header_text.setText(headerText);
//        place_details_text.setText(myPlace.getDetail());
//        String createdBy = "Created By: " + myPlace.getEmailAddress();
//        txtCreatedBy.setText(createdBy);
//        String createdOn = "Created On: " + myPlace.getDateCreated();
//        txtCreateOn.setText(createdOn);
//        File imageFileName = new File(myPlace.getImage());
//        Picasso.get().load(imageFileName).into(place_image);
//
//        btn_details.setOnClickListener(v -> {
//            Intent intent = new Intent(v.getContext(), PlaceViewActivity.class);
//            Bundle bundle = new Bundle();
//            bundle.putInt("placeId", myPlace.getPlaceId()); //Your id
//            intent.putExtras(bundle); //Put your id to your next Intent
//            startActivity(intent);
//        });
//
//        layout.addView(view);
//    }

}