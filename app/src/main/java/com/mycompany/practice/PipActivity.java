package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ActionBar;
import android.app.PictureInPictureParams;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import com.mycompany.practice.databinding.ActivityPipBinding;

public class PipActivity extends AppCompatActivity {

    ActivityPipBinding binding;
    ActionBar actionBar;
    ImageView imgPrevious, imgNext, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pip);
        init();
    }

    public void init() {

        imgPrevious = findViewById(R.id.imgPrevious);
        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PipActivity.this, DragAndDropActivity.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PipActivity.this, AlerterActivity.class));
                finish();
            }
        });

        imgHome = findViewById(R.id.imgHome);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PipActivity.this, FirstActivity.class));
                finish();
            }
        });


        actionBar = getActionBar();

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Display d = getWindowManager()
                        .getDefaultDisplay();
                Point p = new Point();
                d.getSize(p);
                int width = p.x;
                int height = p.y;

                Rational ratio = new Rational(width, height);
                PictureInPictureParams.Builder pip_Builder = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    pip_Builder = new PictureInPictureParams.Builder();
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    pip_Builder.setAspectRatio(ratio).build();
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    enterPictureInPictureMode(pip_Builder.build());
                }
            }
        });
    }
}