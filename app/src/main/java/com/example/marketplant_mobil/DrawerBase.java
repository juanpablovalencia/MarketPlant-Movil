 package com.example.marketplant_mobil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

 public class DrawerBase extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
     TextView tv1;


     @Override
     public void setContentView(View view) {

         drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base,null);
         FrameLayout container = drawerLayout.findViewById(R.id.activity_container);
         container.addView(view);

         super.setContentView(drawerLayout);



         Toolbar toolbar = drawerLayout.findViewById(R.id.tolbar);
         setSupportActionBar(toolbar);
         NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
         navigationView.setNavigationItemSelectedListener(this);

         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.menu_drawer_open, R.string.menu_drawer_close);
         drawerLayout.addDrawerListener(toggle);
         toggle.syncState();

     }

     @Override
     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
         drawerLayout.closeDrawer(GravityCompat.START);
         switch (item.getItemId()){
             case R.id.nav_carrito:
                 startActivity(new Intent(this, Carro_activity.class));
                 overridePendingTransition(0,0);
                 break;
             case R.id.nav_blog:
                 startActivity(new Intent(this, Blog_activity.class));
                 overridePendingTransition(0,0);
                 break;
             case R.id.nav_mapa:
                 startActivity(new Intent(this, Mapa_activity.class));
                 overridePendingTransition(0,0);
                 break;
             case R.id.nav_perfil:
                 startActivity(new Intent(this, Perfil_activity.class));
                 overridePendingTransition(0,0);
                 break;
             case R.id.nav_home:
                 startActivity(new Intent(this, dashboard_activity.class));
                 overridePendingTransition(0,0);
                 break;
         }
         return false;
     }

     protected void allocateActivityTitle(String titleString) {
         if (getSupportActionBar()!=null){
             getSupportActionBar().setTitle(titleString);
         }
     }
 }