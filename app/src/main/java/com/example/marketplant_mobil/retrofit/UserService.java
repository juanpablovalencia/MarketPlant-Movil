package com.example.marketplant_mobil.retrofit;

import com.example.marketplant_mobil.RegisterResponse;
import com.example.marketplant_mobil.modelos.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("users/")
    Call<RegisterResponse> registerUsers(@Body RegisterRequest registerRequest);




}
