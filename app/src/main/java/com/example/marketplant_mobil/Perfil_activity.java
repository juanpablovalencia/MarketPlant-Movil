package com.example.marketplant_mobil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marketplant_mobil.databinding.ActivityPerfilBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Perfil_activity extends DrawerBase {

    ActivityPerfilBinding activityPerfilBinding;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    TextView name,email;
    Button signOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPerfilBinding=ActivityPerfilBinding.inflate(getLayoutInflater());
        allocateActivityTitle("Perfil");

        setContentView(activityPerfilBinding.getRoot());


    }

    public void crearblog(View view){
        Intent bl = new Intent(Perfil_activity.this,MainActivity2.class);
        startActivity(bl);
    }


}