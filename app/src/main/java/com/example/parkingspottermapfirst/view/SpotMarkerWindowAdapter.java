package com.example.parkingspottermapfirst.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkingspottermapfirst.R;
import com.example.parkingspottermapfirst.model.SpotData;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.Map;

public class SpotMarkerWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final View contents;
    Map<Marker, SpotData> markerData;

    public SpotMarkerWindowAdapter(@NonNull Map<Marker, SpotData> markerData, Activity activity) {
        this.markerData = markerData;
        contents = activity.getLayoutInflater().inflate(R.layout.marker_info_contents, null);
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;    //Will use the default window settings if null is returned
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getInfoContents(Marker marker) {
        SpotData spotData = markerData.get(marker);
        if (spotData == null) {
            return null;
        }

        contents.setOnClickListener(view -> {
            Toast.makeText(contents.getContext().getApplicationContext(),
                    "You clicked: " + spotData.name, Toast.LENGTH_LONG).show();
        });

        ((TextView)contents.findViewById(R.id.tvName)).setText(spotData.name);
        ((TextView)contents.findViewById(R.id.tvAddress)).setText(spotData.name);
        ((TextView)contents.findViewById(R.id.tvOpenSpots)).setText((spotData.id) % 30 + 1 + "");
        ((TextView)contents.findViewById(R.id.tvCost)).setText(spotData.cost_per_minute);
        ((TextView)contents.findViewById(R.id.tvDist)).setText(spotData.lat);

        return contents;
    }
}
