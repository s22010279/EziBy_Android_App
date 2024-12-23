package com.eziby.eziby_android_app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Adapters.ShoppingCartAdapter;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.ShoppingCartViewModel;
import com.eziby.eziby_android_app.R;

import java.util.List;

public class ShoppingCartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);

        List<ShoppingCartViewModel> shoppingCartViewModelList;

        try (DbHelper dbHelper = new DbHelper(view.getContext())) {
            shoppingCartViewModelList = dbHelper.getShoppingCarts(1);
        }

        // Set up RecyclerView
        RecyclerView recyclerViewCategory = view.findViewById(R.id.recycler_view_shopping_cart);
        recyclerViewCategory.setLayoutManager(new GridLayoutManager(this.getContext(), 2)); // 3 columns
        recyclerViewCategory.setAdapter(new ShoppingCartAdapter(this.getContext(), shoppingCartViewModelList));

        //Visible / Invisible Empty Icon
        LinearLayout linear_layout_no_item_found;
        linear_layout_no_item_found = view.findViewById(R.id.linear_layout_no_item_found);
        linear_layout_no_item_found.setVisibility(shoppingCartViewModelList.size() > 0 ? View.INVISIBLE : View.VISIBLE);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}