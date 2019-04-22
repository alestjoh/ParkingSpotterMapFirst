package com.example.parkingspottermapfirst.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkingspottermapfirst.R;
import com.example.parkingspottermapfirst.model.SpotData;
import com.example.parkingspottermapfirst.viewmodel.MainViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpotDetailsActivity extends AppCompatActivity {

    SpotData spotData = null;
    TextView tvName;

    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_details);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        spotData = getIntent().getParcelableExtra(MapsActivity.SPOT_DATA_EXTRA);

        tvName = findViewById(R.id.tvSpotNameDetails);
        tvName.setText(spotData.name);

        findViewById(R.id.btnPayToReserve).setOnClickListener(view -> {
            viewModel.reserveSpot(spotData.id, 60, new Callback<SpotData>() {
                @Override
                public void onResponse(Call<SpotData> call, Response<SpotData> response) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .add(R.id.fragmentPlaceholder, ConfirmationFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                }

                @Override
                public void onFailure(Call<SpotData> call, Throwable t) {
                    Toast.makeText(
                            SpotDetailsActivity.this,
                            "Spot was NOT successfully reserved!",
                            Toast.LENGTH_LONG).show();
                }
            });
        });
    }
}
