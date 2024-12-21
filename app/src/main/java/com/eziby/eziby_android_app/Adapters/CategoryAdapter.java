package com.eziby.eziby_android_app.Adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.eziby.eziby_android_app.R;
import com.squareup.picasso.Picasso;


import java.util.List;
import java.util.Optional;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ImageViewHolder> {

    private final Context context;
    private final List<String> imageList;
    private final List<String> categoryNames;

    public CategoryAdapter(Context context, List<String> imageList, List<String> categoryNames) {
        this.context = context;
        this.imageList = imageList;
        this.categoryNames = categoryNames;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_category, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Picasso.get()
                .load(imageList.get(position)) // Image URL
                .placeholder(R.drawable.loading_image_ligh_grey_100) // Placeholder image while loading
//                .error(R.drawable.error_image_30) // Error image if the URL fails to load
                .into(holder.imageView); // Target ImageView

        holder.textView.setText(Optional.ofNullable(categoryNames.get(position)).orElse(""));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.category_name_text_view);
        }
    }
}
