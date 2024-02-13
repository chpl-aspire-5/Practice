package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mycompany.practice.databinding.ActivityRandomNoGeneratorBinding;

import java.util.Random;

public class RandomNoGeneratorActivity extends AppCompatActivity {

    ActivityRandomNoGeneratorBinding binding;
    ImageView imgPrevious, imgNext, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_random_no_generator);
        init();
    }

    public void init() {
        imgPrevious = findViewById(R.id.imgPrevious);

        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RandomNoGeneratorActivity.this, CurrencyConversion.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(RandomNoGeneratorActivity.this, RandomNoGeneratorActivity.class));
//                finish();
            }
        });

        imgHome = findViewById(R.id.imgHome);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RandomNoGeneratorActivity.this, FirstActivity.class));
                finish();
            }
        });

        binding.btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                String resRandom = String.valueOf(rand.nextInt((9999 - 100) + 1) + 10);
                if (resRandom.length() == 4) {
                    binding.tvGeneratedNo.setText("" + resRandom);
                } else {
                    Toast.makeText(RandomNoGeneratorActivity.this, "No. length was " + resRandom.length() + "\n Please Retry", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}