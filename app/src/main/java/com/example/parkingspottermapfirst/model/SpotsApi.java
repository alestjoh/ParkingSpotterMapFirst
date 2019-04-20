package com.example.parkingspottermapfirst.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SpotsApi {
    @GET("search?")
    Call<List<SpotData>> getNearbySpots(
            @Query("lat") double lat,
            @Query("lng") double lng);

    @POST("{id}/reserve/")
    Call<SpotData> reserveSpot(@Path("id") int id,
                               @Query("minutes") int minutes);
}
