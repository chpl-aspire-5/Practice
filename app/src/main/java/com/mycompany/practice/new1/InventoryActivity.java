package com.mycompany.practice.new1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mycompany.practice.R;
import com.mycompany.practice.databinding.ActivityInventoryBinding;

public class InventoryActivity extends AppCompatActivity {

    ActivityInventoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inventory);
        init();
    }

    public void init() {
        ItemsAdapter itemsAdapter = new ItemsAdapter();
        binding.recItems.setLayoutManager(new LinearLayoutManager(InventoryActivity.this, LinearLayoutManager.VERTICAL, false));
        binding.recItems.setAdapter(itemsAdapter);
    }
}