package com.mycompany.practice.New;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.mycompany.practice.R;
import com.mycompany.practice.databinding.ActivityBottomNavigationBinding;

public class BottomNavigationActivity extends AppCompatActivity {
    final FragmentManager fm = getSupportFragmentManager();
    HomeFragment homeFragment;
    ProfileFragment profileFragment;
    Fragment active = null;
    ActivityBottomNavigationBinding binding;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bottom_navigation);
        init();
    }

    public void init() {
        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        fm.beginTransaction().add(R.id.dash_frag_container, profileFragment, "profileFragment").hide(profileFragment).commit();
        fm.beginTransaction().add(R.id.dash_frag_container, homeFragment, "homeFragment").commit();
        active = homeFragment;

        binding.navView.setSelectedItemId(R.id.navigation_home);
        binding.navView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    fm.beginTransaction().hide(active).show(homeFragment).commit();
                    active = homeFragment;
                } else if (itemId == R.id.navigation_profile) {
                    fm.beginTransaction().hide(active).show(profileFragment).commit();
                    active = profileFragment;
                }
                return true;
            }
        });
    }
}