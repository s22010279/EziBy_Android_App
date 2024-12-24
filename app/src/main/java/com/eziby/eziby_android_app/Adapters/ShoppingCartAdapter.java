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
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Classes.EziByUtility;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.ShoppingCartViewModel;
import com.eziby.eziby_android_app.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ImageViewHolder> {
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
        holder.shopping_cart_quantity.setText(String.valueOf(_quantity));

        if (itemArray.get(position).getQuantity() <= 1) {
            holder.decrement_button.setEnabled(false);
        } else {
            holder.decrement_button.setEnabled(true);
        }
        holder.increment_button.setEnabled(true);

        holder.increment_button.setOnClickListener(v -> {
            holder.increment_button.setEnabled(false);
            try (DbHelper dbHelper = new DbHelper(context)) {
                dbHelper.increaseShoppingCart(itemArray.get(position).getItemId(), 1, 1);

                // Update the item quantity in the local list
                int currentQuantity = itemArray.get(position).getQuantity();
                itemArray.get(position).setQuantity(currentQuantity + 1);

                // Notify the adapter to update this specific item
                notifyItemChanged(position);
            }
        });

        holder.decrement_button.setOnClickListener(v -> {
            holder.decrement_button.setEnabled(false);
            try (DbHelper dbHelper = new DbHelper(context)) {
                dbHelper.decreaseShoppingCart(itemArray.get(position).getItemId(), 1, 1);

                // Update the item quantity in the local list
                int currentQuantity = itemArray.get(position).getQuantity();
                itemArray.get(position).setQuantity(currentQuantity - 1);

                // Notify the adapter to update this specific item
                notifyItemChanged(position);
            }
        });

        holder.delete_button.setOnClickListener(v -> new AlertDialog.Builder(context)
                .setTitle("Delete")
                .setMessage("Remove Item?")
                .setIcon(android.R.drawable.ic_delete)
                .setPositiveButton(android.R.string.yes, (dialog, whichButton) -> {
                    try (DbHelper dbHelper = new DbHelper(context)) {
                        dbHelper.deleteShoppingCart(itemArray.get(position).getShoppingCartId());
                        // Remove the item from the list
                        itemArray.remove(position);
                        // Notify the adapter about the removed item
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, itemArray.size());
                    }
                })
                .setNegativeButton(android.R.string.no, null).show());


//        holder.delete_button.setOnClickListener(v -> {
//            try (DbHelper dbHelper = new DbHelper(context)) {
//                dbHelper.deleteShoppingCart(itemArray.get(position).getShoppingCartId());
//                // Remove the item from the list
//                itemArray.remove(position);
//                // Notify the adapter about the removed item
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position, itemArray.size());
//            }
//        });

        holder.favorite_button.setOnClickListener(v -> {

            try (DbHelper dbHelper = new DbHelper(context)) {
                dbHelper.insertWishList(itemArray.get(position).getItemId(), 1);
                dbHelper.deleteShoppingCart(itemArray.get(position).getShoppingCartId());
                // Remove the item from the list
                itemArray.remove(position);
                // Notify the adapter about the removed item
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, itemArray.size());
            }
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
        Button increment_button, decrement_button, delete_button, favorite_button;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            product_name = itemView.findViewById(R.id.product_name);
            product_price = itemView.findViewById(R.id.product_price);
            shopping_cart_quantity = itemView.findViewById(R.id.shopping_cart_quantity);
            increment_button = itemView.findViewById(R.id.increment_button);
            decrement_button = itemView.findViewById(R.id.decrement_button);
            delete_button = itemView.findViewById(R.id.delete_button);
            favorite_button = itemView.findViewById(R.id.favorite_button);
        }
    }
}
