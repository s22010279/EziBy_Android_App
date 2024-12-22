package com.eziby.eziby_android_app.screens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Adapters.ItemListAdapter;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.Item;
import com.eziby.eziby_android_app.R;

import java.util.List;

public class Item_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        // Retrieve the Intent
        Intent intent = getIntent();

        // Read the "brandId" value
        int brandId = intent.getIntExtra("brandId", -1); // -1 is the default value if "brandId" is not found
        if (brandId != -1) {
            // Do something with brandId
            Log.d("BrandId", "Received brandId: " + brandId);
        } else {
            Log.e("BrandId", "No brandId was passed with the Intent.");
        }

        int categoryId = intent.getIntExtra("categoryId", -1); // -1 is the default value if "brandId" is not found
        if (categoryId != -1) {
            // Do something with brandId
            Log.d("categoryId", "Received categoryId: " + categoryId);
        } else {
            Log.e("categoryId", "No categoryId was passed with the Intent.");
        }
        // Use the brandId


        List<Item> itemList;

        try (DbHelper dbHelper = new DbHelper(this)) {
            itemList = dbHelper.getItems();
        }

        RecyclerView recyclerViewBrand = this.findViewById(R.id.recycler_view_item);
        recyclerViewBrand.setLayoutManager(new GridLayoutManager(this, 2)); // 4 columns
        recyclerViewBrand.setAdapter(new ItemListAdapter(this, itemList));
    }
}