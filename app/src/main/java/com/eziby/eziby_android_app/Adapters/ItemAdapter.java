package com.eziby.eziby_android_app.Adapters;

import android.content.Context;
import android.graphics.Color;
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

import com.eziby.eziby_android_app.Classes.EziByValues;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.Item;
import com.eziby.eziby_android_app.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ImageViewHolder> {
    public static final String TAG = "Image Path";
    private final Context context;
    private final String mainUri;
    private final List<Item> itemArray;
    private final String currencyMark;

    public ItemAdapter(Context context, List<Item> itemArray) {
        try (DbHelper setupNet = new DbHelper(context)) {
            this.mainUri = setupNet.getASetup().getItemsImageUri();
            this.currencyMark = setupNet.getASetup().getCurrencyMark();
        }
        this.itemArray = itemArray;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Uri imageUri = Uri.parse(this.mainUri + itemArray.get(position).getItemImage1());
        Log.e(TAG, itemArray.get(position).getItemImage1());
        Picasso.get()
                .load(imageUri) // Image URL
                .placeholder(R.drawable.loading_image_light_grey_100) // Placeholder image while loading
//                .error(R.drawable.error_image_30) // Error image if the URL fails to load
                .into(holder.imageViewProduct); // Target ImageView

        holder.textViewProductName.setText(Optional.ofNullable(itemArray.get(position).getItemName()).orElse(""));
        String _description = this.currencyMark + " " + Optional.ofNullable(itemArray.get(position).getSpecification()).orElse("");
        DecimalFormat decimalFormat = new DecimalFormat(EziByValues.patternCurrency);
        String _sellingPrice = this.currencyMark + " " + decimalFormat.format(itemArray.get(position).getSellingPrice());
        holder.textViewProductPrice.setText(_sellingPrice);
        holder.textViewProductDescription.setText(_description);
        if (itemArray.get(position).getQtyOnHand() <= 0) {
            holder.btnAddToCart.setEnabled(false);
            holder.btnAddToCart.setBackgroundColor(Color.GRAY);
        }

        holder.btnAddToCart.setOnClickListener(v -> {
            try (DbHelper dbHelper = new DbHelper(context)) {
                dbHelper.increaseShoppingCart(itemArray.get(position).getItemId(), 1, 1);
            }
        });
    }


    @Override
    public int getItemCount() {
        return itemArray.size();
    }


    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProduct;
        TextView textViewProductName;
        TextView textViewProductDescription;
        TextView textViewProductPrice;
        Button btnAddToCart;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.product_image);
            textViewProductName = itemView.findViewById(R.id.product_name);
            textViewProductDescription = itemView.findViewById(R.id.product_description);
            textViewProductPrice = itemView.findViewById(R.id.product_price);
            btnAddToCart = itemView.findViewById(R.id.add_to_cart_button);
        }


    }
}
