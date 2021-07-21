package com.example.akps_capstone_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    Button login,signup;
    TextView register,loginStatus;
    EditText nameph,pass;
    DBHelper dbHelper;
    String name,passwordStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=findViewById(R.id.login);
        signup=findViewById(R.id.signUp);
        register=findViewById(R.id.register);
        nameph=findViewById(R.id.emailLogin);
        pass=findViewById(R.id.passwordd);
        loginStatus=findViewById(R.id.loginStatus);
        dbHelper = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = dbHelper.getAll();
                String record ="";
                if (!pass.getText().toString().equals("") || !nameph.getText().toString().equals("")) {
                    while (result.moveToNext()) {
                        name = result.getString(0);
                        passwordStr = result.getString(3);
                        record += "NAME: " + name + ", PASSWORD: " + pass + "\n";

                        if (pass.getText().toString().equals(passwordStr) && nameph.getText().toString().equals(name)) {
                            loginStatus.setText("");
                            Intent i= new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(i);
                        }

                        else if (!pass.getText().toString().equals(passwordStr) && !nameph.getText().toString().equals(name)){
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
}