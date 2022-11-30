package com.example.marketplant_mobil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.marketplant_mobil.databinding.ActivityMapaBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa_activity extends DrawerBase implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    ActivityMapaBinding activityMapaBinding;

    EditText txt_longitud,txt_latitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMapaBinding=ActivityMapaBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Mapa");
        setContentView(activityMapaBinding.getRoot());

        txt_latitud=findViewById(R.id.latitud);
        txt_longitud=findViewById(R.id.logitud);

        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap=googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        LatLng popayan=new LatLng(2.4574702,-76.6349538);
        mMap.addMarker(new MarkerOptions().position(popayan).title("Popayan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(popayan));

    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txt_latitud.setText(""+latLng.latitude);
        txt_longitud.setText(""+latLng.longitude);

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txt_latitud.setText(""+latLng.latitude);
        txt_longitud.setText(""+latLng.longitude);

    }
}