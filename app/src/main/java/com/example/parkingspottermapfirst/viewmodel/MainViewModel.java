package com.example.parkingspottermapfirst.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.parkingspottermapfirst.model.SpotData;
import com.example.parkingspottermapfirst.model.SpotsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<SpotData>> spots = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();

    private SpotsApi api = null;

    public MainViewModel() {

    }

    public LiveData<List<SpotData>> getSpots() {
        return spots;
    }

    public LiveData<String> getError() {
        return error;
    }

    public void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ridecellparking.herokuapp.com/api/v1/parkinglocations/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SpotsApi.class);
    }

    public void searchForSpots(double lat, double lng) {
        api.getNearbySpots(lat, lng).enqueue(new Callback<List<SpotData>>() {
            @Override
            public void onResponse(
                    Call<List<SpotData>> call,
                    Response<List<SpotData>> response) {
                if (response.body() != null) {
                    spots.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<SpotData>> call, Throwable t) {
                error.postValue(t.getMessage());
            }
        });
    }

    public void reserveSpot(int id, int minutes) {
        api.reserveSpot(id, minutes).enqueue(new Callback<SpotData>() {
            @Override
            public void onResponse(Call<SpotData> call, Response<SpotData> response) {
                error.postValue("Spot reserved: " + response.body().id);
            }

            @Override
            public void onFailure(Call<SpotData> call, Throwable t) {
                error.postValue("Spot not reserved: " + t.getMessage());
            }
        });
    }
}
