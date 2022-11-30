package com.example.marketplant_mobil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.marketplant_mobil.adaptadores.Adapter_Producto;
import com.example.marketplant_mobil.databinding.ActivityDashboardBinding;
import com.example.marketplant_mobil.modelos.Producto;
import com.example.marketplant_mobil.retrofit.ApiClient;
import com.example.marketplant_mobil.retrofit.Retrofit_api_service;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class dashboard_activity extends DrawerBase {

    ActivityDashboardBinding activityDashboardBinding;
    private ImageSlider imageSlider;

    FloatingActionsMenu floatingActionsMenu;
    FloatingActionButton nuevoblog, nuevoproducto;

    private List<Producto> productos;
    private RecyclerView rv_producto;
    private Adapter_Producto adapter_producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        allocateActivityTitle("dashboard");
        setContentView(activityDashboardBinding.getRoot());

        rv_producto = findViewById(R.id.rv_p);
        rv_producto.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));


        imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Floriculture.jpg/1200px-Floriculture.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://images.hola.com/imagenes/estar-bien/20200914175150/plantas-medicinales-recomendadas-farmaceuticas/0-864-535/plantasmedicinales-t.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.tuherramienta.net/wp-content/uploads/2019/03/Herramientas-jardiner%C3%ADa1_opt.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://as2.ftcdn.net/v2/jpg/02/03/95/25/1000_F_203952565_G8ILwcW8Nl5kxxZQ2Nh57sl0ZO5H9EfF.jpg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);


        mostrarproductos();

    }

    public void mostrarproductos() {
        Call<List<Producto>> call = ApiClient.getRetrofit().create(Retrofit_api_service.class).getProduct();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (response.isSuccessful()) {
                    productos = response.body();
                    adapter_producto = new Adapter_Producto(productos, getApplicationContext());
                    rv_producto.setAdapter(adapter_producto);
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Toast.makeText(dashboard_activity.this, "Error de conexion", Toast.LENGTH_SHORT).show();

            }
        });
    }


}