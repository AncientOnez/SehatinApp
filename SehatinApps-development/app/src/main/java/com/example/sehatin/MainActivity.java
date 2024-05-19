package com.example.sehatin;

import static com.example.sehatin.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.sehatin.databinding.ActivityMainBinding;
import com.example.sehatin.fragments.DashboardFragment;
import com.example.sehatin.fragments.ExploreFragment;
import com.example.sehatin.fragments.ProfileFragment;
import com.example.sehatin.fragments.SavedFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new DashboardFragment());
        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == id.home) {
                replaceFragment(new DashboardFragment());
            } else if (itemId == id.explore) {
                replaceFragment(new ExploreFragment());
            } else if (itemId == id.profile) {
                replaceFragment(new ProfileFragment());
            } else if (itemId == id.saved) {
                replaceFragment(new SavedFragment());
            }
            return true;
        });


        binding.uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}