package com.example.savelives;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Button btnlogout;
    Button essentialServices,report,contact,news;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        essentialServices = findViewById(R.id.b5);
        contact = findViewById(R.id.b4);
        report = findViewById(R.id.b6);
        news = findViewById(R.id.b3);

//        btnlogout = findViewById(R.id.logout);

//        btnlogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Intent inToMain = new Intent(HomeActivity.this, MainActivity.class);
//                startActivity(inToMain);
//            }
//        });

        essentialServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eser = new Intent(HomeActivity.this,EssentialServices.class);
                startActivity(eser);

            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eser = new Intent(HomeActivity.this,ContactTracing.class);
                startActivity(eser);

            }
        });

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eser = new Intent(HomeActivity.this,NewsAndAnnouncements.class);
                startActivity(eser);

            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eser = new Intent(HomeActivity.this,Report.class);
                startActivity(eser);

            }
        });
    }

    public void VServices(View view)
    {
        Intent vser = new Intent(this,VServices.class);
        startActivity(vser);

    }



}
