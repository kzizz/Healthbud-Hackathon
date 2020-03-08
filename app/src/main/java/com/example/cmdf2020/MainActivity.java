package com.example.cmdf2020;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity extends AppCompatActivity {

    public EditText emailId, passwd;
    Button btnSignIn;
    Button btnSignUp;
    TextView signIn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.email);
        passwd = findViewById(R.id.password);
        btnSignIn = findViewById(R.id.loginButton);
        btnSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String emailID = emailId.getText().toString();
                String password = passwd.getText().toString();
                if(emailID.isEmpty()) {
                    emailId.setError("Provide your Email First");
                    emailId.requestFocus();
                } else if (password.isEmpty()) {
                    passwd.setError("Set your password");
                    passwd.requestFocus();
                } else if (emailID.isEmpty() && password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(emailID.isEmpty() && password.isEmpty())){
                    firebaseAuth.signInWithEmailAndPassword(emailID,password).addOnCompleteListener(MainActivity.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this.getApplicationContext(),
                                        "Unsuccessful Login" + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(MainActivity.this, Spontaneous.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
