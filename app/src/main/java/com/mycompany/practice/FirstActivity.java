package com.mycompany.practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class FirstActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView imgMenu, imgCancel;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        imgMenu = findViewById(R.id.imgMenu);
        navigationView = findViewById(R.id.navigationView);
        imgCancel = findViewById(R.id.imgCancel);

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setVisibility(View.VISIBLE);
            }
        });

        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationView.setVisibility(View.GONE);
            }
        });

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.spinkit) {
            startActivity(new Intent(this, SpinkitActivity.class));
            finish();
        } else if (id == R.id.recyclerView) {
            startActivity(new Intent(this, RecyclerViewActivity.class));
            finish();
        } else if (id == R.id.stateProgressBar) {
            startActivity(new Intent(this, StateProgressBarActivity.class));
            finish();
        } else if (id == R.id.verticalStateProgressBar) {
            startActivity(new Intent(this, VerticalStateProgressBarActivity.class));
            finish();
        } else if (id == R.id.shimmer) {
            startActivity(new Intent(this, ShimmerActivity.class));
            finish();
        } else if (id == R.id.currency) {
            startActivity(new Intent(this, CurrencyConversion.class));
            finish();
        } else if (id == R.id.random) {
            startActivity(new Intent(this, RandomNoGeneratorActivity.class));
            finish();
        } else if (id == R.id.dragAndDrop) {
            startActivity(new Intent(this, DragAndDropActivity.class));
            finish();
        }else if (id == R.id.pip) {
            startActivity(new Intent(this, PipActivity.class));
            finish();
        }

        return true;
    }
}