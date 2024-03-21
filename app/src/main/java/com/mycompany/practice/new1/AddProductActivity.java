package com.mycompany.practice.new1;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mycompany.practice.R;
import com.mycompany.practice.databinding.ActivityAddProductBinding;

public class AddProductActivity extends AppCompatActivity {

    ActivityAddProductBinding binding;

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

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddProductActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}