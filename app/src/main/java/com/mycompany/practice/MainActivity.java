package com.mycompany.practice;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navView;
    DrawerLayout drawerLyt;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i =new Intent(getApplicationContext(),IntroSlider.class);
        startActivity(i);

        drawerLyt = findViewById(R.id.drawerLyt);
//        navView = findViewById(R.id.navView);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLyt,R.string.open,R.string.close);

        drawerLyt.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

    }
}