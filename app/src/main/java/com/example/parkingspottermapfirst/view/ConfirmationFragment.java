package com.example.parkingspottermapfirst.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parkingspottermapfirst.R;


public class ConfirmationFragment extends Fragment {
    public ConfirmationFragment() {
        // Required empty public constructor
    }

    public static ConfirmationFragment newInstance(String param1, String param2) {
        ConfirmationFragment fragment = new ConfirmationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_confirmation, container, false);
    }
}
