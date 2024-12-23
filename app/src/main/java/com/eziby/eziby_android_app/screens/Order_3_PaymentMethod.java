package com.eziby.eziby_android_app.screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.eziby.eziby_android_app.R;

public class Order_3_PaymentMethod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_3_payment_method);

        //btn_place_order Button
        Button btn_place_order = this.findViewById(R.id.btn_place_order);
        btn_place_order.setOnClickListener(v -> {
            // Create an Intent to navigate to SecondActivity
            Intent intent = new Intent(this, Order_4_ThankYou.class);
            this.startActivity(intent);
        });
    }
}