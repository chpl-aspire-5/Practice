package com.mycompany.practice;

import androidx.core.content.ContextCompat;

import android.os.Bundle;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;

public class IntroSlider extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // below line is for adding the new slide to our app.
        // we are creating a new instance and inside that
        // we are adding the title, description, image and
        // background color for our slide.
        // below line is use for creating first slide
        addSlide(AppIntroFragment.newInstance("Page 1", "Demo 1",
                R.drawable.home, ContextCompat.getColor(getApplicationContext(), R.color.red)));

        // below line is for creating second slide.
        addSlide(AppIntroFragment.newInstance("Page 2", "Demo 2",
                R.drawable.home, ContextCompat.getColor(getApplicationContext(), R.color.red)));

        // below line is use to create third slide.
        addSlide(AppIntroFragment.newInstance("Page 3", "Demo 3",
                R.drawable.home, ContextCompat.getColor(getApplicationContext(), R.color.red)));

//        @Override
//        protected void onSkipPressed(Fragment currentFragment) {
//            super.onSkipPressed(currentFragment);
//            finish();
//        }
//
//        @Override
//        protected void onDonePressed(Fragment currentFragment) {
//            super.onDonePressed(currentFragment);
//            finish();
//        }
    }
}