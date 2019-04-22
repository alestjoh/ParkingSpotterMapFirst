package com.example.parkingspottermapfirst.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parkingspottermapfirst.R;


public class ConfirmationFragment extends Fragment {
    public ConfirmationFragment() {
        // Required empty public constructor
    }

    public static ConfirmationFragment newInstance() {
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
        View view = inflater.inflate(R.layout.fragment_confirmation, container, false);

        view.findViewById(R.id.btnCloseFragment).setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().remove(ConfirmationFragment.this).commit();
        });

        return view;
    }
}
