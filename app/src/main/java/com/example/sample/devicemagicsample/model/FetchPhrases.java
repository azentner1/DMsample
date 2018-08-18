package com.example.sample.devicemagicsample.model;

import com.example.sample.devicemagicsample.App;
import com.example.sample.devicemagicsample.api.ApiInterface;
import com.example.sample.devicemagicsample.presenter.MainPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchPhrases {

    public void requestPhrase(final MainPresenter presenter, String item) {
        ApiInterface apiInterface = App.getClient().create(ApiInterface.class);
        final Call<Phrase> routeCall = apiInterface.getPhrases(item);
        routeCall.enqueue(new Callback<Phrase>() {
            @Override
            public void onResponse(Call<Phrase> call, Response<Phrase> response) {
                if (response.body() != null && response.body() != null) {
                    presenter.setPhrase(response.body());
                }
            }

            @Override
            public void onFailure(Call<Phrase> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
