package com.eziby.eziby_android_app.screens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

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
        Intent intent = this.getIntent();
        int brandId = intent.getIntExtra("brandId", 0); // -1 is the default value if "brandId" is not found
        int categoryId = intent.getIntExtra("categoryId", 0); // -1 is the default value if "brandId" is not found
        Log.d("Ids", "Received CategoryId: " + categoryId + ", Received BrandId: " + brandId);

        List<Item> itemList;

        try (DbHelper dbHelper = new DbHelper(this)) {
            itemList = dbHelper.getItems(brandId, categoryId,0);
        }
        RecyclerView recyclerViewBrand = this.findViewById(R.id.recycler_view_item);
        recyclerViewBrand.setLayoutManager(new GridLayoutManager(this, 2)); // 4 columns
        recyclerViewBrand.setAdapter(new ItemListAdapter(this, itemList));

        LinearLayout linear_layout_no_item_found;
        linear_layout_no_item_found = this.findViewById(R.id.linear_layout_no_item_found);
        linear_layout_no_item_found.setVisibility(itemList.size() > 0 ? View.INVISIBLE : View.VISIBLE);
    }
}