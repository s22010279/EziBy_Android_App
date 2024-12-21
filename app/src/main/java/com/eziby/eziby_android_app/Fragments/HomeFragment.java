package com.eziby.eziby_android_app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.eziby.eziby_android_app.Adapters.BrandAdapter;
import com.eziby.eziby_android_app.Adapters.CarouselImagesAdapter;
import com.eziby.eziby_android_app.Adapters.CategoryAdapter;
import com.eziby.eziby_android_app.Adapters.ItemAdapter;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.Brand;
import com.eziby.eziby_android_app.Models.CarouselImage;
import com.eziby.eziby_android_app.Models.Category;
import com.eziby.eziby_android_app.Models.Item;
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
        List<Item> items;

        try (DbHelper dbHelper = new DbHelper(view.getContext())) {
            carouselImages = dbHelper.getCarouselImages();
            categories = dbHelper.getCategories();
            brands = dbHelper.getBrands();
            items = dbHelper.getItems();
        }

        CarouselImagesAdapter adapter = new CarouselImagesAdapter(this.getContext(), carouselImages);
        viewPagerCarousel.setAdapter(adapter);
        int padding = getResources().getDimensionPixelSize(R.dimen.carousel_padding);
        viewPagerCarousel.setPadding(padding, 0, padding, 0);
        viewPagerCarousel.setOffscreenPageLimit(2);

        // Set up RecyclerView - Category
        RecyclerView recyclerViewCategory = view.findViewById(R.id.recycler_view_category);
        recyclerViewCategory.setLayoutManager(new GridLayoutManager(this.getContext(), 2)); // 3 columns
        recyclerViewCategory.setAdapter(new CategoryAdapter(this.getContext(), categories));

        // Set up RecyclerView - Brand
        RecyclerView recyclerViewBrand = view.findViewById(R.id.recycler_view_brand);
        recyclerViewBrand.setLayoutManager(new GridLayoutManager(this.getContext(), 3)); // 4 columns
        recyclerViewBrand.setAdapter(new BrandAdapter(this.getContext(), brands));

        // Set up RecyclerView - Items
        RecyclerView recyclerViewItem = view.findViewById(R.id.recycler_view_new_arrivals);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewItem.setLayoutManager(layoutManager);
        recyclerViewItem.setAdapter(new ItemAdapter(this.getContext(), items));

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}