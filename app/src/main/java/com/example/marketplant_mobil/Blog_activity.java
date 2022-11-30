package com.example.marketplant_mobil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.marketplant_mobil.adaptadores.Adapter_Blog;
import com.example.marketplant_mobil.adaptadores.Adapter_Producto;
import com.example.marketplant_mobil.databinding.ActivityBlogBinding;
import com.example.marketplant_mobil.modelos.Blog;
import com.example.marketplant_mobil.modelos.Producto;
import com.example.marketplant_mobil.retrofit.ApiClient;
import com.example.marketplant_mobil.retrofit.Retrofit_api_service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Blog_activity extends DrawerBase{
    ActivityBlogBinding activityBlogBinding;

    private List<Blog> blogList;
    private RecyclerView rv_Blog;
    private Adapter_Blog adapter_blog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBlogBinding=ActivityBlogBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Blog");
        setContentView(activityBlogBinding.getRoot());

        rv_Blog=findViewById(R.id.rv_b);
        rv_Blog.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));

        mostrarblog();



    }
    public void mostrarblog(){
        Call<List<Blog>> call = ApiClient.getRetrofit().create(Retrofit_api_service.class).getBlog();
        call.enqueue(new Callback<List<Blog>>() {
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                if (response.isSuccessful()){
                    blogList=response.body();
                    adapter_blog=new Adapter_Blog(blogList,getApplicationContext());
                    rv_Blog.setAdapter(adapter_blog);
                }
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {

                Toast.makeText(Blog_activity.this,"Error de conexion",Toast.LENGTH_SHORT).show();

            }
        });
    }
}