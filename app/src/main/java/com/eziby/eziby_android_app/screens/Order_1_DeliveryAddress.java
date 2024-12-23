package com.eziby.eziby_android_app.screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.eziby.eziby_android_app.R;

public class Order_1_DeliveryAddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_1_delivery_address);

        //btn_place_order Button
        Button btn_review_details = this.findViewById(R.id.btn_review_details);
        btn_review_details.setOnClickListener(v -> {
            // Create an Intent to navigate to SecondActivity
            Intent intent = new Intent(this, Order_2_Review.class);
            this.startActivity(intent);
        });
    }

}