package com.example.cmdf2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class register_page extends AppCompatActivity {
    public EditText emailId, passwd;
     TextView btnLogin;
     Button btnSignUp;
     FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        firebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.emailSignup);
        passwd = findViewById(R.id.passwordSignup);
        btnSignUp = findViewById(R.id.registerButton);
        btnLogin = findViewById(R.id.signIn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register_page.this, MainActivity.class));
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener(){
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
                    Toast.makeText(register_page.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(emailID.isEmpty() && password.isEmpty())){
                    firebaseAuth.createUserWithEmailAndPassword(emailID,password).addOnCompleteListener(register_page.this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {

                            if (!task.isSuccessful()) {
                                Toast.makeText(register_page.this.getApplicationContext(),
                                        "SignUp unsuccessful: " + task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(register_page.this, Spontaneous.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(register_page.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
