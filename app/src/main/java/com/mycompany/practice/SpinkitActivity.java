package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.CubeGrid;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.FoldingCube;
import com.github.ybq.android.spinkit.style.RotatingCircle;
import com.github.ybq.android.spinkit.style.RotatingPlane;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;

import com.mycompany.practice.databinding.ActivitySpinkitBinding;

public class SpinkitActivity extends AppCompatActivity {

    ActivitySpinkitBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_spinkit);

        binding.imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SpinkitActivity.this,RecyclerViewActivity.class));
                finish();
            }
        });

        Sprite doubleBounce = new DoubleBounce();
        binding.spinkitDoubleBounce.setIndeterminateDrawable(doubleBounce);

        Sprite rotatingPlane = new RotatingPlane();
        binding.spinkitRotatingPlane.setIndeterminateDrawable(rotatingPlane);

        Sprite wave = new Wave();
        binding.spinkitWave.setIndeterminateDrawable(wave);

        Sprite wanderingCubes = new WanderingCubes();
        binding.spinkitWanderingCubes.setIndeterminateDrawable(wanderingCubes);

        Sprite foldingCube = new FoldingCube();
        binding.spinkitFoldingCube.setIndeterminateDrawable(foldingCube);

        Sprite cubeGrid = new CubeGrid();
        binding.spinkitCubeGrid.setIndeterminateDrawable(cubeGrid);

        Sprite threeBounce = new ThreeBounce();
        binding.spinkitThreeBounce.setIndeterminateDrawable(threeBounce);

        Sprite rotatingCircle = new RotatingCircle();
        binding.spinkitRotatingCircle.setIndeterminateDrawable(rotatingCircle);
    }

}