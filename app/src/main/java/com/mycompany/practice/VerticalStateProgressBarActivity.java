package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.transferwise.sequencelayout.SequenceLayout;
import com.transferwise.sequencelayout.SequenceStep;

public class VerticalStateProgressBarActivity extends AppCompatActivity {

    ImageView imgPrevious, imgNext;
    SequenceStep step1, step2, step3, step4, step5;
    SequenceLayout lytSequence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_state_progress_bar);

        imgPrevious = findViewById(R.id.imgPrevious);

        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VerticalStateProgressBarActivity.this, StateProgressBarActivity.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);
        imgNext.setVisibility(View.GONE);

        lytSequence = findViewById(R.id.lytSequence);
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step3 = findViewById(R.id.step3);
        step4 = findViewById(R.id.step4);
        step5 = findViewById(R.id.step5);

        step3.setActive(true);

        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step1.setActive(true);
            }
        });

        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step2.setActive(true);
            }
        });

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step3.setActive(true);
            }
        });

        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step4.setActive(true);
            }
        });

        step5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step5.setActive(true);
            }
        });


    }
}