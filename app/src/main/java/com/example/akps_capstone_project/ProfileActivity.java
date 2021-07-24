package com.example.akps_capstone_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    DBHelper dbHelper;
    SharedPreference sharedPreference;
    TextView name, mail, phone, points;
    Activity context=this;
    Button logOut;
    View coupon1, coupon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottomNavigation();

        dbHelper = new DBHelper(this);
        name = findViewById(R.id.tv_name);
        mail = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        points = findViewById(R.id.points);
        logOut = findViewById(R.id.logOut);
        coupon1 = findViewById(R.id.promo1);
        coupon2 = findViewById(R.id.promo2);
        sharedPreference=new SharedPreference();

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreference.clearSharedPreference(context);
                Intent i= new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        showData();
    }

    public void showData() {
        Cursor result = dbHelper.getAll();
        while(result.moveToNext()){
            String n = result.getString(0);
            String m = result.getString(1);
            String p = result.getString(2);
            int s = result.getInt(4);
            String sc = String.valueOf(s);
            name.setText(n);
            mail.setText(m);
            phone.setText(p);
            points.setText(sc);
        }
    }

    private void bottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.user);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        return true;
                    case R.id.vip:
                        startActivity(new Intent(getApplicationContext(), VIPActivity.class));
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        return true;
                    case R.id.contact:
                        startActivity(new Intent(getApplicationContext(),ContactUsActivity.class));
                        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                        return true;
                    case R.id.user:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}