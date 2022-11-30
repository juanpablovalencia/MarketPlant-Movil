package com.example.marketplant_mobil.retrofit;

import com.example.marketplant_mobil.modelos.Blog;
import com.example.marketplant_mobil.modelos.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofit_api_service {

      @GET("products/")
    Call<List<Producto>>getProduct();

      @GET("blogs/")
    Call<List<Blog>> getBlog();





}
