package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mycompany.practice.databinding.ActivityChipsBinding;

public class ChipsActivity extends AppCompatActivity {

    ActivityChipsBinding binding;
    ImageView imgPrevious, imgNext, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chips);
        init();
    }

    public void init() {

        imgPrevious = findViewById(R.id.imgPrevious);
        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChipsActivity.this, AlerterActivity.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChipsActivity.this, SpeechToTextActivity.class));
                finish();
            }
        });

        imgHome = findViewById(R.id.imgHome);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChipsActivity.this, FirstActivity.class));
                finish();
            }
        });

        binding.chipThis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.chipThis.isChecked()) {
                    Toast.makeText(ChipsActivity.this, "This selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChipsActivity.this, "This deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.chipIs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.chipIs.isChecked()) {
                    Toast.makeText(ChipsActivity.this, "Is selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChipsActivity.this, "Is deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.chipChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.chipChip.isChecked()) {
                    Toast.makeText(ChipsActivity.this, "Chip selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChipsActivity.this, "Chip deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.chipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.chipView.isChecked()) {
                    Toast.makeText(ChipsActivity.this, "View selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChipsActivity.this, "View deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}