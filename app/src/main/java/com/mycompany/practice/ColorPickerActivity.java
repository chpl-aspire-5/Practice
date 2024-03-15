package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.mycompany.practice.databinding.ActivityColorPickerBinding;

import yuku.ambilwarna.AmbilWarnaDialog;

public class ColorPickerActivity extends AppCompatActivity {

    ActivityColorPickerBinding binding;
    private int mDefaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_color_picker);
        init();
    }

    public void init() {

        mDefaultColor = 0;

        binding.viewSelectedColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPickerDialogue();
            }
        });

    }

    public void openColorPickerDialogue() {

        final AmbilWarnaDialog colorPickerDialogue = new AmbilWarnaDialog(this, mDefaultColor,
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        mDefaultColor = color;
                        binding.viewSelectedColor.setBackgroundColor(mDefaultColor);
                        binding.tvHeading.setTextColor(mDefaultColor);
                    }
                });

        colorPickerDialogue.show();
    }
}