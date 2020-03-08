package com.example.cmdf2020;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.*;
import java.util.Map;
import java.util.HashMap;

public class Profile {
    private String name, workout_pref, city;
    private int age, fitness_lvl, workout_freq;
    boolean is_mom, is_senior, is_student, is_injured;
    FirebaseFirestore db;
    String id;
    final String TAG = "helloworld";


    public Profile(FirebaseFirestore db,
                   String name, String workout_pref, String city,
                   int age, int fitness_lvl, int workout_freq,
                   boolean is_mom, boolean is_senior, boolean is_student, boolean is_injured) {
        this.db = db; // assume a firestore database object is passed in
    }

    public String getName() {

    }
}
