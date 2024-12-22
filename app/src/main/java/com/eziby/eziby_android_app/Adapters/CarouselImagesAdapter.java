package com.eziby.eziby_android_app.Adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.CarouselImage;
import com.eziby.eziby_android_app.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CarouselImagesAdapter extends RecyclerView.Adapter<CarouselImagesAdapter.ImageViewHolder> {
    public static final String TAG = "Image Path";
    private final Context context;
    private final List<String> imageList;
    private final String mainUri;

    public CarouselImagesAdapter(Context context, List<CarouselImage> itemArray) {
        List<String> imageList = new ArrayList<>();

        for (CarouselImage item : itemArray) {
            imageList.add(item.getCarouselImageName());
        }

        try (DbHelper setupNet = new DbHelper(context)) {
            this.mainUri = setupNet.getASetup().getMainSlideShowImagesUri();
        }

        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_carousal, parent, false);
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
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewCarousel);
        }
    }
}
