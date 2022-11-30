package com.example.marketplant_mobil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {

   GoogleSignInOptions gso;
   GoogleSignInClient gsc;

   Button btnlogin;
   private EditText edt1;
   private EditText edt2;

    private FirebaseAuth mAuth;

    Button btnRegistrarse;
    Button btninicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        edt1=findViewById(R.id.edtUsuario);
        edt2=findViewById(R.id.edtPassword);

        btnRegistrarse = findViewById(R.id.btnRegistro);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
        btninicio = findViewById(R.id.btnLogin);
        btninicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            Intent z = new Intent(MainActivity.this, dashboard_activity.class);

            startActivity(z);
           }
        });


    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    private void iniciarsesion(View view) {

       mAuth.createUserWithEmailAndPassword(edt1.getText().toString(),edt2.getText().toString())
               .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           FirebaseUser user = mAuth.getCurrentUser();
                           Toast.makeText(getApplicationContext(),"conexion ",Toast.LENGTH_SHORT).show();

                       }else {
                           Toast.makeText(getApplicationContext(),"Ingreso",Toast.LENGTH_SHORT).show();
                           Intent s= new Intent(getApplicationContext(),dashboard_activity.class);
                           startActivity(s);
                       }
                   }
               });



}}



