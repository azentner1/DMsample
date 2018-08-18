package com.example.sample.devicemagicsample.model;

import android.util.Log;

import com.example.sample.devicemagicsample.App;
import com.example.sample.devicemagicsample.api.ApiInterface;
import com.example.sample.devicemagicsample.api.response.DownloadItemsResponse;
import com.example.sample.devicemagicsample.presenter.MainPresenter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchDownloadItems {

    public void requestDownloadItems(final MainPresenter presenter) {
        ApiInterface apiInterface = App.getClient().create(ApiInterface.class);
        final Call<DownloadItemsResponse> routeCall = apiInterface.getDownloadItems();
        routeCall.enqueue(new Callback<DownloadItemsResponse>() {
            @Override
            public void onResponse(Call<DownloadItemsResponse> call, Response<DownloadItemsResponse> response) {
                if (response.body() != null && response.body() != null) {
                    presenter.setDownloadItems(new ArrayList<>(response.body().getDownloadItems()));
                }
            }

            @Override
            public void onFailure(Call<DownloadItemsResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
