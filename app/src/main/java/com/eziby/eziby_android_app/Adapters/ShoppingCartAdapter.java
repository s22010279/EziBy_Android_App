package com.eziby.eziby_android_app.Adapters;

import android.content.Context;
import android.net.Uri;
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
import com.eziby.eziby_android_app.Models.ShoppingCartViewModel;
import com.eziby.eziby_android_app.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ImageViewHolder> {
    public static final String TAG = "Image Path";
    private final Context context;
    private final String mainUri;
    private final List<ShoppingCartViewModel> itemArray;
    private final String currencyMark;

    public ShoppingCartAdapter(Context context, List<ShoppingCartViewModel> itemArray) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.component_shopping_cart_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Uri imageUri = Uri.parse(this.mainUri + itemArray.get(position).getItemImage1());
        DecimalFormat decimalFormat = new DecimalFormat(EziByValues.patternCurrency);
        String _sellingPrice = this.currencyMark + " " + decimalFormat.format(itemArray.get(position).getSellingPrice());
        String _quantity = String.valueOf(itemArray.get(position).getQuantity());
        Picasso.get()
                .load(imageUri) // Image URL
                .placeholder(R.drawable.loading_image_light_grey_100) // Placeholder image while loading
                .error(R.drawable.error_image_30) // Error image if the URL fails to load
                .into(holder.product_image); // Target ImageView

        holder.product_name.setText(Optional.ofNullable(itemArray.get(position).getItemName()).orElse(""));
        holder.product_price.setText(_sellingPrice);
        holder.shopping_cart_quantity.setText(_quantity);
        holder.increment_button.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return itemArray.size();
    }


    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView product_image;
        TextView product_name;
        TextView product_price;
        TextView shopping_cart_quantity;
        Button increment_button;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            product_name = itemView.findViewById(R.id.product_name);
            product_price = itemView.findViewById(R.id.product_price);
            shopping_cart_quantity = itemView.findViewById(R.id.shopping_cart_quantity);
            increment_button = itemView.findViewById(R.id.increment_button);
        }
    }
}
