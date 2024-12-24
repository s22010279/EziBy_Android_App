package com.eziby.eziby_android_app.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Classes.EziByUtility;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.ShoppingCartViewModel;
import com.eziby.eziby_android_app.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ImageViewHolder> {
    private final Context context;
    private final String mainUri;
    private final List<ShoppingCartViewModel> itemArray;
    private final String currencyMark;

    public ReviewAdapter(Context context, List<ShoppingCartViewModel> itemArray) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.component_review_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Uri imageUri = Uri.parse(this.mainUri + itemArray.get(position).getItemImage1());
        DecimalFormat decimalFormat = new DecimalFormat(EziByUtility.patternCurrency);
        String _sellingPrice = this.currencyMark + " " + decimalFormat.format(itemArray.get(position).getSellingPrice());
        int _quantity = itemArray.get(position).getQuantity();
        Picasso.get()
                .load(imageUri) // Image URL
                .placeholder(R.drawable.loading_image_light_grey_100) // Placeholder image while loading
//                .error(R.drawable.error_image_30) // Error image if the URL fails to load
                .into(holder.product_image); // Target ImageView

        holder.product_name.setText(Optional.ofNullable(itemArray.get(position).getItemName()).orElse(""));
        holder.product_price.setText(_sellingPrice);
        holder.cart_quantity.setText(String.valueOf(_quantity));
    }

    @Override
    public int getItemCount() {
        return itemArray.size();
    }


    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView product_image;
        TextView product_name;
        TextView product_price;
        TextView cart_quantity;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            product_name = itemView.findViewById(R.id.product_name);
            product_price = itemView.findViewById(R.id.product_price);
            cart_quantity = itemView.findViewById(R.id.cart_quantity);
        }
    }
}
