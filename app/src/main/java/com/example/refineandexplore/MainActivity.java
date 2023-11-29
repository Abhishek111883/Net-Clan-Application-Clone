package com.example.refineandexplore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RefineFragment refinefragments = new RefineFragment();
        ExploreFragment exploreFragment = new ExploreFragment();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(MainActivity.this);


        // Load the initial fragment
        loadFragment(refinefragments);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        // Change icon color based on the selected fragment
        if (itemId == R.id.refine) {
            loadFragment(new RefineFragment() );
            return true;
        } else if (itemId == R.id.explore) {
            loadFragment(new ExploreFragment());
            return true;
            // Add more cases for other fragments as needed
        }

        return false;
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout, fragment)
                .commit();
    }


}