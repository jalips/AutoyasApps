package com.autoyas.app.autoyas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.autoyas.app.autoyas.R;
import com.autoyas.app.autoyas.utils.Network;

public class RegisterActivity extends AppCompatActivity {

    private EditText input_email;
    private EditText input_password;
    private Button button_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        input_email = (EditText) findViewById(R.id.input_email);
        input_password = (EditText) findViewById(R.id.input_password);
        button_sign_up = (Button) findViewById(R.id.button_sign_up);

        button_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            if(Network.isInternet(RegisterActivity.this)) {

                if (input_email.getText().toString().equals("") || input_password.getText().toString().equals("")) {

                    Toast toast = Toast.makeText(RegisterActivity.this, "Wrong credentials", Toast.LENGTH_SHORT);
                    toast.show();

                } else {
                    // do registeration
                    //
                    //

                    Toast toast = Toast.makeText(RegisterActivity.this, "Welcome, your registeration done !", Toast.LENGTH_SHORT);
                    toast.show();
                }

            } else {
                Toast toast = Toast.makeText(RegisterActivity.this, "No internet connection", Toast.LENGTH_SHORT);
                toast.show();
            }
            }
        });
    }
}
