package com.example.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.prabhat1707.verticalpager.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IFireStoreLoadDone {

    VerticalViewPager viewPager;
    VerticalPagerAdapter adapter;

    CollectionReference movies;
    IFireStoreLoadDone iFireStoreLoadDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iFireStoreLoadDone = this;
        movies = FirebaseFirestore.getInstance().collection("Movies") ;

        viewPager = (VerticalViewPager) findViewById(R.id.viewPager);

        getData();


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.ic_profile){
                    Intent intent1 = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(intent1);
                    return true;
                }


                if(item.getItemId() == R.id.ic_match){
                    Intent intent2 = new Intent(MainActivity.this, MatchActivity.class);
                    startActivity(intent2);
                    return true;
                }

                return false;
            }
        });

    }

    

    private void getData() {

        movies.get()
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        iFireStoreLoadDone.onFireStoreLoadFailed(e.getMessage());
                    }
                }).addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if(task.isSuccessful()){
                    List<Movie> movies = new ArrayList<>(); 
                    for(QueryDocumentSnapshot movieSnapShot: task.getResult()){
                        Movie movie = movieSnapShot.toObject(Movie.class);
                        movies.add(movie); 
                    }
                    iFireStoreLoadDone.onFireStoreLoadSuccess(movies);
                }
            }
        }) ;
    }


    @Override
    public void onFireStoreLoadSuccess(List<Movie> movies) {
        adapter = new VerticalPagerAdapter(this, movies);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFireStoreLoadFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
