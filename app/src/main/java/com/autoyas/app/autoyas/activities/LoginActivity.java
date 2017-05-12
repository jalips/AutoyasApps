package com.autoyas.app.autoyas.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.autoyas.app.autoyas.R;
import  com.autoyas.app.autoyas.entities.User;

public class LoginActivity extends AppCompatActivity {

    private EditText input_username;
    private EditText input_password;
    private TextView link_forgot_password;
    private Button button_login;
    private TextView link_register;

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Map all widget
        input_username = (EditText) findViewById(R.id.input_username);
        input_password = (EditText) findViewById(R.id.input_password);
        link_forgot_password = (TextView) findViewById(R.id.link_forgot_password);
        button_login = (Button) findViewById(R.id.button_login);
        link_register = (TextView) findViewById(R.id.link_register);

        input_username.setText(sharedPref.getString("input_username", ""));
        input_password.setText(sharedPref.getString("input_password", ""));

        // Method for login button
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Test for fake "admin" and "admin" password (after in db)
                if (input_username.getText().toString().equals("admin") && input_password.getText().toString().equals("pass")) {

                    // save password
                    sharedPref.edit().putString("input_username", input_username.getText().toString()).apply();
                    sharedPref.edit().putString("input_password", input_password.getText().toString()).apply();

                    // Here create a fake user (or get him on db)
                    User currentUser = new User();
                    currentUser.setLogin("admin");
                    currentUser.setPassword("pass");

                    // save password here
                    // ...
                    // ...

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast toast = Toast.makeText(LoginActivity.this, "Wrong credentials", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        // Method for forgot password
        link_forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });

        // Method for register
        link_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}
