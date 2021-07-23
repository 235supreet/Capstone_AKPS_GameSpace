package com.example.akps_capstone_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    TextView signUpStatus, loginSignUp;
    EditText name, email, phone, password, confirmPassword;
    Button signUp;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.signUpName);
        email = findViewById(R.id.signUpMail);
        phone = findViewById(R.id.signUpPhone);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);
        signUpStatus = findViewById(R.id.signUpStatus);
        signUp = findViewById(R.id.signUp);
        loginSignUp = findViewById(R.id.loginSignUp);
        dbHelper = new DBHelper(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().equals("") || email.getText().toString().equals("") || phone.getText().toString().equals("") || password.getText().toString().equals("") || confirmPassword.getText().toString().equals("")) {
                    signUpStatus.setText("All fields are mandatory.");
                    signUpStatus.setTextColor(Color.parseColor("#ff0000"));
                }
                else {
                    boolean res = dbHelper.insert(name.getText().toString(), email.getText().toString(), phone.getText().toString(), password.getText().toString());
                    if (res) {
                        signUpStatus.setTextColor(Color.parseColor("#00ff00"));
                        signUpStatus.setText("Account created successfully");
                        name.setText("");
                        email.setText("");
                        phone.setText("");
                        password.setText("");
                        confirmPassword.setText("");
                        try {
                            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                        }
                        catch (Exception e) {
                            System.out.println("Task failed");
                        }
                    }

                }
            }
        });

        loginSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}