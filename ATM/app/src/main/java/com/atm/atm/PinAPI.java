package com.atm.atm;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;

public interface PinAPI {
    @PUT("pin/save")
    Call<Pin> save(@Body Pin pin);
}

