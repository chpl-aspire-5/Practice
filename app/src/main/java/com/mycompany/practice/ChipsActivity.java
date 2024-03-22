package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mycompany.practice.databinding.ActivityChipsBinding;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;

public class ChipsActivity extends AppCompatActivity {

    ActivityChipsBinding binding;
    ImageView imgPrevious, imgNext, imgHome;
    Balloon balloon;

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

        // Balloon view created here
        balloon = new Balloon.Builder(getApplicationContext())
                .setArrowSize(10)
                .setArrowOrientation(ArrowOrientation.TOP)
                .setIsVisibleArrow(true)
                .setArrowPosition(0.3f)
                .setWidthRatio(0.6f)
                .setHeight(65)
                .setTextSize(15f)
                .setCornerRadius(4f)
                .setAlpha(0.9f)
                .setText("Hi! This is Chip View")
                .setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black))
                .setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary))
                .setBalloonAnimation(BalloonAnimation.FADE)
                .build();

        binding.chipThis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                balloon.showAlignBottom(binding.chipThis);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        balloon.dismiss();
                    }
                }, 2000);

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

                balloon.showAlignBottom(binding.chipIs);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        balloon.dismiss();
                    }
                }, 2000);

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

                balloon.showAlignBottom(binding.chipChip);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        balloon.dismiss();
                    }
                }, 2000);

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

                balloon.showAlignBottom(binding.chipView);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        balloon.dismiss();
                    }
                }, 2000);

                if (binding.chipView.isChecked()) {
                    Toast.makeText(ChipsActivity.this, "View selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ChipsActivity.this, "View deselected", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}