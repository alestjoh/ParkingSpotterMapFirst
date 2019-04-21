package com.example.parkingspottermapfirst.view;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.parkingspottermapfirst.model.SpotData;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.Map;

public class SpotMarkerWindowAdapter implements GoogleMap.InfoWindowAdapter {

    Map<Marker, SpotData> markerData;

    public SpotMarkerWindowAdapter(@NonNull Map<Marker, SpotData> markerData) {
        this.markerData = markerData;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;    //Will use the default window settings if null is returned
    }

    @Override
    public View getInfoContents(Marker marker) {
        SpotData spotData = markerData.get(marker);
        if (spotData == null) {
            return null;
        }



        return null;
    }
}
