package com.eziby.eziby_android_app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.Item;
import com.eziby.eziby_android_app.R;
import com.eziby.eziby_android_app.screens.Order_2_Review;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ImageViewHolder> {
    public static final String TAG = "Image Path";
    private final Context context;
    private final List<String> imageList;
    private final List<String> nameList;
    private final String mainUri;

    public ItemAdapter(Context context, List<Item> itemArray) {
        List<String> imageList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();

        for (Item item : itemArray) {
            imageList.add(item.getItemImage1());
            nameList.add(item.getItemName());
        }

        try (DbHelper setupNet = new DbHelper(context)) {
            this.mainUri = setupNet.getASetup().getItemsImageUri();
        }

        this.context = context;
        this.imageList = imageList;
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Uri imageUri = Uri.parse(this.mainUri + imageList.get(position));
        Log.e(TAG, imageList.get(position));
        Picasso.get()
                .load(imageUri) // Image URL
                .placeholder(R.drawable.loading_image_light_grey_100) // Placeholder image while loading
//                .error(R.drawable.error_image_30) // Error image if the URL fails to load
                .into(holder.imageView); // Target ImageView

        holder.textView.setText(Optional.ofNullable(nameList.get(position)).orElse(""));

        holder.btn_add_to_cart.setOnClickListener(v -> {
            // Create an Intent to navigate to SecondActivity
            Intent intent = new Intent(context, Order_2_Review.class);
            // You can pass data with the intent if necessary
            // intent.putExtra("item", item);
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return imageList.size();
    }


    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        Button btn_add_to_cart;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.product_image);
            textView = itemView.findViewById(R.id.product_name);
            btn_add_to_cart = itemView.findViewById(R.id.add_to_cart_button);
        }


    }
}
