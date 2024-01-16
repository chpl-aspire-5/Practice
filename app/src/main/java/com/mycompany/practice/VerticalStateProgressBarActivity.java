package com.mycompany.practice;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.transferwise.sequencelayout.SequenceLayout;

public class VerticalStateProgressBarActivity extends AppCompatActivity {

    ImageView imgPrevious;
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

    }
}