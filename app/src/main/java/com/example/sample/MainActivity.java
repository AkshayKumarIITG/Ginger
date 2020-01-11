package com.example.sample;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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


        initSwipePager();
    }

    private void initSwipePager(){
        VerticalViewPager verticalViewPager = (VerticalViewPager) findViewById(R.id.viewPager);
        verticalViewPager.setAdapter(new VerticalPagerAdapter(models,this));
    }
}
