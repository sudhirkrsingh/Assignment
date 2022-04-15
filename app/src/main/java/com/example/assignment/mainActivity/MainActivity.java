package com.example.assignment.mainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.assignment.fragment.HomeFragment;
import com.example.assignment.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // First we will set a default fragment in main activity
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, new HomeFragment())
                .commit();

    }

}