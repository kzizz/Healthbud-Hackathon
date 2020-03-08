package com.example.cmdf2020;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Profile {
    private String name, id, workout_pref, city;
    private int age, fitness_lvl;
    boolean is_mom, is_senior, is_student, is_injured;
    FirebaseFirestore db;
    String id;

    public Profile(String name, String id, String workout_pref, String city,
                   int age, int fitness_lvl,
                   boolean is_mom, boolean is_student, boolean is_injured) {
        this.db = FirebaseFirestore.getInstance();
        this.id = id;
        this.name = name;
        this.workout_pref = workout_pref;
        this.city = city;
        this.age = age;
        this.fitness_lvl = fitness_lvl;
        this.is_mom = is_mom;
        this.is_senior = age > 65;
        this.is_student = is_student;
        this.is_injured = is_injured;
    }

    public Profile() {
        this.db = FirebaseFirestore.getInstance();
        this.name = "name";
        this.id = "id";
        this.workout_pref = "workout_pref";
        this.city = "city";
        this.age = 0;
        this.fitness_lvl = 0;
        this.is_mom = true;
        this.is_senior = true;
        this.is_student = true;
        this.is_injured = true;
    }

    public Profile(HashMap<String, Object> profile) {
        this.db = FirebaseFirestore.getInstance();
        // TODO: add grabbing ID
        setProfileFromMap(profile);
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

    public boolean is_mom() {
        return is_mom;
    }

    public void set_mom_status(boolean is_mom) {
        this.is_mom = is_mom;
        // TODO: update database
    }

    public boolean is_senior() {
        return is_senior;
    }

    public boolean is_student() {
        return is_student;
    }

    public void set_student_status(boolean is_student) {
        this.is_student = is_student;
        // TODO: update database
    }

    public boolean is_injured() {
        return is_injured;
    }

    public void set_injured_status(boolean is_injured) {
        this.is_injured = is_injured;
        // TODO: update database
    }
    private void setProfileFromMap(HashMap<String, Object> profile) {
        this.name = (String) profile.get("name");
        this.workout_pref = (String) profile.get("workoutPreference");
        this.city = (String) profile.get("Location");
        this.age = (int) profile.get("age");
        this.fitness_lvl = (int) profile.get("fitnessLevel");
        this.is_mom = (boolean) profile.get("isMom");
        this.is_senior = (boolean) profile.get("isSenior");
        this.is_student = (boolean) profile.get("isStudent");
        this.is_injured = (boolean) profile.get("isInjured");
    }

    public List<Profile> getMatchList(List<Profile> profiles) {
        return null;
    }
}
