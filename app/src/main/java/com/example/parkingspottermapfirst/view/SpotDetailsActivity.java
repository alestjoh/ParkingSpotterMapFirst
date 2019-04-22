package com.example.parkingspottermapfirst.view;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.parkingspottermapfirst.R;
import com.example.parkingspottermapfirst.model.SpotData;

public class SpotDetailsActivity extends AppCompatActivity {

    SpotData spotData = null;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_details);

        spotData = getIntent().getParcelableExtra(MapsActivity.SPOT_DATA_EXTRA);

        tvName = findViewById(R.id.tvSpotNameDetails);
        tvName.setText(spotData.name);

        findViewById(R.id.btnPayToReserve).setOnClickListener(view -> {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentPlaceholder, ConfirmationFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        });
    }
}
