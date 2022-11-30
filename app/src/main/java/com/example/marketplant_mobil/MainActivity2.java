package com.example.marketplant_mobil;

import android.content.Intent;
import android.os.Bundle;

import com.example.marketplant_mobil.adaptadores.BlogAdapter;
import com.example.marketplant_mobil.modelos.Blog;
import com.example.marketplant_mobil.retrofit.Apis;
import com.example.marketplant_mobil.retrofit.BlogService;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.marketplant_mobil.databinding.ActivityMain2Binding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    BlogService blogService;
    List<Blog> listBlog = new ArrayList<>();
    ListView listView;

    ImageButton imgVolver;

    private AppBarConfiguration appBarConfiguration;
private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMain2Binding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

     imgVolver = findViewById(R.id.btn_volver);


        listView = (ListView) findViewById(R.id.listView);
        listBlogs();




        imgVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vl = new Intent(MainActivity2.this,Perfil_activity.class);
                startActivity(vl);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity2.this, BlogActivity.class);
                intent.putExtra("ID","");
                intent.putExtra("TITULO","");
                intent.putExtra("DESCRIPCION","");
                startActivity(intent);

            }
        });
    }

    public void listBlogs() {
        blogService = Apis.getBlogService();
        Call<List<Blog>> call = blogService.getBlogs();
        call.enqueue(new Callback<List<Blog>>() {
            @Override
            public void onResponse(Call<List<Blog>> call, Response<List<Blog>> response) {
                if (response.isSuccessful()) {
                    listBlog = response.body();
                    listView.setAdapter(new BlogAdapter(MainActivity2.this, R.layout.content_main2, listBlog));
                }
            }

            @Override
            public void onFailure(Call<List<Blog>> call, Throwable t) {
                Log.e("Error:", t.getMessage());
            }
        });
    }



}
