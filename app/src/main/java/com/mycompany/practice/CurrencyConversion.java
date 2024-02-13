package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.mycompany.practice.databinding.ActivityCurrencyConversionBinding;

public class CurrencyConversion extends AppCompatActivity {

    ActivityCurrencyConversionBinding binding;
    String selectedCurrencyFrom, selectedCurrencyTo;
    ImageView imgPrevious, imgNext, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_currency_conversion);
        init();
    }

    public void init() {

        imgPrevious = findViewById(R.id.imgPrevious);

        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CurrencyConversion.this, ShimmerActivity.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CurrencyConversion.this, RandomNoGeneratorActivity.class));
                finish();
            }
        });

        imgHome = findViewById(R.id.imgHome);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CurrencyConversion.this, FirstActivity.class));
                finish();
            }
        });

        binding.currencySpinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCurrencyFrom = (String) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.currencySpinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCurrencyTo = (String) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}