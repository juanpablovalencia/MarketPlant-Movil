package com.example.marketplant_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marketplant_mobil.modelos.Blog;
import com.example.marketplant_mobil.retrofit.Apis;
import com.example.marketplant_mobil.retrofit.BlogService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogActivity extends AppCompatActivity {

    BlogService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog2);


        TextView ids = (TextView) findViewById(R.id.Id);
        EditText txtId = (EditText) findViewById(R.id.txtId);
        TextView titulos = (TextView) findViewById(R.id.titulos);
        final EditText txtTitulos = (EditText) findViewById(R.id.txtTitulos);
        TextView descripciones = (TextView) findViewById(R.id.descripciones);
        final EditText txtDescripciones = (EditText) findViewById(R.id.txtDescripciones);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        Button btnVolver = (Button) findViewById(R.id.btnVolver);
        Button btnEliminar = (Button) findViewById(R.id.btnEliminar);

        Bundle bundle = getIntent().getExtras();
        final String id = bundle.getString("ID");
        String tit = bundle.getString("TITULO");
        String des = bundle.getString("DESCRIPCION"); txtId.setText(id);
        txtTitulos.setText(tit);
        txtDescripciones.setText(des);
        if (id.trim().length() == 0 || id.equals("")) {
            ids.setVisibility(View.INVISIBLE);
            txtId.setVisibility(View.INVISIBLE);
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Blog p = new Blog();
                p.setTitulo(txtTitulos.getText().toString());
                p.setDescripcion(txtDescripciones.getText().toString());
                if (id.equals("")) {
                    addBlog(p);
                    Intent intent = new Intent(BlogActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else {
                    updateBlog(p, Integer.valueOf(id));
                    Intent intent = new Intent(BlogActivity.this, MainActivity2.class);
                    startActivity(intent);
                }

            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteBlog(Integer.valueOf(id));
                Intent intent = new Intent(BlogActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BlogActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    public void addBlog(Blog p) {
        service = Apis.getBlogService();
        Call<Blog> call = service.addBlogs(p);
        call.enqueue(new Callback<Blog>() {
            @Override
            public void onResponse(Call<Blog> call, Response<Blog> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BlogActivity.this, "Se agrego con éxito", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Blog> call, Throwable t) {

                Log.e("Error:", t.getMessage());
            }
        });
    }

    public void updateBlog(Blog p, int id) {
        service = Apis.getBlogService();
        Call<Blog> call = service.updateBlog(p, id);
        call.enqueue(new Callback<Blog>() {
            @Override
            public void onResponse(Call<Blog> call, Response<Blog> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BlogActivity.this, "Se actualizo con éxito", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Blog> call, Throwable t) {

                Log.e("Error:", t.getMessage());
            }
        });
        Intent intent = new Intent(BlogActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    public void deleteBlog(int id) {
        service = Apis.getBlogService();
        Call<Blog> call = service.deleteBlog(id);
        call.enqueue(new Callback<Blog>() {
            @Override
            public void onResponse(Call<Blog> call, Response<Blog> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(BlogActivity.this, "Se Elimino el registro", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Blog> call, Throwable t) {
                Log.e("Error:", t.getMessage());
            }
        });
        Intent intent = new Intent(BlogActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}