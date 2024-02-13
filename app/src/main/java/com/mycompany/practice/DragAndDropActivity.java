package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mycompany.practice.databinding.ActivityDragAndDropBinding;

public class DragAndDropActivity extends AppCompatActivity {

    ActivityDragAndDropBinding binding;
    ImageView imgPrevious, imgNext, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_drag_and_drop);
        init();
    }

    public void init() {

        imgPrevious = findViewById(R.id.imgPrevious);
        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DragAndDropActivity.this, CurrencyConversion.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DragAndDropActivity.this, PipActivity.class));
                finish();
            }
        });

        imgHome = findViewById(R.id.imgHome);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DragAndDropActivity.this, FirstActivity.class));
                finish();
            }
        });

        for (int i = 0; i < binding.container.getChildCount(); i++) {

            // below is the child inside dragger layout
            View child = binding.container.getChildAt(i);

            // below line will set all children draggable
            // except the header layout.
            // the child is its own drag handle.
            binding.container.setViewDraggable(child, child);
        }
    }
}