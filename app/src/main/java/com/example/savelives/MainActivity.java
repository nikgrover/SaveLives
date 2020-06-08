package com.example.savelives;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText registeremail, registerpassword;
    Button btnSignup;
    TextView btnlogin;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = firebaseAuth.getInstance();
        registeremail = findViewById(R.id.registeremail);
        registerpassword = findViewById(R.id.registerpassword);
        btnSignup = findViewById(R.id.btnSignup);
        btnlogin = (TextView) findViewById(R.id.btnlogin);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = registeremail.getText().toString();
                String password = registerpassword.getText().toString();
                if(email.isEmpty()){
                    registeremail.setError("Please enter an email id");
                    registeremail.requestFocus();
                }
                else if(password.isEmpty()){
                    registerpassword.setError("Please enter an email id");
                    registerpassword.requestFocus();
                }else if( email.isEmpty() && password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fields are Empty",Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && password.isEmpty())){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this," Sign up is unsuccessful. Please try again!",Toast.LENGTH_SHORT).show();
                            }else{
                                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                            }
                        }
                    });
                }else {
                    Toast.makeText(MainActivity.this," Error Occured. Please contact the developer!",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //go to login
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
