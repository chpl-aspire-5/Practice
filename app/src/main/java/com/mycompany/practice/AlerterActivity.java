package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mycompany.practice.databinding.ActivityAlerterBinding;
import com.tapadoo.alerter.Alerter;

public class AlerterActivity extends AppCompatActivity {
    ImageView imgPrevious, imgNext, imgHome;
    ActivityAlerterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_alerter);
        init();
    }

    public void init() {
        imgPrevious = findViewById(R.id.imgPrevious);
        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlerterActivity.this, PipActivity.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(AlerterActivity.this, AlerterActivity.class));
//                finish();
            }
        });

        imgHome = findViewById(R.id.imgHome);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlerterActivity.this, FirstActivity.class));
                finish();
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerter.create(AlerterActivity.this).setTitle("Alerter Message").setText("Alert Text")
                        .setIcon(R.drawable.home).setBackgroundColorRes(R.color.red).setDuration(3000)
                        .setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // do something when
                                // Alerter message was clicked
                            }
                        })

                        .setOnShowListener(new OnShowAlertListener() {
                            @Override
                            public void onShow() {
                                // do something when
                                // Alerter message shows
                            }
                        })
                        .setOnHideListener(new OnHideAlertListener() {
                            @Override
                            public void onHide() {
                                // do something when
                                // Alerter message hides
                            }
                        })
                        .show();
            }
        });
    }
}