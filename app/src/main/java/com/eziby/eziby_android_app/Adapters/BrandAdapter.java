package com.eziby.eziby_android_app.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.Brand;
import com.eziby.eziby_android_app.R;
import com.eziby.eziby_android_app.screens.Item_List;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Optional;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ImageViewHolder> {
    public static final String TAG = "Image Path";
    private final Context context;
    private final List<Brand> itemArray;
    private final String mainUri;

    public BrandAdapter(Context context, List<Brand> itemArray) {

        try (DbHelper setupNet = new DbHelper(context)) {
            this.mainUri = setupNet.getASetup().getBrandImageUri();
        }

        this.context = context;
        this.itemArray = itemArray;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_brand, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Uri imageUri = Uri.parse(this.mainUri + itemArray.get(position).getBrandImage());
        Log.d(TAG, itemArray.get(position).getBrandImage());
        Picasso.get()
                .load(imageUri) // Image URL
                .placeholder(R.drawable.loading_image_light_grey_100) // Placeholder image while loading
//                .error(R.drawable.error_image_30) // Error image if the URL fails to load
                .into(holder.imageView); // Target ImageView

        holder.textView.setText(Optional.ofNullable(itemArray.get(position).getBrandName()).orElse(""));
        holder.imageView.setOnClickListener(v -> {
            // Create an Intent to navigate to SecondActivity
            Intent intent = new Intent(context, Item_List.class);
            // You can pass data with the intent if necessary
            intent.putExtra("brandId", itemArray.get(position).getBrandId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return itemArray.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_brand_image);
            textView = itemView.findViewById(R.id.text_view_brand_name);
        }
    }
}
