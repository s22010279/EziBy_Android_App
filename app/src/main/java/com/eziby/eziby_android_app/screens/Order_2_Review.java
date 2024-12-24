package com.eziby.eziby_android_app.screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Adapters.ReviewAdapter;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.ShoppingCartViewModel;
import com.eziby.eziby_android_app.R;

import java.util.List;

public class Order_2_Review extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_2_order_review);

        List<ShoppingCartViewModel> shoppingCartViewModelList;

        try (DbHelper dbHelper = new DbHelper(this)) {
            shoppingCartViewModelList = dbHelper.getShoppingCarts(1);
        }

        // Set up RecyclerView
        RecyclerView recyclerViewReviewItem = this.findViewById(R.id.recycler_view_review_item);
        recyclerViewReviewItem.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerViewReviewItem.setAdapter(new ReviewAdapter(this, shoppingCartViewModelList));

        //btn_place_order Button
        Button btn_proceed_to_payment = this.findViewById(R.id.btn_proceed_to_payment);
        btn_proceed_to_payment.setOnClickListener(v -> {
            // Create an Intent to navigate to SecondActivity
            Intent intent = new Intent(this, Order_3_PaymentMethod.class);
            this.startActivity(intent);
        });
    }
}