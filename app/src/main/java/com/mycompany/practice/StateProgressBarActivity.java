package com.mycompany.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.kofigyan.stateprogressbar.StateProgressBar;

public class StateProgressBarActivity extends AppCompatActivity {

    String[] descriptionData = {"Step One", "Step Two", "Step Three", "Step Four", "Step Five"};
    Button next, previous;
    ImageView imgPrevious, imgNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_progress_bar);

        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.your_state_progress_bar_id);
        stateProgressBar.setStateDescriptionData(descriptionData);

        next = findViewById(R.id.next);
        next.setEnabled(true);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (stateProgressBar.getCurrentStateNumber()) {
                    case 1:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        previous.setEnabled(true);
                        break;
                    case 2:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                        previous.setEnabled(true);
                        break;
                    case 3:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
                        previous.setEnabled(true);
                        break;
                    case 4:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FIVE);
                        previous.setEnabled(true);
                        break;
                    case 5:
                        stateProgressBar.setAllStatesCompleted(true);
                        next.setEnabled(false);
                        previous.setEnabled(false);
                        next.setText("Completed");
                        previous.setVisibility(View.GONE);
                        break;
                }
            }
        });

        previous = findViewById(R.id.previous);
        previous.setEnabled(false);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (stateProgressBar.getCurrentStateNumber()) {
                    case 1:
                        break;
                    case 2:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                        previous.setEnabled(false);
                        break;
                    case 3:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        break;
                    case 4:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                        break;
                    case 5:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.FOUR);
                        break;
                }
            }
        });

        imgPrevious = findViewById(R.id.imgPrevious);

        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StateProgressBarActivity.this, RecyclerViewActivity.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StateProgressBarActivity.this, VerticalStateProgressBarActivity.class));
                finish();
            }
        });
    }
}