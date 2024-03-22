package com.mycompany.practice.new1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.mycompany.practice.R;
import com.mycompany.practice.databinding.ActivityAddProductBinding;

public class AddProductActivity extends AppCompatActivity {

    ActivityAddProductBinding binding;

    ActivityResultLauncher<Intent> waitResultForResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_product);
        init();
    }

    public void init() {
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.tvAddNewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCategoryFragment addCategoryFragment = new AddCategoryFragment();
                addCategoryFragment.setCancelable(false);
                addCategoryFragment.show(getSupportFragmentManager(), "Category");
            }
        });
        waitResultForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {
                if (result.getData() != null) {

                }
            }
        });
        binding.imgAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                waitResultForResult.launch(camera_intent);
            }
        });

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddProductActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}