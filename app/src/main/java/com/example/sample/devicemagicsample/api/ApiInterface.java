package com.example.sample.devicemagicsample.api;


import com.example.sample.devicemagicsample.api.response.DownloadItemsResponse;
import com.example.sample.devicemagicsample.constants.Constants;
import com.example.sample.devicemagicsample.model.Phrase;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET(Constants.BASE_URL)
    Call<DownloadItemsResponse> getDownloadItems();

    @GET(Constants.DOWNLOAD_URL)
    Call<Phrase> getPhrases(@Path("key") String key);
}
