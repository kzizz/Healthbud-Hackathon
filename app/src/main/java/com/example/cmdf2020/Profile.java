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
        Map<String, Object> user = new HashMap<>();
        user.put("name", name);
        user.put("workout_pref", workout_pref);
        user.put("city", city);
        user.put("age", age);
        user.put("fitness level", fitness_lvl);
        user.put("workout_freq", workout_freq);
        user.put("is_mom", is_mom);
        user.put("is_senior", is_senior);
        user.put("is_injured", is_injured);

        db.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    public String name() {
        return db.collection("users").document()
    }
}
