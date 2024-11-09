package com.tahhu.coba;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    public Button btninternet;
    public ImageView btn_radio,btn_market, btn_finence, btn_ride, btn_survey, menu_market, menu_finance, menu_ride;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the ImageView

        btninternet = findViewById(R.id.btn_internet);
        btn_finence = findViewById(R.id.finace);
        btn_market = findViewById(R.id.market);
        btn_ride = findViewById(R.id.ride);
        btn_survey = findViewById(R.id.survey);
        menu_market = findViewById(R.id.menumarket);
        menu_finance = findViewById(R.id.menufavorite);
        menu_ride = findViewById(R.id.menuride);
        btn_radio = findViewById(R.id.radio);

        // Set an OnClickListener
        btninternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://tahhu.com";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        btn_radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event, for example, open another activity
                Intent intent = new Intent(MainActivity.this, RadioStreamin.class);
                startActivity(intent);
            }
        });
        btn_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event, for example, open another activity
                Intent intent = new Intent(MainActivity.this, Marketpalce.class);
                startActivity(intent);
            }
        });
        btn_finence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event, for example, open another activity
                Intent intent = new Intent(MainActivity.this, finance.class);
                startActivity(intent);
            }
        });
        btn_ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event, for example, open another activity
                Intent intent = new Intent(MainActivity.this, rideSharing.class);
                startActivity(intent);
            }
        });
        btn_survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event, for example, open another activity
                Intent intent = new Intent(MainActivity.this, Survey.class);
                startActivity(intent);
            }
        });
        menu_market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event, for example, open another activity
                Intent intent = new Intent(MainActivity.this, Marketpalce.class);
                startActivity(intent);
            }
        });
        menu_finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event, for example, open another activity
                Intent intent = new Intent(MainActivity.this, finance.class);
                startActivity(intent);
            }
        });
        menu_ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click event, for example, open another activity
                Intent intent = new Intent(MainActivity.this, rideSharing.class);
                startActivity(intent);
            }
        });

    }
}