package com.eziby.eziby_android_app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Adapters.WishListAdapter;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.WishListViewModel;
import com.eziby.eziby_android_app.R;

import java.util.List;

public class WishListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wish_list, container, false);

        List<WishListViewModel> wishListViewModels;

        try (DbHelper dbHelper = new DbHelper(view.getContext())) {
            wishListViewModels = dbHelper.getWishLists(1);
        }

        // Set up RecyclerView
        RecyclerView recyclerViewCategory = view.findViewById(R.id.recycler_view_wish_list);
        recyclerViewCategory.setLayoutManager(new GridLayoutManager(this.getContext(), 1)); // 3 columns
        recyclerViewCategory.setAdapter(new WishListAdapter(this.getContext(), wishListViewModels));

        //Visible / Invisible Empty Icon
        LinearLayout linear_layout_no_item_found;
        linear_layout_no_item_found = view.findViewById(R.id.linear_layout_no_item_found);
        linear_layout_no_item_found.setVisibility(wishListViewModels.size() > 0 ? View.INVISIBLE : View.VISIBLE);

        return view;
    }
}