package com.example.cmdf2020;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public  void pullData(String UID){
        DocumentReference docRef = db.collection("users").document(UID);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();

                    if (document.exists()) {
                        List<String> dataFields = new ArrayList<>();

                        Map<String, Object> map = document.getData();

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

    public void getName() {

    }
}
