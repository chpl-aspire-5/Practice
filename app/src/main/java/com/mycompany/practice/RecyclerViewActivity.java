package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.mycompany.practice.databinding.ActivityRecyclerViewBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class RecyclerViewActivity extends AppCompatActivity {

    ActivityRecyclerViewBinding binding;
    ListAdapter listAdapter;
    ImageView imgPrevious, imgNext, imgHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);

        listAdapter = new ListAdapter(RecyclerViewActivity.this);

        imgPrevious = findViewById(R.id.imgPrevious);

        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecyclerViewActivity.this, SpinkitActivity.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecyclerViewActivity.this, StateProgressBarActivity.class));
                finish();
            }
        });

        imgHome = findViewById(R.id.imgHome);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecyclerViewActivity.this, FirstActivity.class));
                finish();
            }
        });

        binding.recyclerViewList.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
        binding.recyclerViewList.setAdapter(listAdapter);

        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.swipeRefresh.setRefreshing(false);
            }
        });
    }
}