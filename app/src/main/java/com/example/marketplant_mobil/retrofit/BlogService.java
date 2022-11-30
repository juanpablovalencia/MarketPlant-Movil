package com.example.marketplant_mobil.retrofit;

import com.example.marketplant_mobil.modelos.Blog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BlogService {
    @GET("blogs/")
    Call<List<Blog>> getBlogs();

    @POST("blogs/")
    Call<Blog>addBlogs(@Body Blog blog);

    @PUT("blogs/{id}")
    Call<Blog>updateBlog(@Body Blog blog,@Path("id") int id);

    @DELETE("blogs/{id}")
    Call<Blog>deleteBlog(@Path("id")int id);
}
