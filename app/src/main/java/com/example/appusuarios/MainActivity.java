package com.example.appusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appusuarios.domain.Login;
import com.example.appusuarios.services.LoginServices;

public class MainActivity extends AppCompatActivity {

    private EditText userNameTbx, passwordTbx;
    private Button loginBtn, registerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userNameTbx = findViewById(R.id.userTbx);
        passwordTbx = findViewById(R.id.passwordTbx);
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(v -> callLogin());
        registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(v -> setRegister());
    }

    public void callLogin() {
        String user = userNameTbx.getText().toString();
        String password = passwordTbx.getText().toString();

        if (user != null && !user.isEmpty()
                && password != null && !password.isEmpty()) {
            Login login = new Login(user, password);
            LoginServices.login(MainActivity.this, login);
        } else {
            Toast.makeText(MainActivity.this, R.string.emptyAccess, Toast.LENGTH_LONG).show();
        }
    }

    public void setRegister() {
        Intent setHome = new Intent(this, RegisterActivity.class);
        startActivity(setHome);
    }
}