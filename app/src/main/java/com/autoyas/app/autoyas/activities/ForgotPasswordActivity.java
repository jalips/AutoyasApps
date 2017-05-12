package com.autoyas.app.autoyas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.autoyas.app.autoyas.R;
import com.autoyas.app.autoyas.utils.Network;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText input_email;
    private Button button_send_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        input_email = (EditText) findViewById(R.id.input_email);
        button_send_email = (Button) findViewById(R.id.button_send_email);

        button_send_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Network.isInternet(ForgotPasswordActivity.this)) {

                    if (input_email.getText().toString().equals("")) {

                        Toast toast = Toast.makeText(ForgotPasswordActivity.this, "Wrong credentials", Toast.LENGTH_SHORT);
                        toast.show();

                    } else {
                        // sent email for new password
                        //
                        //

                        Toast toast = Toast.makeText(ForgotPasswordActivity.this, "Email sent : check your inbox", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                } else {
                    Toast toast = Toast.makeText(ForgotPasswordActivity.this, "No internet connection", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}
