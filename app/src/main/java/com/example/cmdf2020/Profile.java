package com.example.cmdf2020;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {
    private String name, workout_pref, city;
    private int age, fitness_lvl;
    boolean is_mom, is_senior, is_student, is_injured;
    FirebaseFirestore db;
    String id;
    final String TAG = "helloworld";

    public Profile(FirebaseFirestore db,
                   String name, String workout_pref, String city,
                   int age, int fitness_lvl,
                   boolean is_mom, boolean is_student, boolean is_injured) {
        this.db = db; // assume a firestore database object is passed in
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

    public Profile(FirebaseFirestore db) {
        this.db = db; // assume a firestore database object is passed in
        this.name = "name";
        this.workout_pref = "workout_pref";
        this.city = "city";
        this.age = 0;
        this.fitness_lvl = 0;
        this.is_mom = true;
        this.is_senior = true;
        this.is_student = true;
        this.is_injured = true;
    }

    public Profile(FirebaseFirestore db, HashMap<String, Object> profile) {
        this.db = db;
        setProfileFromMap(profile);
    }
    public void pullData(String UID){
        DocumentReference docRef = db.collection("users").document(UID);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    if (document.exists()) {
                        Map<String, Object> map = document.getData();
                        setProfileFromMap(map);
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    public List<Profile> pullAllUsers(){
        List<Profile> allUsers = new ArrayList<Profile>();
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Map<String, Object> map = document.getData();
//                                Profile currentUser = new Profile();
//                                currentUser.setProfileFromMap(map);
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
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
    }

    public boolean is_senior() {
        return is_senior;
    }

    public void set_senior_status(boolean is_mom) {
        this.is_mom = is_mom;
    }

    private void setProfileFromMap(Map<String, Object> profile) {
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

}
