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
    public ImageView btn_radio ;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the ImageView

        btninternet = findViewById(R.id.btn_internet);
        btn_radio = findViewById(R.id.radio);



//        tambahbarang = findViewById(R.id.tambahmobil);
//

        // Set an OnClickListener
        btninternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "10.45.1.1";
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
    }
}