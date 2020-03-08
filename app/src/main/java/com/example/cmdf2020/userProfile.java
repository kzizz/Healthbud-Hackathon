package com.example.cmdf2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class userProfile extends AppCompatActivity {
    ImageView spontaneousBtn;
    String [] fitnessLevel = {"3", "1", "4"};
    //To change when Profile is fully implemented
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        spontaneousBtn = findViewById(R.id.spontaneousButton);
        spontaneousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(userProfile.this, Spontaneous.class));
            }
        });
//        ImageView imageView_userPhoto = findViewById(R.id.userPhoto);
        TextView textView_userName = findViewById(R.id.userName);
        TextView textView_userLocation = findViewById(R.id.userLocation);
        TextView textView_userFitnessLevel =  findViewById(R.id.userFitnessLevelInput);
        TextView textView_userWorkoutPref = findViewById(R.id.userWorkoutPref);
        TextView textView_userAge = findViewById(R.id.userAge);

//      Create dummy profile until database is integrated
        Profile myProfile = new Profile(db, "Krysten Zissos", "Running", "Vancouver", 20, 4, false, true, true);

//        imageView_userPhoto.setImageResource(myProfile.getProfilePicture());
        textView_userName.setText("Name: "+ myProfile.getName());
        textView_userWorkoutPref.setText("Preferred Workout: " + myProfile.getWorkout_pref());
        textView_userLocation.setText("City: " + myProfile.getCity());
        textView_userFitnessLevel.setText("Fitness Level: " + myProfile.getFitness_lvl());
        textView_userAge.setText("Age: "+myProfile.getAge());
    }
}
