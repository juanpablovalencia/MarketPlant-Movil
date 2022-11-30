package com.example.marketplant_mobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenApp extends AppCompatActivity {

    ImageView logo;
    TextView txtbienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_app);

        logo = findViewById(R.id.market_logo);
        txtbienvenido = findViewById(R.id.bienvenido);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        logo.setAnimation(animation);
        Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);
        txtbienvenido.setAnimation(animacion2);



        Thread splashScreenStarter = new Thread() {
            public void run() {
                try {
                    int delay = 0;

                    while (delay < 2000) {
                        sleep(150);
                        delay = delay + 100;
                    }

                    startActivity(new

                            Intent(SplashScreenApp.this, MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        splashScreenStarter.start();
    }
    }
