package com.eziby.eziby_android_app.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eziby.eziby_android_app.Adapters.ItemAdapter;
import com.eziby.eziby_android_app.Database.DbHelper;
import com.eziby.eziby_android_app.Models.Item;
import com.eziby.eziby_android_app.R;

import java.util.List;

public class SearchFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        List<Item> recentlyViewItemList;

        try (DbHelper dbHelper = new DbHelper(view.getContext())) {
            recentlyViewItemList = dbHelper.getItems(0,0,0);
        }

        // Set up RecyclerView - New Arrivals
        RecyclerView recyclerViewItem = view.findViewById(R.id.recycler_view_recently_viewed);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewItem.setLayoutManager(layoutManager);
        recyclerViewItem.setAdapter(new ItemAdapter(this.getContext(), recentlyViewItemList));

        return view;
    }
}