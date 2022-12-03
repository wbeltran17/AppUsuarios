package com.example.appusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appusuarios.domain.Login;
import com.example.appusuarios.domain.User;
import com.example.appusuarios.services.LoginServices;
import com.example.appusuarios.services.RegisterServices;

public class RegisterActivity extends AppCompatActivity {


    private EditText nameTbx, usernameTbx, passTbx;
    private Button returnBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameTbx = findViewById(R.id.nameTbx);
        usernameTbx = findViewById(R.id.usernameTbx);
        passTbx = findViewById(R.id.passTbx);
        registerBtn = findViewById(R.id.registerUserBtn);
        registerBtn.setOnClickListener(v -> callRegister());
        returnBtn = findViewById(R.id.returnBtn);
        returnBtn.setOnClickListener(v -> onBackPressed());
    }

    public void callRegister() {
        String name = nameTbx.getText().toString();
        String username = usernameTbx.getText().toString();
        String password = passTbx.getText().toString();

        if (name != null && !name.isEmpty() &&
                username != null && !username.isEmpty()
                && password != null && !password.isEmpty()) {
            User user = new User(name, username, password);
            RegisterServices.register(this, user);
        } else {
            Toast.makeText(this, R.string.emptyAccess, Toast.LENGTH_LONG).show();
        }
    }

}