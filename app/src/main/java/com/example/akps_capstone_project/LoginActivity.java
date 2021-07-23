package com.example.akps_capstone_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button login, signup;
    TextView register, loginStatus;
    EditText nameLogin, passLogin;
    DBHelper dbHelper;
    String name, passwordStr;
    private SharedPreference sharedPreference;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=findViewById(R.id.login);
        signup=findViewById(R.id.signUp);
        register=findViewById(R.id.register);
        nameLogin =findViewById(R.id.emailLogin);
        passLogin =findViewById(R.id.passwordd);
        loginStatus=findViewById(R.id.loginStatus);
        dbHelper = new DBHelper(this);
        sharedPreference = new SharedPreference();
        sharedPreference.clearSharedPreference(context);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = dbHelper.getAll();
                String record ="";

                if (!passLogin.getText().toString().equals("") || !nameLogin.getText().toString().equals("")) {
                    while (result.moveToNext()) {
                        name = result.getString(0);
                        passwordStr = result.getString(3);
                        record += "NAME: " + name + ", PASSWORD: " + passLogin + "\n";

                        if (passLogin.getText().toString().equals(passwordStr) && nameLogin.getText().toString().equals(name)) {
                            loginStatus.setText("");
                            sharedPreference.save(context, nameLogin.getText().toString());
                            Intent i= new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(i);
                        }
                        else if (!passLogin.getText().toString().equals(passwordStr) && !nameLogin.getText().toString().equals(name)){
                            loginStatus.setText("Invalid credentials");
                            loginStatus.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    loginStatus.setText("");
                                }
                            }, 2000);
                        }
                    }
                }
                else {
                    loginStatus.setText("Enter a valid Name/Password");
                    loginStatus.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            loginStatus.setText("");
                        }
                    }, 2000);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}