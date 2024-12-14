package com.eziby.eziby_android_app.Fragments;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.eziby.eziby_android_app.R;


public class AboutUsFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_about_us,
                container, false);

        TextView textViewNameValue = myView.findViewById(R.id.textViewNameValue);
        textViewNameValue.setMovementMethod(new ScrollingMovementMethod());

        return myView;
    }
}
