package com.example.app.network;

import com.example.app.model.ResponseData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetJournalData {
    @GET("http://api.plos.org/search?")
    Call<ResponseData> getJournalData(@Query("q") String title);
}
