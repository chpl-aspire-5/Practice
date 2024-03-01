package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

public class SwipeButtonActivity extends AppCompatActivity {

    SwipeButton swipeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_button);

        swipeButton = findViewById(R.id.swipe_btn);

        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                Toast.makeText(SwipeButtonActivity.this, "Active", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SwipeButtonActivity.this, FirstActivity.class));
                finish();
            }
        });
    }
}