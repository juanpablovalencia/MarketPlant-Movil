package com.example.marketplant_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.marketplant_mobil.databinding.ActivityCarroBinding;

public class Carro_activity extends DrawerBase {

    ActivityCarroBinding activityCarroBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCarroBinding=ActivityCarroBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Carro");
        setContentView(activityCarroBinding.getRoot());
    }
}