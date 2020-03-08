package com.example.cmdf2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class match_profile extends AppCompatActivity {
    int profileNumber;

    match_profile(int profileNumber){
        this.profileNumber= profileNumber;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_profile);
    }
}
