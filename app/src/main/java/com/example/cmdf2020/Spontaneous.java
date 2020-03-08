package com.example.cmdf2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class Spontaneous extends AppCompatActivity {
    ImageView profileBtn;
    int[] profilePic = {R.drawable.stock_1, R.drawable.fella, R.drawable.stock_0};
//    String[] name = {"Mackenzie", "Hyacinth", "Tia"};
//    String[] workout = {"Sitting", "Jogging", "Biking"};
//    String[] location = {"Vancouver", "Toronto", "Grand Forks"};
//    String [] fitnessLevel = {"3", "1", "4"};

//    List<Profile> matches;
    List<Profile> matches;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spontaneous);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        matches = new Profile().getMatchList();
//        matches.add(new Profile());
//        matches.add(new Profile());
//        matches.add(new Profile());

        profileBtn = findViewById(R.id.profileButton);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Spontaneous.this, userProfile.class));
            }
        });
        ListView listView = findViewById(R.id.matchList);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return profilePic.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.linearlayout,null);
            ImageView imageView = view.findViewById(R.id.profilePic);
            TextView textView_name = view.findViewById(R.id.userName);
            TextView textView_workout = view.findViewById(R.id.workoutInput);
            TextView textView_location = view.findViewById(R.id.locationInput);
            TextView textView_fitnessLevel = view.findViewById(R.id.fitnessLevelInput);

            imageView.setImageResource(profilePic[i]);
            textView_name.setText(matches.get(i).getName());//name[i]);
            textView_workout.setText("Preferred Workout:  " + matches.get(i).getWorkout_pref());//+ workout[i]);
            textView_location.setText("City:  " + matches.get(i).getCity()); //+ location[i]);
            textView_fitnessLevel.setText("Fitness Level:  " + matches.get(i).getFitness_lvl());//+ fitnessLevel[i]);
//                textView_fitnessLevel.setText("List length:  " + matches.size());//+ fitnessLevel[i]);


            return view;
        }
    }

}


