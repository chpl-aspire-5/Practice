package com.mycompany.practice;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.mycompany.practice.databinding.ActivityHmapTrialBinding;

import java.util.HashMap;

public class HmapTrialActivity extends AppCompatActivity {

    ActivityHmapTrialBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hmap_trial);
        init();
    }

    public void init() {
        // Create a HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Add elements to the HashMap
        hashMap.put(25, "John");

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.etvHmapName.getText().toString().trim().equals("") && !binding.etvHmapId.getText().toString().trim().equals("")) {
                    hashMap.put(Integer.valueOf(binding.etvHmapId.getText().toString().trim()), binding.etvHmapName.getText().toString().trim());
                    binding.tvHashMapValves.setText(hashMap + "");
                }
            }
        });

    }
}