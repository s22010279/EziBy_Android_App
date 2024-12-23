package com.eziby.eziby_android_app.screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.eziby.eziby_android_app.R;

public class Order_2_Review extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_2_order_review);

        //btn_place_order Button
        Button btn_proceed_to_payment = this.findViewById(R.id.btn_proceed_to_payment);
        btn_proceed_to_payment.setOnClickListener(v -> {
            // Create an Intent to navigate to SecondActivity
            Intent intent = new Intent(this, Order_3_PaymentMethod.class);
            this.startActivity(intent);
        });
    }
}