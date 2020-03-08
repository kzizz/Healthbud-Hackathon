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
        this.name = name;
        this.workout_pref = workout_pref;
        this.city = city;
        this.age = age;
        this.fitness_lvl = fitness_lvl;
        this.workout_freq = workout_freq;
        this.is_mom = is_mom;
        this.is_senior = is_senior;
        this.is_student = is_student;
        this.is_injured = is_injured;
    }

    public Profile(FirebaseFirestore db) {
        this.db = db; // assume a firestore database object is passed in
        this.name = "name";
        this.workout_pref = "workout_pref";
        this.city = "city";
        this.age = 0;
        this.fitness_lvl = 0;
        this.workout_freq = 0;
        this.is_mom = true;
        this.is_senior = true;
        this.is_student = true;
        this.is_injured = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        // TODO: update database
    }

    public String getWorkout_pref() {
        return workout_pref;
    }

    public void setWorkout_pref(String pref) {
        this.workout_pref = pref;
        // TODO: update database
    }
    public String getCity() {
        return city;
    }

    public void setCity(String name) {
        this.city = city;
        // TODO: update database
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        // TODO: update database
    }
    public int getFitness_lvl() {
        return fitness_lvl;
    }

    public void setFitness_lvl(int fitness) {
        this.fitness_lvl = fitness;
        // TODO: update database
    }
}
