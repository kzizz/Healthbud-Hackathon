package com.example.cmdf2020;

import android.content.Intent;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
        // add btnSignIn findViewById
        btnSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String emailID = emailId.getText().toString();
            }
        });
    }
}
