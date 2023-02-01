package com.atm.atm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholderAPI {
    @GET("/details")
    Call<List<Details>> getData();
}
