package com.eziby.eziby_android_app.screens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.eziby.eziby_android_app.R;

public class Order_4_ThankYou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_4_thankyou);

        //btn_place_order Button
        Button btn_continue_shopping = this.findViewById(R.id.btn_continue_shopping);
        btn_continue_shopping.setOnClickListener(v -> {
            // Create an Intent to navigate to SecondActivity
            Intent intent = new Intent(this, Main_Activity.class);
            this.startActivity(intent);
        });
    }
}