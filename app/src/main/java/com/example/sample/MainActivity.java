package com.example.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.prabhat1707.verticalpager.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    VerticalViewPager viewPager;
    VerticalPagerAdapter adapter;
    List<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.brochure, "Akshay", "Fun Loving"));
        models.add(new Model(R.drawable.sticker, "Aniket", "Fuck Boii"));
        models.add(new Model(R.drawable.poster, "Abhay", "Travel Enthusiast"));
        models.add(new Model(R.drawable.namecard, "Aman", "Hook Ups Only"));




        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);;

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.ic_profile) {
                    Intent intent1 = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent1);
                    return true;
                }

                if (item.getItemId() == R.id.ic_match) {
                    Intent intent2 = new Intent(MainActivity.this, MatchActivity.class);
                    startActivity(intent2);
                    return true;
                }

                return false;
            }
        });




        initSwipePager();
    }

    private void initSwipePager(){
        VerticalViewPager verticalViewPager = (VerticalViewPager) findViewById(R.id.viewPager);
        verticalViewPager.setAdapter(new VerticalPagerAdapter(models,this));
    }
}
