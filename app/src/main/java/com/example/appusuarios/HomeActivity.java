package com.example.appusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView nameLbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String name = getIntent().getStringExtra("name");
        nameLbl = findViewById(R.id.nameHomeLbl);
        nameLbl.setText(name);
    }
}